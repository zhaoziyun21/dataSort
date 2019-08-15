import java.io.IOException;
import java.io.InputStream;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by zhaoziyun on 2019/5/20.
 */
class Task implements  Runnable{

    @Override
    public void run() {
        synchronized (this){
            try {
                wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
public class JstackTest {
    public static void main(String[] args) {
        InputStream is = System.in;
        try {
            int i =  is.read();
            System.out.println("exit...............");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
