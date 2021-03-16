package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Scanner;

public class Demo10 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入球队名");
        String teamName = sc.nextLine();
        System.out.println("请输入球员名");
        String playerName = sc.nextLine();

        //获取连接
        try(Connection conn = DBUtils.getConn()) {
            //1. 把球队名添加到team表中
            //2. 获取球队自增的id 值
            //3. 把球员名添加到player表中 用到上面得到的球队id

            String sql ="insert into from user values(null,?,?)";
            //sql后面添加参数 用于获取自增主键值
            PreparedStatement ps = conn.prepareStatement(sql
                    , Statement.RETURN_GENERATED_KEYS);
            ps.setString(1,teamName);
            ps.setString(2,playerName);
            ps.executeUpdate();
            //获取装着自增主键值的结果集对象
            ResultSet rs = ps.getGeneratedKeys();
            rs.next();//让游标下移
            int id = rs.getInt(1);//取出结果集中装的自增主键值
            System.out.println("用户id"+id);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
