package game_project.view;

import java.util.Scanner;

import game_project.controller.Controller;
import game_project.model.MemberDTO;

public class JoinView {

	Controller controller = game_project.controller.Controller.getInstance();
	Scanner scan = new Scanner(System.in);
	
	public void join() {
		String user_id, password, name, email, phone, reg_date;
		
		System.out.println("************************************");
		System.out.println("------------------------------------");
		System.out.println("\t      회원가입");
		System.out.println("------------------------------------");
		
		System.out.print("아이디를 입력해주세요: ");
		user_id = scan.nextLine().trim();
		
		System.out.print("비밀번호를 입력해주세요: ");
		password = scan.nextLine().trim();
		
		System.out.print("이름을 입력해주세요: ");
		name = scan.nextLine().trim();
		
		System.out.print("이메일: ");
        email = scan.nextLine().trim();

        System.out.print("전화번호: ");
        phone = scan.nextLine().trim();
		
        controller.join(new MemberDTO(user_id, password, name, email, phone, null));
	}
}
