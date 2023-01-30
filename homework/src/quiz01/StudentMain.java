package quiz01;

import java.sql.SQLException;

public class StudentMain {
	public static void main(String[] args) throws SQLException {
		StudentService ss = new StudentService();
		
		while(true) {
			int menu = ss.menu();
			
			switch(menu) {
			case 1:
				ss.insert();
				break;
			case 2:
				ss.select();
				break;
			case 3:
				ss.update();
				break;
			case 4:
				ss.delete();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다.");
				return;
			default :
				System.out.println("잘못입력하였습니다.");
			}
		}
	}
}
