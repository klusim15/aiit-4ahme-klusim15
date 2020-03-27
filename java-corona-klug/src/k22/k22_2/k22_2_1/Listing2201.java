
package k22.k22_2.k22_2_1;

/**
 *
 * @author Simon Klug
 */
class MyThread2201 extends Thread {

    public void run() {
        int i = 0;
        while (true) {
            System.out.println(i++);
        }
    } 
}

public class Listing2201 {
    
    public static void main(String[] args) {
        MyThread2201 t = new MyThread2201();
        t.start();
    }
}