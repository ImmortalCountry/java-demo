package sundy.annotation.JPADemo;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author sundy
 * @date 2021/4/7 17:58
 */
@Data
@AllArgsConstructor
@Table("t_user")
public class User {
    private String name;
    private Integer age;
}
