package sundy.annotation;

import java.lang.annotation.*;

/**
 * @author sundy
 * @date 2021/5/20 19:23
 */
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface ClassAnnotation {
    String value() default "默认值";
}
