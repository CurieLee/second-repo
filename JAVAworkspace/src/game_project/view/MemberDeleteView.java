package game_project.view;

import java.util.Scanner;

import game_project.controller.Controller;

public class MemberDeleteView {
	Controller controller = Controller.getInstance();
	Scanner scan = new Scanner(System.in);
	
	public void delete() {
		String user_id;
		
		System.out.println("\n*************************");
		System.out.println("학생정보 삭제");
		System.out.println("***************************");
		
		MemberListView mlv = new MemberListView();
		mlv.getAllMember();
		
		System.out.print("삭제할 회원 아이디 입력: ");
		user_id = scan.nextLine();
		System.out.println("\n*************************");
		
		controller.delete(user_id);
		
	}
}
