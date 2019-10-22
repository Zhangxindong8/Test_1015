import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

/*
jdbc 快速入门
 */
public class Demo1 {
    public static void main(String[] args) throws ClassNotFoundException, SQLException {
        //1.导入驱动jar包
        //2.注册驱动
        Class.forName("com.mysql.jdbc.Driver");
        //3.获取数据库连接对象
        //   Connection conn =DriverManager.getConnection("jdbc:mysql://localhost:3306/db3","root","990305");
        Connection conn =DriverManager.getConnection("jdbc:mysql:///test","root","123456");
        //4.定义sql语句
        String sql = "insert into student values ('1111','ZhangSan',122)";
        //5.获取执行sql的对象Statement
        Statement stmt = conn.createStatement();
        //6.执行sql
        int count = stmt.executeUpdate(sql);
        //7.执行结果
        System.out.println(count);
        //8.释放资源
        stmt.close();
        conn.close();
    }
}




