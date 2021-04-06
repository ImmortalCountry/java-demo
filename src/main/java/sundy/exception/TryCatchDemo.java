package sundy.exception;

/**
 * @author sundy
 * @date 2021/3/23 17:39
 */
public class TryCatchDemo {
    public int returnValue() {
        try {
            System.out.println("try 语句块");
            int a = 1/0;
            return 1;
        } catch (Exception e) {
            System.out.println("catch 语句块");
            return 2;
        } finally {
            System.out.println("finally 语句块");
        }
    }

    public void returnNull() {

    }

    public static void main(String[] args) {
        TryCatchDemo tryCatchDemo = new TryCatchDemo();
        System.out.println(tryCatchDemo.returnValue());
    }
}
