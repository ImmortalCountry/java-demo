package sundy.annotation.JunitDemo;

/**
 * @author sundy
 * @date 2021/4/7 15:54
 */
public class TestDemo {

    @Before
    public void init(){
        System.out.println("初始化...");
    }

    @After
    public void destroy(){
        System.out.println("销毁...");
    }
    @Test
    public void testSave(){
        System.out.println("save...");
    }
    @Test
    public void testDel(){
        System.out.println("del...");
    }
}
