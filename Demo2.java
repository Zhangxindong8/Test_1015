import java.sql.*;


public class Demo2 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException, SQLException {
        //注册数据库驱动
        Class.forName("com.mysql.jdbc.Driver");
        //获取数据库连接
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/student", "root", "123456");
        //获取sql的Statement对象
    //    PrepareStatement preStmt = conn.prepareStatement(sql);
        //执行sql语句
        String sql = "insert into users(name,password,email,birthday)values(?,?,?,?)";
        PreparedStatement preStmt = conn.prepareStatement(sql);
        preStmt.setString(1,"z1");
        preStmt.setString(2,"123456");
        preStmt.setString(3,"z1@sina.com");
        preStmt.setString(4,"1789-12-23");
        preStmt.executeUpdate();
        System.out.println();
        preStmt.close();
        conn.close();
    }

}
