package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class Demo08 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("请输入查询的页数");
        int page = sc.nextInt();
        System.out.println("请输入查询的条数");
        int count = sc.nextInt();

        try(Connection conn = DBUtils.getConn()) {
            String sql = "select *from user  limit ?,?";
            PreparedStatement ps = conn.prepareStatement(sql);
            ps.setInt(1,page-1*count);
            ps.setInt(2,count);
            ResultSet rs = ps.executeQuery();
            ps.executeUpdate();
            while(rs.next()){
               int id = rs.getInt("id");
               String username = rs.getString("username");
               String password = rs.getString("password");
                System.out.println(id+":"+username+":"+password);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
