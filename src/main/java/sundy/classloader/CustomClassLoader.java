package sundy.classloader;

import lombok.SneakyThrows;

import java.io.FileInputStream;
import java.io.InputStream;

/**
 * @author sundy
 * @date 2021/4/25 21:28
 */
public class CustomClassLoader extends ClassLoader {
    @SneakyThrows
    @Override
    protected Class<?> findClass(String name) throws ClassNotFoundException {
        InputStream stream = new FileInputStream("Start.class");
        byte[] bytes = new byte[stream.available()];
        stream.read(bytes);
        return defineClass(name, bytes, 0, bytes.length);
    }

    @Override
    public Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException {
        Class<?> clazz = findClass(name);
        if (clazz != null) {
            if (resolve) {
                resolveClass(clazz);
            }
            return clazz;
        }
        throw new ClassNotFoundException(name);
    }
}
