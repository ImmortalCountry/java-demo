package sundy.codeblock;

/**
 * @author sundy
 * @date 2021/3/22 19:51
 */
public class CodeBlock extends Father{

    static {
        System.out.println("CodeBlock class static is called 1");
    }

    {
        System.out.println("CodeBlock class is called 1");
    }

    static {
        System.out.println("CodeBlock class static is called 2");
    }

    {
        System.out.println("CodeBlock class is called 2");
    }

    public CodeBlock(String name) {
        super(name);
        super.fatherPrint();
        this.print();
    }

    public static void main(String[] args) {
        CodeBlock test = new CodeBlock("test");
        System.out.println("___________");
        CodeBlock test1 = new CodeBlock("test");
        System.out.println("___________");
        Father aa = new Father("aa");
    }
    public void print(){
        System.out.println("CodeBlock");
    }
}
