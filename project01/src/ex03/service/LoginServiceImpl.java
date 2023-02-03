package ex03.service;

import javafx.scene.Parent;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

public class LoginServiceImpl implements LoginService{

	@Override
	public void loginProc(Parent root) {

		TextField id = (TextField) root.lookup("#txtId");
		PasswordField pw = (PasswordField) root.lookup("#txtPw");
		
		System.out.println("아이디 : " + id.getText());
		System.out.println("암호 : " + pw.getText());
		System.out.println("로그인 버튼이 눌렸습니다.");
		
	}

	@Override
	public void cancelProc(Parent root) {
		
		TextField id = (TextField) root.lookup("#txtId");
		PasswordField pw = (PasswordField) root.lookup("#txtPw");
		
		id.clear();
		pw.clear();
		System.out.println("취소 버튼이 눌렸습니다.");
	}

	@Override
	public void membershipProc(Parent root) {
		
		System.out.println("회원가입 버튼이 눌렸습니다.");
	}

}
