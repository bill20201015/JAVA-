import java.sql.*;

/**
 * @author sk
 * @version 1.0
 */
public class test3 {

    String name = "java_connect"; //这里输入你要连接的数据库名字
    //补充一下test3中的几个操作方法，到时候调用test3类就可以实现对表的处理
    //连接初试化操作在静态代码块中完成
    {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");//注册驱动
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }

        //获取连接
        String url = "jdbc:mysql://127.0.0.1:3306/" + name +"?serverTimezone=UTC";
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
