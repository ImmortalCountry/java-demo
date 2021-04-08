package sundy.generic;

import com.google.common.collect.Lists;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author sundy
 * @date 2021/4/8 14:23
 */
public class GenericClassDemo {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        List<String> list = Lists.newArrayList();
        list.add("aaa");
        list.add("bbb");
        Method method = list.getClass().getDeclaredMethod("add", Object.class);
        method.invoke(list, 333);
        for (Object obj : list) {
            System.out.println(obj);
        }
    }
}
