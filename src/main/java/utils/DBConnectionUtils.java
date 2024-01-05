package utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.mysql.*;
public class DBConnectionUtils {
	//private static String url = "jdbc:mysql://node236041-nam-bsongs.j.layershift.co.uk/bsong?useUnicode=true&characterEncoding=UTF-8";
		private static String url = "jdbc:mysql://localhost:3306/qldsv?useUnicode=true&characterEncoding=UTF-8";
		private static String user = "root";
		private static String password = "";
		//private static String password = "ISFbci95222";
		private static Connection conn = null;
		
		public static Connection getConnection() {
			try {
				Class.forName("com.mysql.jdbc.Driver");

				conn = (Connection) DriverManager.getConnection(url, user, password);
			} catch (Exception e) {
				System.out.println("Không thể nạp driver");
				e.printStackTrace();
			}
			return conn;
		}

		public static void main(String[] args) {
			System.out.println(DBConnectionUtils.getConnection());
		}
		
		 public static void closeConnection(Connection con, PreparedStatement pst, ResultSet rs) {
		        try {
		            if (rs != null) {
		                rs.close();
		            }
		            if (pst != null) {
		                pst.close();
		            }
		            if (con != null) {
		                con.close();
		            }
		        } catch (SQLException e) {
		            e.printStackTrace();
		        }
		    }
}
