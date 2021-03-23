package sundy.string;

import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;

/**
 * @author sundy
 * @date 2021/3/22 16:07
 */
@Slf4j
public class StringDemo {
    public boolean equalsContent(String c1, String c2) {
        return c1.equals(c2);
    }

    public boolean equalsAddr(String c1, String c2) {
        return c1 == c2;
    }

    public static void main(String[] args) {
        String s0 = "ab";
        String s1 = "abc";
        String s2 = new String("abc");
        String s3 = s2.intern();
        String s4 = s0 + "c";
        log.info("s1==s2:{}", s1 == s2);
        log.info("s2==s3:{}", s2 == s3);
        log.info("s1==s3:{}", s1 == s3);
        log.info("s1==s4:{}", s1 == s4);
    }
}
