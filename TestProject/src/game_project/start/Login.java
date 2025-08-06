package game_project.start;

import java.util.Scanner;
import game_project.UserDAO;
import game_project.UserDTO;

public class Login {

	private UserDAO dao;
		
	public Login(UserDAO dao) {
		this.dao = dao;
		startLogin();
	}
	
	private void startLogin() {
		Scanner scan = new Scanner(System.in);
	    
	    System.out.println("************************************");
		System.out.println("------------------------------------");
		System.out.println("\t    로그인");
		System.out.println("------------------------------------");
		System.out.print("아이디: ");
		String id = scan.nextLine();
		System.out.print("비밀번호: ");
		String pwd = scan.nextLine();
		System.out.println();
		
		UserDTO user = dao.loginUser(id, pwd);
		if (user != null)
			System.out.println("로그인 성공! " + user.getUserName() + "님 환영합니다.");
        else
            System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
		
	}
}
