package ex03;

import ex03.service.LoginService;
import ex03.service.LoginServiceImpl;
import javafx.scene.Parent;

public class Controller {
	private Parent root;
	private LoginService ls;
	
	public Controller() {
		ls = new LoginServiceImpl();
	}
	
	public void setRoot(Parent root) {
		
		this.root = root;
	}

	public void loginProc() {
		ls.loginProc(root);
	}
	
	public void cancelProc() {
		ls.cancelProc(root);
	}
	
	public void membershipProc() {
		ls.membershipProc(root);
	}
}
