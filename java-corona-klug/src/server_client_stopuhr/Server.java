package server_client_stopuhr;

import java.io.IOException;
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
    private final List<ConnectionHandler> handler = new ArrayList<>();
    private long timeOffset;
    private long startMillis;
    
    public void start(int port) throws IOException {
        serverSocket = new ServerSocket(port);
        while (true) {
            final Socket clientSocket = serverSocket.accept();
            ConnectionHandler handler = new ConnectionHandler(clientSocket);
            Thread thread = new Thread(handler);
            thread.start();
        }
    }
    
    public boolean isTimerRunning() {
        
    }
    
    public long getTimerMillis (){
        long epochTime = System.currentTimeMillis();
        System.out.println(epochTime);
        return startMillis = 0;
    }
    
    public static void main(String[] args) {
        new Server();
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
        
    }

    @Override
    public void run() {
        int i = 0;
        while (true) {
          if (Thread.interrupted()) {
             break;
          }
          System.out.println(i++);
       }
    }
}