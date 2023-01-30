package quiz01;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class StudentService {
	Scanner sc = new Scanner(System.in);
	Connection con = null;
	ResultSet rs = null;
	PreparedStatement pstmt = null;
	
	public StudentService() {
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			
			String url = "jdbc:oracle:thin:@127.0.0.1:1521:xe";
			String user = "system";
			String pwd = "oracle";
			
			con = DriverManager.getConnection(url, user, pwd);
		}catch(Exception e) {
			System.out.println("실패");
		}
	}
	
	public int menu() {
		System.out.println("1. 점수입력");
		System.out.println("2. 점수출력");
		System.out.println("3. 점수수정");
		System.out.println("4. 점수삭제");
		System.out.println("0. 프로그램종료");
		System.out.print("선택 : ");
		return sc.nextInt();
	}

	public void insert() throws SQLException {
		Student s = new Student();
		System.out.println("이름입력 : ");
		s.setName(sc.next());
		System.out.println("국어점수입력 : ");
		s.setKor(sc.nextInt());
		System.out.println("영어점수입력 : ");
		s.setEng(sc.nextInt());
		System.out.println("수학점수입력 : ");
		s.setMath(sc.nextInt());
		s.setSum();
		s.setAvg();
		
		String sql = "insert into student values(?,?,?,?,?,?)";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, s.getName());
		pstmt.setInt(2, s.getKor());
		pstmt.setInt(3, s.getEng());
		pstmt.setInt(3, s.getEng());
		pstmt.setInt(5, s.getMath());
		pstmt.setDouble(6, s.getAvg());
		
		int result = pstmt.executeUpdate();
		
		if(result >=1) {
			System.out.println("성적이 입력되었습니다.");
		} else {
			System.out.println("입력에 실패하였습니다.");
		}
		
	}

	public void select() throws SQLException {
		String sql = "select * from student order by name asc";
		pstmt = con.prepareStatement(sql);
		rs = pstmt.executeQuery();
		
		while(rs.next()) {
			String name = rs.getString("name");
			int sum = rs.getInt("sum");
			double avg = rs.getInt("avg");
			
			System.out.println("#### " + name + " ####");
			System.out.println("총점 : " + sum + " 점");
			System.out.println("평균 : " + avg + " 점");
		}
		
	}

	public void update() throws SQLException {
		System.out.print("수정할 이름 입력 : ");
		String name = sc.next();
		
		String sql = "select count(*) from student where name=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, name);
		rs = pstmt.executeQuery();
		
		rs.next();
		int result = rs.getInt(1);
		
		if(result == 0) {
			System.out.println("찾으시는 이름이 없습니다.");
			return;
		}
		
		System.out.print("수정할 국어 점수 입력 : ");
		int kor = sc.nextInt();
		System.out.print("수정할 영어 점수 입력 : ");
		int eng = sc.nextInt();
		System.out.print("수정할 수학 점수 입력 : ");
		int math = sc.nextInt();
		int sum = kor + eng + math;
		double avg = sum / 3.0;
		
		sql = "update student set kor=?,eng=?,math=?,sum=?,avg=? where name=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setInt(1, kor);
		pstmt.setInt(2, eng);
		pstmt.setInt(3, math);
		pstmt.setInt(4, sum);
		pstmt.setDouble(5, avg);
		pstmt.setString(6, name);
		
		result = pstmt.executeUpdate();
		
		if(result >= 1) {
			System.out.println("수정이 완료 되었습니다.");
		} else {
			System.out.println("수정에 실패했습니다.");
		}
		
	}

	public void delete() throws SQLException {
		System.out.print("삭제할 이름 입력 : ");
		String name = sc.next();
		
		String sql = "delete from student where name=?";
		pstmt = con.prepareStatement(sql);
		pstmt.setString(1, name);
		int result = pstmt.executeUpdate();
		
		if(result >=1) {
			System.out.println("삭제가 성공되었습니다.");
		} else {
			System.out.println("삭제에 실패했습니다.");
		}
		
	}

}
