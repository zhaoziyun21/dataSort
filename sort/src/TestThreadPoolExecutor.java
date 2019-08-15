import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by zhaoziyun on 2018/12/29.
 */
public class TestThreadPoolExecutor {

    public static void main(String[] args)  {
//        CounterI  c = new CounterThreadLocal();
        test1();
    }
    public static  void test1() {
        Runnable myTestRunnable = new Runnable() {
            @Override
            public void run() {
                try {
                    Thread.sleep(2000);
                    System.out.println(Thread.currentThread().getName()+" run");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        };
        ThreadPoolExecutor executor = new ThreadPoolExecutor(3,5,5, TimeUnit.SECONDS,new LinkedBlockingDeque<>(1));
        executor.execute(myTestRunnable);
        executor.execute(myTestRunnable);
        executor.execute(myTestRunnable);
        System.out.println("---先开三个---");
        System.out.println("核心线程数" + executor.getCorePoolSize());
        System.out.println("线程池数" + executor.getPoolSize());
        System.out.println("队列任务数" + executor.getQueue().size());
        executor.execute(myTestRunnable);
        executor.execute(myTestRunnable);
        executor.execute(myTestRunnable);
        System.out.println("---再开三个---");
        System.out.println("核心线程数" + executor.getCorePoolSize());
        System.out.println("线程池数" + executor.getPoolSize());
        System.out.println("队列任务数" + executor.getQueue().size());
        try {
            Thread.sleep(8000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("----8秒之后----");
        System.out.println("核心线程数" + executor.getCorePoolSize());
        System.out.println("线程池数" + executor.getPoolSize());
        System.out.println("队列任务数" + executor.getQueue().size());
    }
    public interface CounterI {
        void addOne();
        int getCount();
    }
    private static   ThreadLocal<Integer> count = new ThreadLocal<Integer>() {
        @Override
        protected Integer initialValue() {
            return 0;
        }
    };

      class CounterThreadLocal implements CounterI{

        public void addOne() {
            count.set(count.get() + 1);
        }

        public int getCount() {
            return count.get();
        }

}

}
