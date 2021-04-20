package sundy;

import com.google.common.base.Strings;
import com.google.common.collect.Maps;
import org.apache.commons.lang3.StringUtils;
import sundy.Utils.Bean;
import sundy.Utils.BeanUtils;
import sundy.Utils.enums.CodeStyleEnum;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Properties;

/**
 * @author sundy
 * @date 2021/3/22 16:03
 */
public class Start {
    public static void main(String[] args) throws InstantiationException, IllegalAccessException, InvocationTargetException {
        Properties properties = System.getProperties();
        for (Object obj : properties.keySet()) {
            System.out.println("key:" + obj + "-->" + properties.get(obj));
        }
    }
}
