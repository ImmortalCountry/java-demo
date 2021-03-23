package sundy.annotation;

import java.lang.annotation.*;

/**
 * @author sundy
 * @date 2021/3/23 17:01
 */
@Target(ElementType.FIELD)
@Retention(RetentionPolicy.RUNTIME)
@Documented
public @interface PeopleAnnotation {
    String value() default "默认值";
}
