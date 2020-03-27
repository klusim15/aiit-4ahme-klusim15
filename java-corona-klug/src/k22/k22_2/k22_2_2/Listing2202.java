package k22.k22_2.k22_2_2;

/**
 *
 * @author Simon Klug
 */
class MyThread2202 extends Thread {
    
    public void run() {
        int i = 0;
        while (true) {
            System.out.println(i++);
        }
    } 
}

public class Listing2202 {
    
    public static void main(String[] args) {
        MyThread2202 t = new MyThread2202();
        t.start();
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            
        }
        t.stop();
    }
}