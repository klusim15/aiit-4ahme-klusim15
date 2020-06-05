package server_client_stopuhr;

import com.google.gson.Gson;
import java.io.OutputStreamWriter;
import java.net.Socket;
import javax.swing.SwingWorker;

/**
 *
 * @author Simon Klug
 */
public class ConnectionWorker extends SwingWorker<Object, Object> {
    
    private final Socket socket;

    public ConnectionWorker(Socket socket) {
        this.socket = socket;
    }

    @Override
    protected Object doInBackground() throws Exception {
        try {
            final OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
            final Gson gson = new Gson();
        } catch (Exception ex) {
            
        }
        return 0;
    }

    @Override
    protected void done() {
        super.done(); //To change body of generated methods, choose Tools | Templates.
    }
}