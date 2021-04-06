package sundy.thread;

import java.util.concurrent.*;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

/**
 * @author sundy
 * @date 2021/4/2 11:51
 */
public class CompletableFutureDemo {
    private final ExecutorService executor = Executors.newFixedThreadPool(5);
    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CompletableFutureDemo demo = new CompletableFutureDemo();
        demo.demo2();
    }

    private void demo2() throws ExecutionException, InterruptedException {
        CompletableFuture<String> completableFuture = CompletableFuture.supplyAsync(new Supplier<String>() {
            @Override
            public String get() {
                System.out.println("=============>异步线程开始...");
                System.out.println("=============>异步线程为：" + Thread.currentThread().getName());
                try {
                    TimeUnit.SECONDS.sleep(5);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("=============>异步线程结束...");
                return "supplierResult";            }
        });
        // 阻塞获取结果
        // System.out.println("异步结果是:" + completableFuture.get());
        // System.out.println("main结束");
        completableFuture.whenComplete(new BiConsumer<String, Throwable>() {
            @Override
            public void accept(String s, Throwable throwable) {
                System.out.println("=============>异步任务结束回调...");
                System.out.println("=============>回调线程为：" + Thread.currentThread().getName());
            }
        });
        System.out.println("main结束");
        TimeUnit.SECONDS.sleep(10);
    }


    public void demo1() throws ExecutionException, InterruptedException {
        Future<String> runnableFuture = executor.submit(new Runnable() {
            @Override
            public void run() {
                try {
                    System.out.println("Runnable异步线程开始...");
                    TimeUnit.SECONDS.sleep(3);
                    System.out.println("Runnable异步线程结束...");
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }, "fakeRunnableResult");
       Future<String> callableFuture = executor.submit(new Callable<String>() {
           @Override
           public String call() throws Exception {
               System.out.println("Callable异步线程开始...");
               TimeUnit.SECONDS.sleep(3);
               System.out.println("Callable异步线程结束...");
               return "callableResult";           }
       });

       boolean runnableDone = false;
       boolean callableDone = false;
       while (true){
           TimeUnit.MILLISECONDS.sleep(500);
           System.out.println("轮询异步结果...");
           if (runnableFuture.isDone()) {
               System.out.println("Runnable执行结果:" + runnableFuture.get());
               runnableDone = true;
           }
           if (callableFuture.isDone()) {
               System.out.println("Callable执行结果:" + callableFuture.get());
               callableDone = true;
           }
           if (runnableDone && callableDone) {
               break;
           }
       }
        System.out.println("任务全部结束");
    }
}
