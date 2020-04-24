package server_client_stopuhr;

/**
 *
 * @author Simon Klug
 */
public class Response {
    private boolean master;
    private long count;
    private boolean running;
    private long time;

    public Response(boolean master, long count, boolean running, long time) {
        this.master = master;
        this.count = count;
        this.running = running;
        this.time = time;
    }

    public boolean isMaster() {
        return master;
    }

    public void setMaster(boolean master) {
        this.master = master;
    }

    public long getCount() {
        return count;
    }

    public void setCount(long count) {
        this.count = count;
    }

    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }
}