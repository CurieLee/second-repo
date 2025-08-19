package game_project.view;

import java.util.Vector;

import game_project.controller.Controller;
import game_project.model.MemberDTO;

public class MemberListView {
	Controller controller = Controller.getInstance();
	
	public void getAllMember() { // 컨트롤러에 요청 전달
		controller.getAllMember();
	}
	
	// 컨트롤러로부터 전달된 데이터 출력
	public static void showAllMember(Vector<MemberDTO> dataSet) {
		System.out.println("\n*******************************");
		System.out.println("회원 정보 조회");
		System.out.println("*********************************");
		
		System.out.println("회원아이디\t 비밀번호\t\t 회원명\t 이메일\t\t 전화번호\t\t 가입일");
		System.out.println("--------------------------------------------");
		
		for (MemberDTO dto : dataSet) {
			System.out.println(dto);
		}
		
	}
}
