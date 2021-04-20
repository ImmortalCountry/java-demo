package sundy.demoProject.tomcat;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;
import java.util.Set;

/**
 * @author sundy
 * @date 2021/4/9 18:37
 */
public class ServerTest {
    public static String WEB_ROOT = System.getProperty("user.dir") + "\\" + "src/WebContent";
    private static String url = "";
    private static final Map<String, String> map = new HashMap<>();

    static {
        Properties prop = new Properties();
        try {
            prop.load(new FileInputStream(WEB_ROOT + "\\conf.properties"));
            Set<Object> keySet = prop.keySet();
            for (Object key : keySet) {
                String k = (String) key;
                String v = prop.getProperty(k);
                map.put(k, v);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public static void main(String[] args) {
        System.out.println(WEB_ROOT);
        try (ServerSocket server = new ServerSocket(8080);) {
            while (true) {
                Socket socket = server.accept();
                InputStream is = socket.getInputStream();
                OutputStream os = socket.getOutputStream();
                parse(is);
                if (url != null) {
                    if (url.indexOf(".") != -1) {
                        sendStaticResource(os);
                    } else {
                        sendDynamicResource(is, os);
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private static void sendDynamicResource(InputStream is, OutputStream os) throws Exception {
        //6.2.1将HTTP协议的响应行和响应头发送到客户端
        os.write("HTTP/1.1 200 OK\n".getBytes());
        os.write("Server:apache\n".getBytes());
        os.write("Content-Type:text/html;charset=utf-8\n".getBytes());
        os.write("\n".getBytes());
        //6.2.2判断map中是否存在一个key，这个key是否和本次待请求的资源路径一致
        if (map.containsKey(url)) {
            //6.2.3如果包含指定的key，获取到map中的key对应的value部分
            String value = map.get(url);
            //6.2.4通过反射将对应的JAVA程序加载到内存
            Class clazz = Class.forName(value);
            Servlet servlet = (Servlet) clazz.newInstance();
            //6.2.5执行init方法
            servlet.init();
            //6.2.6执行service方法
            servlet.service(is, os);
        }
    }

    private static void sendStaticResource(OutputStream os) throws IOException {
        byte[] buffer = new byte[2048];
        FileInputStream fis = null;
        try {
            File file = new File(WEB_ROOT, url);
            if (file.exists()) {
                os.write("HTTP/1.1 200 OK\n".getBytes());
                os.write("Server:apache-Coyote/1.1\n".getBytes());
                os.write("Content-Type:text/html;charset=utf-8\n".getBytes());
                os.write("\n".getBytes());
                fis = new FileInputStream(file);
                int ch = -1;
                while ((ch = fis.read(buffer)) != -1) {
                    os.write(buffer, 0, ch);
                }
            } else {
                os.write("HTTP/1.1 404 not found\n".getBytes());
                os.write("Server:apache-Coyote/1.1\n".getBytes());
                os.write("Content-Type:text/html;charset=utf-8\n".getBytes());
                os.write("\n".getBytes());
                String errorMessage = "file not found";
                os.write(errorMessage.getBytes());
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            if (fis != null) {
                fis.close();
                fis = null;
            }
        }
    }

    private static void parse(InputStream is) {
        StringBuffer content = new StringBuffer(2048);
        byte[] buffer = new byte[2048];
        int i = -1;
        try {
            i = is.read(buffer);
        } catch (Exception e) {
            e.printStackTrace();
        }
        for (int j = 0; j < i; j++) {
            content.append((char) buffer[j]);
        }
        System.out.println(content);
        parseUrl(content.toString());
    }

    private static void parseUrl(String content) {
        int index1, index2;
        index1 = content.indexOf(" ");
        if (index1 != -1) {
            index2 = content.indexOf(" ", index1 + 1);
            if (index2 > index1) {
                url = content.substring(index1 + 2, index2);
            }
        }
        System.out.println(url);
    }

}
