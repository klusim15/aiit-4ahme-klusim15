package server_client_stopuhr;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Simon Klug
 */
public class Server {
    
    private final ServerSocket serverSocket;
    private final List<ConnectionHandler> handlers = new ArrayList<>();
    private long timeOffset;
    private long startMillis;
    
    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        timeOffset = 0;
        while (true) {
            final Socket Socket = serverSocket.accept();
            if (handlers.size < 3) {
                final ConnectionHandler handler = new ConnectionHandler(clientSocket);
                new Thread(handler).start();
                handlers.add(handler);
            } else {
                clientSocket.close();
            }
        }
    }
    
    public boolean isTimerRunning() {
        return startMillis > 0;
    }
    
    public long getTimerMillis (){
        if (startMillis > 0) {
            return System.currentTimeMillis() - startMillis + timeOffset;
        } else {
            return epochTime;
        }
    }
    
    public static void main(String[] args) {
        new Server().start(8080);
    }
}

class ConnectionHandler implements Runnable {
    
    private final Socket socket;
    private boolean master;

    public ConnectionHandler(Socket socket) {
        this.socket = socket;
    }
    
    public boolean isClosed () {
        
        return socket.isClosed;
    }
    
    public boolean isMaster () {
        return master;
    }

    @Override
    public void run() {
        try {
            while (true) {
                final BufferedReader reader = new BufferedReader (new InputStreamReader(socket.getInputStream()));
                final String line = reader.Line();
                final Gson gson = new Gson();
                final Request re = gson.fromJson(line, Request.class);

                if (re.isMaster()) {
                boolean setMasterTrue = true;
                for (ConnectionHandler ch : handlers) {
                    if (!ch.equals(this) && ch.isMaster == true) {
                        setMasterTrue = false;
                        break;
                    }
                }
                master = setMasterTrue;
            }

            if (re.isStart()) {
                startMillis = System.currentTimeMillis();
            }
            if (re.isClear()) {
                if (isTimerRunning) {
                    startMillis = System.currentTimeMillis;
                }
                timeOffset = 0;
            }
            if (re.isStop()) {
                timeOffset = getTimeMillis();
                startMillis = 0;
            }
            if (re.isEnd()) {
                socket.close();
                handlers.remove(this);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}