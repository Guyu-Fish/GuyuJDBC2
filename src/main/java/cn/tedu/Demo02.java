package cn.tedu;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Demo02 {
    public static void main(String[] args) throws Exception {
          //创建属性对象
        Properties p = new Properties();
          //获取文件的输入流 会自动的去工程的resources目录下找文件
        InputStream ips = Demo02.class.getClassLoader()
                .getResourceAsStream("my.properties");
          //让文件和属性对象建立关系 异常抛出
        p.load(ips);
          //读取数据 不管是什么类型的只能获取字符串
        String name = p.getProperty("name");
        String age = p.getProperty("age");
        System.out.println(name+":"+age);
    }
}
