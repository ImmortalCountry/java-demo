package sundy.thread.threadlocal;

/**
 * @author sundy
 * @date 2021/4/1 11:17
 */
public class ThreadLocalDemo {
    public static void main(String[] args) {
        ThreadLocal threadLocal = new ThreadLocal();
        threadLocal.set("a");
    }
}
