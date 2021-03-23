package sundy.codeblock;

import lombok.extern.slf4j.Slf4j;

/**
 * @author sundy
 * @date 2021/3/22 19:51
 */
@Slf4j
public class Father {
    private String name;

    static {
        System.out.println("Father class static is called 1");
    }

    {
        System.out.println("Father class is called 1");
    }

    static {
        System.out.println("Father class static is called 2");
    }

    {
        System.out.println("Father class is called 2");
    }


    public Father(String name) {
        this.name = name;
    }
    public void fatherPrint(){
        System.out.println("Father");
    }
}
