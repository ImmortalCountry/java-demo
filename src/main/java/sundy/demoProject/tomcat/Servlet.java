package sundy.demoProject.tomcat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author sundy
 * @date 2021/4/9 19:25
 */
public interface Servlet {
    void init();
    void service(InputStream is, OutputStream os) throws IOException;
    void destroy();
}
