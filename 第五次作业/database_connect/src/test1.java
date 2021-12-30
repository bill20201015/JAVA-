/**
 * @author sk
 * @version 1.0
 */

import java.sql.*;

/**
   直接数据库操作，数据库连接、SQL语句等。（自己包包子）
 */
public class test1 {
    public static void main(String[] args) {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//注册驱动
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/java_connect?serverTimezone=UTC";
        String root = "root";
        String password = "123456";

        Connection conn = null;

        try {
            conn = DriverManager.getConnection(url, root, password);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
        }

        Statement statement = null;
        String sql = "select * from test";
        ResultSet rs = null;

        try {
            statement = conn.createStatement();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        try {

            rs = statement.executeQuery(sql);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        try {
            while(rs.next()){
                System.out.println(rs.getString("name"));
                System.out.println(rs.getString("age"));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        //关闭连接
        if(rs != null){
            try {
                rs.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }
        if(statement != null){
            try {
                statement.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

        if(conn != null){
            try {
                conn.close();
            } catch (SQLException throwables) {
                throwables.printStackTrace();
            }
        }

    }
}
