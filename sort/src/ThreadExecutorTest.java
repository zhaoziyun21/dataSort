import java.util.*;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by zhaoziyun on 2019/5/4.
 */
public class ThreadExecutorTest {
    ExecutorService executorService = new ThreadPoolExecutor(
            2,2,0, TimeUnit.MILLISECONDS,new LinkedBlockingQueue<>(2));

    public static void main(String[] args) throws Exception {
        futureTest();
    }
    public static  void heartHeat(){
        ScheduledExecutorService executorService = Executors.newScheduledThreadPool(5);
        Runnable task = new Runnable() {
            @Override
            public void run() {
                Date date = new Date();
                System.out.println("HeartBeat  time........................."+date);
            }
        };
        executorService.scheduleAtFixedRate(task,5,3,TimeUnit.SECONDS);
    }
    public static  void threadPoolTest() throws InterruptedException {
        ExecutorService executorService = Executors.newCachedThreadPool();
        for (int i =0;i<10;i++){
            final int name = i;
            TimeUnit.SECONDS.sleep(1);
            Runnable task = new Runnable() {
                @Override
                public void run() {
                    System.out.println("线程名字： " + Thread.currentThread().getName() +  "  任务名为： "+ name);
                }
            };
            executorService.execute(task);
        }
    }
    public static  void CallableAndFutureTest () throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> future = executorService.submit(new Callable<String>() {
            @Override
            public String call() throws Exception {
                TimeUnit.SECONDS.sleep(1);
                return "w c n";
            }
        });
        System.out.println("任务的执行结果："+future.get());
    }

    public static  void futureTest () throws ExecutionException, InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(10);
        CountDownLatch countDownLatch = new CountDownLatch(40);
        BlockingQueue<Future> queue = new LinkedBlockingQueue<>();
        AtomicLong i = new AtomicLong(0);
        while(queue.size()<40){
            Future future = executorService.submit(new Callable() {
                public Object call() throws Exception {
                    Thread.sleep(new Random().nextInt(5000));   //让当前线程随机休眠一段时间
                    Long num = countDownLatch.getCount();
                    countDownLatch.countDown();
                    System.out.println(Thread.currentThread().getName()+"----任务的执行序号:"+num+"***阻塞队列里存有的线程数:"+((ThreadPoolExecutor)executorService).getQueue().size());
                    return num;
                }
            });
            queue.add(future);
            System.out.println(Thread.currentThread().getName()+"------------------------------已放入任务! 阻塞队列里存有的线程数"+((ThreadPoolExecutor)executorService).getQueue().size());
        }
        countDownLatch.await();
        for (Future f: queue ) {

            System.out.println("queue任务的执行结果："+f.get());
        }
    }
}
