package lastJavaHomework;

import java.sql.SQLException;

public class LoginMain {
	public static void main(String[] args) throws Exception {
		LoginService ls = new LoginService();
		
		while(true) {
			int menu = ls.menu();
			switch(menu) {
			case 1:
				System.out.println("### 회원가입 ###");
				ls.signUp();
				break;
			case 2:
				System.out.println("### 로그인 ###");
				ls.signIn();
				break;
			case 3:
				System.out.println("### 정보 수정 ###");
				ls.update();
				break;
			case 4:
				System.out.println("### 회원탈퇴 ###");
				ls.delete();
				break;
			case 5:
				System.out.println("### 회원검색 ###");
				ls.surch();
				break;
			case 6:
				ls.signOut();
				break;
			case 0:
				System.out.println("프로그램을 종료합니다...");
				return;
			default : 
				System.out.println("잘못 입력하였습니다.");
			}
		}
	}
}
