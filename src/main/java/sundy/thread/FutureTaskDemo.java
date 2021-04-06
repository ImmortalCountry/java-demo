package sundy.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * @author sundy
 * @date 2021/4/1 16:53
 */
public class FutureTaskDemo {
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        FutureTask<String> futureTask = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() {
                System.out.println(Thread.currentThread().getName() + "=======>正在执行");
                try {
                    Thread.sleep(3 * 1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "success";
            }
        });
        System.out.println(Thread.currentThread().getName() + "=======>启动任务");
        new Thread(futureTask).start();
        String result = futureTask.get();
        System.out.println("任务执行结束，result====>" + result);
    }

    public void runAndCall() {
        FutureTask<String> futureTask = new FutureTask<>(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName() + "=======>正在执行");
            }
        }, "success");
        FutureTask<String> futureTask1 = new FutureTask<>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                try {
                    Thread.sleep(3*1000L);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return "success";
            }
        });
    }
}
