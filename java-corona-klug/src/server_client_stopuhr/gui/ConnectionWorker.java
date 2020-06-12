package server_client_stopuhr.gui;

import com.google.gson.Gson;
import java.io.OutputStreamWriter;
import java.net.Socket;
import java.util.List;
import javax.swing.SwingWorker;

/**
 *
 * @author Simon Klug
 */
public class ConnectionWorker extends SwingWorker<String, Integer> {

    private final Socket socket;

    public ConnectionWorker(int port, String hostname) {
        socket = new Socket();
    }

    @Override
    protected String doInBackground() throws Exception {
        System.out.println("Do in Background" + Thread.currentThread().getId());
        Thread.sleep(1000);
        publish(1);
        Thread.sleep(1000);
        publish(2);

        return "OK";
    }

    @Override
    protected void done() {
    }

    @Override
    protected void process(List<Integer> chunks) {
    }
}
