package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Demo05 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入用户名");
        String username = sc.nextLine();
        System.out.println("请输入密码");
        String password = sc.nextLine();

        //获取连接
        try (Connection conn = DBUtils.getConn()){
//            //创建执行SQL语句对象
//            Statement s = conn.createStatement();
//            //准备执行的SQL语句
//            String sql = "select id from user where username='"
//                    +username+"' and password ='"+password+"'";
//            //执行SQL语句
//            ResultSet rs = s.executeQuery(sql);

            //通过PreparedStatment解决注入问题
            String sql = "select id from user where username=? and password=?";
            //创建ps对象时 对SQL语句进行编译 此时锁死SQL语句的业务逻辑 不受用户输入的影响
            PreparedStatement ps =conn.prepareStatement(sql);
            //替换掉SQL语句中的? 第一个参数代表?的位置
            ps.setString(1,username);
            ps.setString(2,password);
            ResultSet rs = ps.executeQuery();

            if(rs.next()){
                System.out.println("登陆成功");
            }else{
                System.out.println("登陆失败");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
