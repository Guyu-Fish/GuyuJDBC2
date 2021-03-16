package cn.tedu;

import java.sql.Connection;
import java.sql.Statement;

public class Demo06 {
    public static void main(String[] args) {
        //获取连接
        try(Connection conn = DBUtils.getConn()) {
            String sql1 = "insert into user values(null,'111','aaa')";
            String sql2 = "insert into user values(null,'222','bbb')";
            String sql3 = "insert into user values(null,'333','ccc')";
            Statement s = conn.createStatement();
            s.addBatch(sql1);
            s.addBatch(sql2);
            s.addBatch(sql3);
            //执行批量操作
            s.executeBatch();
            System.out.println(" 执行完成 ");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
