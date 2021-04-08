package sundy.annotation.JPADemo;

/**
 * @author sundy
 * @date 2021/4/7 18:25
 */
public class UserDaoTest {
    public static void main(String[] args) {
        UserDao userDao = new UserDao();
        User user = new User("小明", 20);
        userDao.add(user);
    }
}
