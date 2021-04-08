package sundy.annotation.JunitDemo;

import com.google.common.collect.Lists;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.List;

/**
 * @author sundy
 * @date 2021/4/7 15:56
 */
public class JunitUtil {
    public static void main(String[] args) throws Exception {
        // 1. 先找到测试类的字节码：TestDemo
        Class clazz = TestDemo.class;
        Object obj = clazz.newInstance();

        // 2. 获取Test D二，o类中所有的公共方法
        Method[] methods = clazz.getMethods();

        // 3. 迭代出每一个Method，判断哪些方法使用了注解
        List<Method> beforeList = Lists.newArrayList();
        List<Method> afterList = Lists.newArrayList();
        List<Method> testList = Lists.newArrayList();
        for (Method method : methods) {
            if (method.isAnnotationPresent(Before.class)){
                beforeList.add(method);
            }else if (method.isAnnotationPresent(Test.class)){
                testList.add(method);
            }else if (method.isAnnotationPresent(After.class)){
                afterList.add(method);
            }
        }
        // 执行方法

        for (Method test : testList) {
            // 先执行before
            for (Method before : beforeList) {
                before.invoke(obj);
            }
            test.invoke(obj);
            for (Method after : afterList) {
                after.invoke(obj);
            }
        }
    }
}
