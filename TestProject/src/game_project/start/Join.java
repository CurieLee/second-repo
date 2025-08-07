package game_project.start;

import java.util.Scanner;

import game_project.UserDAO;
import game_project.UserDAOImpl;
import game_project.UserDTO;

public class Join {
	private UserDAO dao; // 사용자 데이터 접근
	
	// 생성자를 통해 DAO 주입 Join 시작
	public Join(UserDAO dao) {
		this.dao = dao;
		startJoin();
	}
	
	// 회원가입 절차
	public void startJoin() {	
	    Scanner scan = new Scanner(System.in);
	    
	    System.out.println("************************************");
		System.out.println("------------------------------------");
		System.out.println("\t      회원가입");
		System.out.println("------------------------------------");
		System.out.print("사용할 아이디를 입력해주세요: ");
		String id = scan.nextLine().trim();
		System.out.print("사용할 비밀번호를 입력해주세요: ");
		String pwd = scan.nextLine().trim();
		System.out.print("회원 이름을 입력해주세요: ");
		String name = scan.nextLine().trim();
		System.out.println();
		
		// 입력 유효성 검사
		if (id.isEmpty() || pwd.isEmpty() || name.isEmpty()) {
			System.out.println("입력값이 모두 필요합니다. 빈 칸 없이 입력해주세요.");
			return;
		}
		
		// 사용자 생성 DAO 통해서 등록
		UserDTO newUser = new UserDTO(id, pwd, name);
		dao.insertUser(newUser);
	}
}
