package server_client_stopuhr.gui;

import com.google.gson.Gson;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.Socket;
import javax.swing.SwingWorker;
import server_client_stopuhr.Request;
import server_client_stopuhr.Response;

/**
 *
 * @author Simon Klug
 */
public class ConnectionWorker extends SwingWorker<Object, Response> {

    private boolean tryToStart;
    private boolean tryToStop;
    private boolean tryToClear;
    private boolean tryToEnd;
    private boolean cancel;
    private int sliderValue = 0;
    private Socket socket;

    public ConnectionWorker(String host, int port) throws IOException {
        socket = new Socket(host, port);
    }

    public void setSliderValue(boolean sliderValue) {
        this.sliderValue = this.sliderValue;
    }

    public void setTryToStart(boolean tryToStart) {
        this.tryToStart = tryToStart;
    }

    public void setTryToStop(boolean tryToStop) {
        this.tryToStop = tryToStop;
    }

    public void setTryToClear(boolean tryToClear) {
        this.tryToClear = tryToClear;
    }

    public void setTryToEnd(boolean tryToEnd) {
        this.tryToEnd = tryToEnd;
    }

    public void setCancel(boolean cancel) {
        this.cancel = cancel;
    }

    public ConnectionWorker(int port, String host) throws IOException {
        socket = new Socket(host, port);
    }

    @Override
    protected Object doInBackground() throws Exception {
        final Gson g = new Gson();
        final BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
        final OutputStreamWriter writer = new OutputStreamWriter(socket.getOutputStream());
        while (true) {
            try {
                final Request req = new Request();
                final String reqString = g.toJson(req);
                writer.write(reqString + "\n");
                writer.flush();

                tryToStart = false;
                tryToStop = false;
                tryToClear = false;
                tryToEnd = false;

                final String respString = reader.readLine();
                final Response resp = g.fromJson(respString, Response.class);
                publish(resp);
            } catch (Exception ex) {
                ex.printStackTrace();
            }
        }
    }
}
