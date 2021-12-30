/**
 * @author sk
 * @version 1.0
 */

import java.sql.*;

/**
 * 对应数据库中的表建一个类，以类的方式隔离数据库操作
 */
public class test2 {
    //连接初试化操作在静态代码块中完成
    {
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
    }

    ResultSet getResultSet(Statement statement, String sql) throws SQLException {
        ResultSet resultSet = statement.getResultSet();
        return resultSet;
    }

    void printfMessage(ResultSet rs) throws SQLException {
        while(rs.next()){
            System.out.println(rs.getString("name"));
            System.out.println(rs.getString("age"));
        }
    }
}
