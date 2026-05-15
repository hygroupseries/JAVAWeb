import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class TestDBConnection {
    public static void main(String[] args) {
        String[] configs = {
            "jdbc:mysql://localhost:3306/sxdxjavaweb?useSSL=false&serverTimezone=UTC&characterEncoding=utf8",
            "jdbc:mysql://127.0.0.1:3306/sxdxjavaweb?useSSL=false&serverTimezone=UTC&characterEncoding=utf8"
        };
        
        String[][] users = {
            {"javaweb", "123456"},
            {"root", "root"},
            {"root", "123456"},
            {"root", "qhy"},
            {"root", ""}
        };
        
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("MySQL 驱动加载失败：" + e.getMessage());
            return;
        }
        
        for (String url : configs) {
            System.out.println("\n尝试连接：" + url);
            for (String[] user : users) {
                try {
                    Connection conn = DriverManager.getConnection(url, user[0], user[1]);
                    System.out.println("✅ 成功！用户: " + user[0] + " 密码: " + (user[1].isEmpty() ? "（空）" : user[1]));
                    conn.close();
                    return;
                } catch (SQLException e) {
                    System.out.println("  ❌ 用户 '" + user[0] + "' 密码 '" + (user[1].isEmpty() ? "空" : user[1]) + "' 失败");
                }
            }
        }
    }
}
