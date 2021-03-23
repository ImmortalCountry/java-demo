package sundy.demo.enums;

/**
 * @author sundy
 * @date 2021/3/23 16:07
 */

public enum Color {
    /**
     * 红、蓝、绿、黄
     */
    RED("红"), BLUE("蓝"), GREEN("绿"), YELLOW("黄");
    String name;
    Color(String name) {
        this.name = name;
    }
    public String getName(){
        return name;
    }

    public static void main(String[] args) {
        // RED
        System.out.println(Color.RED);
        // 红色
        System.out.println(Color.RED.getName());
    }
}
