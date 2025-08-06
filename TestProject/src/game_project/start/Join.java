package game_project.start;

import java.util.Scanner;

import game_project.UserDAO;
import game_project.UserDAOImpl;
import game_project.UserDTO;

public class Join {
	private UserDAO dao;
	
	public Join(UserDAO dao) {
		this.dao = dao;
		startJoin();
	}
	
	public void startJoin() {	
	    Scanner scan = new Scanner(System.in);
	    
	    System.out.println("************************************");
		System.out.println("------------------------------------");
		System.out.println("\t      회원가입");
		System.out.println("------------------------------------");
		System.out.print("사용할 아이디를 입력해주세요: ");
		String id = scan.nextLine();
		System.out.print("사용할 비밀번호를 입력해주세요: ");
		String pwd = scan.nextLine();
		System.out.print("회원 이름을 입력해주세요: ");
		String name = scan.nextLine();
		System.out.println();
		
		UserDTO newUser = new UserDTO(id, pwd, name);
		dao.insertUser(newUser);
	}
}
