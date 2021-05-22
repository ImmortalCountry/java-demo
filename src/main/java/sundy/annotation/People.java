package sundy.annotation;

import lombok.Data;

/**
 * @author sundy
 * @date 2021/3/23 17:03
 */
@Data
@ClassAnnotation
public class People {
    @PeopleAnnotation("注解赋值名字")
    private String name;

    public static void main(String[] args) {
        System.out.println(PeopleAnnotationUtil.getFruitInfo(People.class));
    }
    public void print(){
        System.out.println("hello");
    }
}
