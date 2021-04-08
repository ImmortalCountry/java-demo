package sundy.generic;

import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sundy
 * @date 2021/4/8 15:36
 */
public class GenericPrintDemo {
    public static void main(String[] args) {
        List list = new ArrayList();
        list.add(123);
        list.add("aaa");
   }

    private static void extracted3() {
        List<? super Human> humanList = new ArrayList<>();
        humanList.add(new Human("人类"));

        // 只能指human及其父类型的List：灵长类、生物类
        // humanList = new ArrayList<Chinese>(); // error
        humanList = new ArrayList<Primate>();
        humanList = new ArrayList<Creature>();

        // 简单反省和extends都搞不定的存入问题被解决了
        humanList.add(new Human("女性"));
        humanList.add(new Chinese("中国人"));

        // super：也不是啦，我虽然能存东西，但规定只能存Human及其子类型元素
        // humanList.add(new Primate("灵长类动物")); // ERROR
        // humanList.add(new Creature("外星生物")); // ERROR
        // humanList.add("无关类型，比如String"); // ERROR
        Object object = humanList.get(0);
    }

    private static void extracted2() {
        List<Integer> integerList = new ArrayList<>();
        integerList.add(100);
        List<? extends Number> numList = integerList;
        // numList.add(200);
    }


    private static void extracted() {
        ArrayList<Chinese> chineseArrayList = new ArrayList<>();
        chineseArrayList.add(new Chinese("李健"));
        chineseArrayList.add(new Chinese("周深"));

        ArrayList<Japanese> japaneseArrayList = new ArrayList<>();
        japaneseArrayList.add(new Japanese("三浦春马"));
        japaneseArrayList.add(new Japanese("瑛太"));

        /**
         * 与编译器约定，左右两边类型不一致也能赋值，但是有条件：
         * 右边List的参数类型必须是Human的子类
         */

        List<? extends Human> humanList = chineseArrayList;
        Human lee = humanList.get(0);
        Human zhou = humanList.get(0);
        System.out.println(lee + "&" + zhou);

        humanList = japaneseArrayList;
        Human haRuMa = humanList.get(0);
        Human eiTa = humanList.get(1);
        System.out.println(haRuMa + "&" + eiTa);
    }

    private static void print(List<? extends Number> integerList) {
        // 打印
    }

    @Data
    static class Creature {
        public Creature(String name) {
            this.name = name;
        }

        private String name;
    }

    static class Primate extends Creature {
        public Primate(String name) {
            super(name);
        }
    }

    static class Human extends Primate {
        public Human(String name) {
            super(name);
        }
    }

    static class Chinese extends Human {
        public Chinese(String name) {
            super(name);
        }
    }

    static class Japanese extends Human {
        public Japanese(String name) {
            super(name);
        }
    }
}
