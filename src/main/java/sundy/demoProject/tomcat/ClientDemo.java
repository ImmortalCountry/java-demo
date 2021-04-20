package sundy.demoProject.tomcat;

import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;

/**
 * @author sundy
 * @date 2021/4/9 11:09
 */
public class ClientDemo {
    public static void main(String[] args) {

        try (Socket client = new Socket("www.itcast.cn", 80);
             InputStream is = client.getInputStream();
             OutputStream os = client.getOutputStream();) {
            os.write("GET /subject/about/index.html HTTP/1.1\n".getBytes());
            os.write("HOST:www.itcast.cn\n".getBytes());
            os.write("\n".getBytes());
            int i;
            while ((i = is.read()) != -1){
                System.out.print((char)i);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 建立一个Socket，连接端口
        // 获取到输出流
        // 获取到输入流
        // 将HTTP协议请求部分发送到服务端
        // 读取来自服务端的数据打印到控制台
        // 释放资源


    }

}
