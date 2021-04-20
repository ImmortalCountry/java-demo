package sundy.demoProject.tomcat;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

/**
 * @author sundy
 * @date 2021/4/9 19:25
 */
public class AServlet implements Servlet {
    @Override
    public void init() {
        System.out.println("aaServlet...init");
    }

    @Override
    public void service(InputStream is, OutputStream os) throws IOException {
        System.out.println("aServlet...service");
        os.write("I am from AServlet".getBytes());
        os.flush();
    }

    @Override
    public void destroy() {

    }
}
