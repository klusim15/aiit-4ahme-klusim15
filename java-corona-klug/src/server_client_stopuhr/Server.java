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
    
    private ServerSocket serverSocket;
    private final List<ConnectionHandler> handlers = new ArrayList<>();
    private long timeOffset;
    private long startMillis;
    
    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        timeOffset = 0;
        startMillis = System.currentTimeMillis();
        while (true) {
            final Socket clientSocket = serverSocket.accept();
            final ConnectionHandler handler = new ConnectionHandler(clientSocket);
            new Thread(handler).start();
            handlers.add(handler);
        }
    }
    
    public boolean isTimerRunning() {
        return true;
    }
    
    public long getTimerMillis (){
        long epochTime = System.currentTimeMillis() - startMillis;
        return epochTime;
    }
    
    public static void main(String[] args) {
        Server server = new Server();
    }
}

class ConnectionHandler implements Runnable {
    
    private Socket socket;
    private boolean master;

    public ConnectionHandler(Socket socket) {
        this.socket = socket;
    }
    
    public boolean isClosed () {
        
        return true;
    }
    
    public boolean isMaster () {
        return true;
    }

    @Override
    public void run() {
        try {
            BufferedReader reader = new BufferedReader (new InputStreamReader(socket.getInputStream()));
            String line;
            line = reader.readLine();
            Gson gson = new Gson();
            gson.toJson(line);
            Request re = gson.fromJson(line, Request.class);
            if (re.isMaster()) {
                for (ConnectionHandler ch : handlers) {
                    this.master = true;
                    if (ch != this && ch.isMaster == true) {
                        this.master = false;
                    }
                }
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }
}