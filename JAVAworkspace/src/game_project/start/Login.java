package game_project.start;

import java.util.Scanner;
import game_project.UserDAO;
import game_project.UserDTO;

public class Login {

	private UserDAO dao; // 사용자 데이터 접근
		
	// 생성자를 통해 DAO 주입 Login 시작
	public Login(UserDAO dao) {
		this.dao = dao;
		startLogin();
	}
	
	// 로그인 절차
	private void startLogin() {
		Scanner scan = new Scanner(System.in);
	    
	    System.out.println("************************************");
		System.out.println("------------------------------------");
		System.out.println("\t    로그인");
		System.out.println("------------------------------------");
		System.out.print("아이디: ");
		String id = scan.nextLine().trim();
		System.out.print("비밀번호: ");
		String pwd = scan.nextLine().trim();
		System.out.println();
		
		// 입력값 유효성 검사
		if (id.isEmpty() || pwd.isEmpty()) {
			System.out.println("아이디와 비밀번호는 모두 입력해야 합니다.");
			return;
		}
		
		// DAO 통해서 로그인 시도
		UserDTO user = dao.loginUser(id, pwd);
		if (user != null)
			System.out.println("로그인 성공! " + user.getUserName() + "님 환영합니다.");
        else
            System.out.println("아이디 또는 비밀번호가 일치하지 않습니다.");
		
	}
}
