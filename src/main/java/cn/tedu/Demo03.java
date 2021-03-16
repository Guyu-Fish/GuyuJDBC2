package cn.tedu;

import com.alibaba.druid.pool.DruidDataSource;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class Demo03 {
    public static void main(String[] args){
        try(Connection conn = DBUtils.getConn();) {
            Statement s = conn.createStatement();
            String sql = "select ename from emp";
            ResultSet rs = s.executeQuery(sql);
            while(rs.next()){
                String name = rs.getString("ename");
                System.out.println(name);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
