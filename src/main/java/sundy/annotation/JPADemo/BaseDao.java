package sundy.annotation.JPADemo;

import com.google.common.collect.Lists;
import org.apache.commons.dbcp.BasicDataSource;
import org.springframework.jdbc.core.JdbcTemplate;

import java.lang.reflect.Field;
import java.lang.reflect.ParameterizedType;
import java.util.List;

/**
 * @author sundy
 * @date 2021/4/7 17:59
 */
public class BaseDao<T> {
    private static BasicDataSource datasource;

    static {
        datasource = new BasicDataSource();
        datasource.setDriverClassName("com.mysql.jdbc.Driver");
        datasource.setUrl("jdbc:mysql://39.105.129.105:3306/test");
        datasource.setUsername("root");
        datasource.setPassword("Sdy1997218*");
    }

    private JdbcTemplate jdbcTemplate = new JdbcTemplate(datasource);
    /**
     * DAO 操作的对象
     */
    private Class<T> beanClass;

    /**
     * 构造器
     * 初始化完成对实际类型参数的获取
     * 比如BaseDao<User>插入User，那么beanClass就是user.class
     */
    public BaseDao() {
        beanClass = (Class<T>) ((ParameterizedType) this.getClass()
                .getGenericSuperclass())
                .getActualTypeArguments()[0];
    }

    public void add(T bean) {
        // 得到User对象的所有字段
        Field[] declaredFields = beanClass.getDeclaredFields();
        // 拼接sql语句，表名直接用POJO的类名，所以创建表的时候，请注意写成User，而不是t_User
        StringBuilder sql = new StringBuilder()
                .append("insert into ")
                .append(beanClass.getAnnotation(Table.class).value())
                .append(" values(");
        for (int i = 0; i < declaredFields.length; i++) {
            sql.append("?");
            if (i < declaredFields.length - 1) {
                sql.append(",");
            }
        }
        sql.append(")");
        System.out.println("sql：" + sql.toString());
        // 获取bean字段的值
        List<Object> paramList = Lists.newArrayList();
        try {
            for (Field field : declaredFields) {
                field.setAccessible(true);
                Object o = field.get(bean);
                paramList.add(o);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

        int size = paramList.size();
        Object[] params = paramList.toArray(new Object[size]);
        // 传入sql语句模板和模板所需要的参数，擦汗如User
        int num = jdbcTemplate.update(sql.toString(), params);
        System.out.println(num);
    }

}
