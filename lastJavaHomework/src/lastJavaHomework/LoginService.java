package lastJavaHomework;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;


public class LoginService {
	Scanner sc = new Scanner(System.in);
	Connection con = null;
	ResultSet rs = null;
	PreparedStatement psm = null;
	boolean loginCheck;
	String loginId;

	public LoginService() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");

			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String user = "system";
			String pwd = "oracle";

			con = DriverManager.getConnection(url, user, pwd);

		} catch(Exception e) {
			System.out.println("오류");
		}
	}


	public int menu() {
		if(loginCheck) {
			System.out.println(loginId + "님 환영합니다.");
		}
		System.out.println("1. 회원가입");
		System.out.println("2. 로그인");
		if(loginCheck) {
		System.out.println("3. 회원정보수정");
		System.out.println("4. 회원탈퇴");
		System.out.println("5. 회원검색");
		System.out.println("6. 로그아웃");
		}
		System.out.println("0. 프로그램종료");
		System.out.print("선택 : ");
		int menu = sc.nextInt();
		
		if(loginCheck == false ) {
			if(menu >= 3 )
			menu =100;
		}
		return menu;
	}


	public void signUp() throws SQLException {
		Login l = new Login();
		int result = 0;
		do {
			System.out.println("아이디 입력 : ");
			l.setId(sc.next());

			String sql = "select count(*) from test_user where id=?";
			psm = con.prepareStatement(sql);
			psm.setString(1, l.getId());

			rs = psm.executeQuery();

			rs.next();
			result = rs.getInt(1);

			if(result >= 1) {
				System.out.println("이미 가입한 회원입니다.\n");
			}
		}while(result != 0);
		System.out.println("비밀번호 입력 : ");
		l.setPwd(sc.next());
		System.out.println("이름 입력 : ");
		l.setName(sc.next());
		System.out.println("이메일 입력 : ");
		l.setEmail(sc.next());

		String sql = "insert into test_user values(?,?,?,?,sysdate)";
		psm = con.prepareStatement(sql);
		psm.setString(1, l.getId());
		psm.setString(2, l.getPwd());
		psm.setString(3, l.getName());
		psm.setString(4, l.getEmail());

		result = psm.executeUpdate();

		if(result >=1) {
			System.out.println("회원가입이 완료되었습니다.");
		} else {
			System.out.println("실패");
		}

	}



	public void signIn() throws SQLException {
		System.out.print("아이디 : ");
		String id = sc.next();
		System.out.print("비밀번호 : ");
		String pwd = sc.next();
		
		String sql = "select count(*) from test_user where id=? and pwd=?";
		psm = con.prepareStatement(sql);
		psm.setString(1, id);
		psm.setString(2, pwd);
		
		rs = psm.executeQuery();
		rs.next();
		int result = rs.getInt(1);
		
		if(result == 1) {
			System.out.println("로그인 되었습니다.");
			loginCheck = true;
			loginId = id;
		} else {
			System.out.println("실패");
		}

	}


	public void update() throws SQLException {
	
		while(true) {
		System.out.println("1. 비밀번호 변경");
		System.out.println("2. 이름 변경");
		System.out.println("3. 이메일 변경");
		System.out.println("0. 메뉴로 돌아가기");
		System.out.print("선택 : ");
		int menu = sc.nextInt();
		int result = 0;
		String sql = null;
		switch(menu) {
		case 1:
			System.out.print("비밀번호 입력 : ");
			String pwd = sc.next();
			
			sql = "update test_user set pwd=? where id=?";
			psm = con.prepareStatement(sql);
			psm.setString(1, pwd);
			psm.setString(2, loginId);
			
			result = psm.executeUpdate();
			break;
		case 2:
			System.out.print("이름 입력 : ");
			String name = sc.next();
			
			sql = "update test_user set pwd=? where id=?";
			psm = con.prepareStatement(sql);
			psm.setString(1, name);
			psm.setString(2, loginId);
			
			result = psm.executeUpdate();
			break;
		case 3:
			System.out.print("이름 입력 : ");
			String email = sc.next();
			
			sql = "update test_user set pwd=? where id=?";
			psm = con.prepareStatement(sql);
			psm.setString(1, email);
			psm.setString(2, loginId);
			
			result = psm.executeUpdate();
			break;
		case 0:
			System.out.println("메뉴로 이동합니다.");
		default :
			System.out.println("잘못입력하였습니다.");
		}
		if(result >= 1) {
			System.out.println("정보가 수정되었습니다.");
		} else {
			System.out.println("실패");
		}
		System.out.println();
		}
	}


	public void delete() throws SQLException {
		System.out.println("아이디 입력 : ");
		String id = sc.next();
		
		String sql = "delete from test_user where id=?";
		psm = con.prepareStatement(sql);
		psm.setString(1, id);
		
		int result = psm.executeUpdate();
		
		if(result >= 1) {
			System.out.println(id + " 님의 정보를 삭제합니다.");
			loginCheck = false;
			loginId = null;
		} else {
			System.out.println("가입하지 않은 회원정보입니다.");
		}

	}


	public void surch() throws SQLException {
		System.out.println("아이디 입력 : ");
		String id = sc.next();
		
		
		String sql = "select * from test_user where id=?";
		psm = con.prepareStatement(sql);
		psm.setString(1, id);
		
		rs = psm.executeQuery();
		
		if(rs.next()) {
			System.out.println("회원이름 : " + rs.getString(1));
			System.out.println("비밀번호 : " + rs.getString(2));
			System.out.println("이메일 : " + rs.getString(3));
			System.out.println("가입일 : " + rs.getShort(4));
			
		} else {
			System.out.println("등록되지 않은 회원입니다.");
		}
	}


	public void signOut() {
		System.out.println("로그아웃 되었습니다.");
		loginCheck = false;
		loginId = null;
	}
}
