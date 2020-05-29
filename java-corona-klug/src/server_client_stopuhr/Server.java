package server_client_stopuhr;

/**
 *
 * @author Simon Klug
 */
import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

public class Server {

    private ServerSocket serversocket;
    private final List<ConnectionHandler> handlers = new ArrayList<>();
    private long timeOffset;
    private long startMillis;

    public void start(int port) throws IOException {
        serversocket = new ServerSocket(port);
        System.out.println("Server auf Port " + port + " gestartet!");
        while (true) {
            final Socket socket = serversocket.accept();
            synchronized (handlers) {
                ConnectionHandler removeHandler = null;
                boolean remove = false;
                for (ConnectionHandler h : handlers) {
                    if (h.isClosed()) {
                        removeHandler = h;
                        remove = true;
                    }
                }
                if (remove) {
                    handlers.remove(removeHandler);
                }
                if (handlers.size() == 3) {
                    socket.close();
                    continue;
                }
            }

            final ConnectionHandler handler = new ConnectionHandler(socket);
            new Thread(handler).start();
            synchronized (handler) {
                handlers.add(handler);
            }
        }
    }

    public boolean isTimerRunning() {
        synchronized (handlers) {
            return startMillis > 0;
        }
    }

    public long getTimerMillis() {
        synchronized (handlers) {
            if (startMillis > 0) {
                return System.currentTimeMillis() - startMillis + timeOffset;
            } else {
                return timeOffset;
            }
        }
    }

    public static void main(String[] args) throws IOException {
        new Server().start(8080);
    }

    private class ConnectionHandler implements Runnable {

        private Socket socket;
        private boolean master;

        public ConnectionHandler(Socket socket) {
            this.socket = socket;
        }

        public boolean isClosed() {
            return socket.isClosed();
        }

        public boolean isMaster() {
            return master;
        }

        @Override
        public void run() { // für die Hintergrundthreads
            long count = 0;

            try {
                while (true) {
                    final BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
                    final OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
                    final String line = reader.readLine(); // Zeichen werden in line gespeichert 

                    if (line == null) {
                        socket.close();
                        return;
                    }

                    count++;

                    final Gson gson = new Gson();
                    gson.toJson(line);//die neuen Zeilen werden in ein Objekt gespeichert
                    System.out.println(line);
                    final Request req = gson.fromJson(line, Request.class); //neues Request Objekt, welches die Zeichen beinhaltet
                    System.out.println(req);

                    if (req.isMaster()) {
                        master = true;
                        synchronized (handlers) {
                            for (ConnectionHandler c : handlers) {
                                if (c != this && c.isMaster() == true) {
                                    master = false;
                                    //response zurücksenden--------------------------
                                    break;
                                }
                            }
                        }
                    }
                    synchronized (handlers) {
                        if (master) {
                            if (req.isStart()) {
                                startMillis = System.currentTimeMillis();
                            }

                            if (req.isClear()) {
                                if (isTimerRunning()) {
                                    startMillis = System.currentTimeMillis();
                                }
                                timeOffset = 0;
                            }

                            if (req.isStop()) {
                                timeOffset = getTimerMillis();
                                startMillis = 0;
                            }

                            if (req.isEnd()) {

                                handlers.remove(this);
                                //Server schließen-----------------------------
                                serversocket.close();
                                socket.close();
                                return;
                            }
                        }
                    }
                    //Response
                    final Response resp = new Response(master, count, isTimerRunning(), getTimerMillis());
                    System.out.println(resp);
                    final String respString = gson.toJson(resp);
                    System.out.println(respString);
                    writer.write(respString);
                    writer.flush();
                }

            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
