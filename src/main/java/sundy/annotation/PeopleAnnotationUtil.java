package sundy.annotation;

import java.lang.reflect.Field;

/**
 * @author sundy
 * @date 2021/3/23 17:04
 */
public class PeopleAnnotationUtil {
    private static StringBuilder sb = new StringBuilder("名字：");

    public static String getFruitInfo(Class<?> clazz) {
        Field[] fields = clazz.getDeclaredFields();
        for (Field field : fields) {
            if (field.isAnnotationPresent(PeopleAnnotation.class)) {
                PeopleAnnotation annotation = field.getAnnotation(PeopleAnnotation.class);
                sb.append(annotation.value());
            }
        }
        return sb.toString();
    }
}
