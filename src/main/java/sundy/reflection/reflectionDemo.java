package sundy.reflection;

import com.google.common.collect.Lists;

import java.lang.reflect.Array;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.List;

/**
 * @author sundy
 * @date 2021/4/12 19:34
 */
public class reflectionDemo {
    public void print() {
        System.out.println("print method : reflection");
    }

    public static void main(String[] args) throws Exception {
        Class<?> clazz = Class.forName("sundy.reflection.reflectionDemo");
        Method print = clazz.getMethod("print");
        print.invoke(clazz.newInstance());
    }
}
