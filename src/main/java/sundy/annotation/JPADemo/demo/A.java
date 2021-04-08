package sundy.annotation.JPADemo.demo;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;

/**
 * @author sundy
 * @date 2021/4/7 16:21
 */
public class A<T> {
    public A() {
        /**
         *  我想在这里获得子类B、C传递的实际类型参数的Class对象
         *  class java.lang.String/class java.lang.Integer
         */
        Class<? extends A> subClass = this.getClass();
        Type genericSuperclass = subClass.getGenericSuperclass();
        // System.out.println(genericSuperclass);
        // System.out.println(genericSuperclass.getClass());
        // System.out.println(genericSuperclass.getTypeName());
        ParameterizedType parameterizedTypeSuperclass = (ParameterizedType) genericSuperclass;
        Type[] actualTypeArguments = parameterizedTypeSuperclass.getActualTypeArguments();
        Class actualTypeArgument = (Class) actualTypeArguments[0];
        System.out.println(actualTypeArgument);
        System.out.println(subClass.getName());

    }

    public static void main(String[] args) {
        new B();
    }
}
