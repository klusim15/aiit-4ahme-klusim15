package k22.k22_4.k22_4_2;

/**
 *
 * @author Simon Klug
 */
class Counter2212 {
    int cnt;
 
    public Counter2212(int cnt) {
        this.cnt = cnt;
    }
 
    public synchronized int nextNumber(){
        int ret = cnt;
        double x = 1.0, y, z;
        for (int i= 0; i < 1000; ++i) {
            x = Math.sin((x*i%35)*1.13);
            y = Math.log(x+10.0);
            z = Math.sqrt(x+y);
        }
        cnt++;
        return ret;
    }
}
 
public class Listing2212 extends Thread
{
    private String name;
    private Counter2212 counter;
  
    public Listing2212(String name, Counter2212 counter) {
        this.name = name;
        this.counter = counter;
    }
  
    public static void main(String[] args)
    {
        Thread[] t = new Thread[5];
        Counter2212 cnt = new Counter2212(10);
        for (int i = 0; i < 5; ++i) {
            t[i] = new Listing2212("Thread-"+i,cnt);
            t[i].start();
        }
    }
 
    public void run() {
        while (true) {
            System.out.println(counter.nextNumber()+" for "+name);
        }
    }
}