package sample;

import java.sql.Connection;
import java.sql.DriverManager;

public class JdbcSample {
	public static void main(String[] args) {
		Connection con = null;
		
		String url = "jdbc:oracle:thin:@127.0.0.1:1521:XE";
		String user = "system";
		String pwd = "oracle";
		
		try {
			con = DriverManager.getConnection(url, user, pwd);
			System.out.println("오라클 연결 성공");
		}catch(Exception e) {
			System.out.println("오라클 연결실패");
		}
	}
}
