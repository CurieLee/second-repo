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
	
		System.out.println();
		System.out.printf("%-15s %-15s %-10s %-25s %-18s %-12s\n",
			    "회원아이디", "비밀번호", "회원명", "이메일", "전화번호", "가입일");
		System.out.println("------------------------------------------------------------------------------------------------");
		
		for (MemberDTO dto : dataSet) {
			System.out.printf("%-15s %-15s %-10s %-25s %-18s %-12s\n",
			        dto.getUser_id(),
			        dto.getPassword(),
			        dto.getName(),
			        dto.getEmail(),
			        dto.getPhone(),
			        dto.getReg_date() != null ? dto.getReg_date() : "N/A"
			    );
		}
		
	}
}
