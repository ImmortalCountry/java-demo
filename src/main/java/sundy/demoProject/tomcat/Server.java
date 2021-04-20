package sundy.demoProject.tomcat;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author sundy
 * @date 2021/4/9 17:36
 */
public class Server {
    public static void main(String[] args) {
        /**
         * 1. 创建ServerSocket对象，监听本机8080
         * 2. 等待来自客户端的请求获取和客户端对应的Socket对象
         * 3. 通过获取到的Socket对象获取到输出流对象
         * 4. 通过获取到的输出流对象将HTTP协议的显影部分发送到客户端
         */
        try (ServerSocket server = new ServerSocket(8080);) {
            while(true){
                Socket socket = server.accept();
                InputStream is = socket.getInputStream();
                OutputStream os = socket.getOutputStream();
                os.write("HTTP/1.1 200 OK\n".getBytes());
                os.write("Content-Type:text/html;charset=utf-8\n".getBytes());
                os.write("\n\n".getBytes());
                String sb = "<html>" +
                        "<head><title>我是标题</title></head>" +
                        "<body>" +
                        "<h1> I am header 1</h1>" +
                        "<a href='http://www.baidu.com'>百度</a>" +
                        "</body>" +
                        "</html>";
                os.write(sb.getBytes());
                os.flush();
            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}
