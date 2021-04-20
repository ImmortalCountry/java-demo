package sundy.Utils;

import com.google.common.base.CaseFormat;
import com.google.common.base.Converter;
import sundy.Utils.enums.CodeStyleEnum;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.util.Map;

/**
 * @author sundy
 * @date 2021/4/15 18:14
 */
public class BeanUtils {
    private static Converter<String, String> converter = CaseFormat.LOWER_CAMEL.converterTo(CaseFormat.LOWER_UNDERSCORE);

    public static <T> T map2Bean(Map<String, ?> map, CodeStyleEnum mapStyle, Class<T> clazz) throws IllegalAccessException, InstantiationException, InvocationTargetException {
        T obj = clazz.newInstance();
        Field[] fields = obj.getClass().getDeclaredFields();
        for (Field field : fields) {
            field.setAccessible(true);
            Object value = map.get(field.getName());
            field.set(obj, value);
        }
        org.apache.commons.beanutils.BeanUtils.populate(obj, map);
        return obj;
    }
}
