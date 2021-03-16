package cn.tedu;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Demo07 {
    public static void main(String[] args) {
        //通过批量操作往user表中插入进去100条数据
        try(Connection conn = DBUtils.getConn()) {
            String sql = "insert into user values(null,?,?)";
            PreparedStatement ps = conn.prepareStatement(sql);
            for(int i =1;i<=100;i++){
                ps.setString(1,"名字"+i);
                ps.setString(2,"密码"+i);
                ps.addBatch();//添加到批量操作
                //避免内存溢出 每隔20次 执行一次
                if(i%20==0){
                    ps.executeBatch();//执行批量操作
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
