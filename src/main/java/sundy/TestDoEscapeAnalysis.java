package sundy;

import org.apache.commons.lang3.StringUtils;
import sundy.classloader.CustomClassLoader;

import java.util.Objects;

/**
 * @author sundy
 * @date 2021/4/25 21:53
 */
public class TestDoEscapeAnalysis {
    /**
     * -Xmx4G -Xms4G -XX:-DoEscapeAnalysis -XX:+PrintGCDetails -XX:+HeapDumpOnOutOfMemoryError
     * 查看Student 50万个
     * <p>
     * c
     * 查看Student 不足50万个
     * <p>
     * jmap -histo PID
     *
     * @param args
     */
    public static void main(String[] args) throws InterruptedException {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 500000; i++) {
            alloc();
        }
        long end = System.currentTimeMillis();
        System.out.println("cost time:" + (end - start));
        Thread.sleep(10000000);
    }


    public static Student alloc() {
        Student student = new Student();
        return student;
    }


    static class Student {
        private int id;
        private int age;
    }

}
