package sundy.thread;

import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * @author sundy
 * @date 2021/4/1 16:29
 */
public class AsyncAndWaitDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        System.out.println(Thread.currentThread().getName() + "=======>正在执行");
        Thread thread = new Thread() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "=======>正在执行");
            }
        };
        thread.start();
        new Thread(() -> System.out.println(Thread.currentThread().getName() + "=======>正在执行")).start();
        ExecutorService executorService = Executors.newSingleThreadExecutor();
        Future<String> submit = executorService.submit(() -> {
            System.out.println(Thread.currentThread().getName() + "=======>正在执行");
            Thread.sleep(3 * 1000L);
            return "success";
        });
        String result = submit.get();
        System.out.println("result ======>" + result);
        executorService.shutdown();
    }
}
