package game_project.view;

import java.util.Scanner;

import game_project.controller.Controller;
import game_project.model.MemberDTO;

public class MemberUpdateView {
	Controller controller = Controller.getInstance();
	Scanner scan = new Scanner(System.in);
	
	public void update() {
		String user_id, password, name, email, phone;
		
		System.out.println();
		System.out.println("****************************************");
		System.out.println("회원 정보 수정");
		System.out.println("****************************************");
		System.out.println();
		
		MemberListView mlv = new MemberListView();
		mlv.getAllMember();
		
		System.out.print("수정할 회원 아이디 입력: ");
		user_id = scan.nextLine();
		
		System.out.print("비밀번호 입력: ");
		password = scan.nextLine();
		
		System.out.print("이름 입력: ");
		name = scan.nextLine();
		
		System.out.print("이메일 입력: ");
		email = scan.nextLine();
		
		System.out.print("전화번호 입력: ");
		phone = scan.nextLine();
		
		System.out.println("****************************************");
		
		controller.update(new MemberDTO(user_id, password, name, email, phone, null));
	}
}
