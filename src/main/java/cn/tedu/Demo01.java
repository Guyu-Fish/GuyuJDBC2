package cn.tedu;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;

public class Demo01 {
    public static void main(String[] args) {

        try(Connection conn = DBUtils.getConn();) {
            Statement s =  conn.createStatement();
            String sql = "select ename,job from emp";
            ResultSet rs = s.executeQuery(sql);
            while (rs.next()){
                String name = rs.getString("ename");
                String job = rs.getString("job");
                System.out.println(name+":"+job);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
