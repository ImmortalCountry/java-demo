package sundy;

import com.google.common.collect.Lists;
import org.reflections.Reflections;
import sundy.annotation.ClassAnnotation;
import sundy.annotation.People;

import java.util.List;
import java.util.Objects;
import java.util.Set;

/**
 * @author sundy
 * @date 2021/5/6 11:28
 */
public class Test {
    static Integer i = null;
    public static void main(String[] args) throws IllegalAccessException, InstantiationException {
        //设置扫描哪个我的annotation包下的类，可以扫描全部项目包，包括引用的jar
        Reflections reflections = new Reflections("sundy.annotation");
        //获取带DataClass注解的类
        Set<Class<?>> typesAnnotatedWith = reflections.getTypesAnnotatedWith(ClassAnnotation.class);
        for (Class c:typesAnnotatedWith){
            //通过循环打印出权限定类名
            System.out.println(c.getName());
            People o = (People)c.newInstance();
            o.print();
        }

    }
}
