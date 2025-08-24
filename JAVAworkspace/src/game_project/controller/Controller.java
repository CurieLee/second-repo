package game_project.controller;

import java.util.Vector;

import game_project.model.MemberDAO;
import game_project.model.MemberDAOImpl;
import game_project.model.MemberDTO;
import game_project.view.MemberListView;
import game_project.view.ResultView;

public class Controller {

	private static Controller instance = new Controller();
	private Controller() {}
	
	public static Controller getInstance() {
		return instance;
	}
	
	MemberDAO dao = new MemberDAOImpl();

	public void join(MemberDTO newDTO) {
		try {
			MemberDTO dto = new MemberDTO();
			dto.setUser_id(newDTO.getUser_id());
			dto.setPassword(newDTO.getPassword());
			dto.setName(newDTO.getName());
			dto.setEmail(newDTO.getEmail());
			dto.setPhone(newDTO.getPhone());
		
			if (dao.join(dto))
				ResultView.successMsg("회원가입이 완료되었습니다.");
		} catch (Exception e) {
			e.printStackTrace();
			ResultView.errorMsg("회원가입 오류");
		}
		
	}
	
	public void update(MemberDTO newDTO) {
		try {
			MemberDTO dto = new MemberDTO();
			dto.setUser_id(newDTO.getUser_id());
			dto.setPassword(newDTO.getPassword());
			dto.setName(newDTO.getName());
			dto.setEmail(newDTO.getEmail());
			dto.setPhone(newDTO.getPhone());
			
			if (dao.update(dto)) {
				ResultView.successMsg("회원 정보가 수정되었습니다.");
			} else {
				ResultView.errorMsg("회원 정보 수정 오류");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			ResultView.errorMsg("회원 정보 수정 오류");
		}
		
	}
	public void delete(String user_id) {
		try {
			MemberDTO dto = new MemberDTO();
			dto.setUser_id(user_id);
			
			if (dao.delete(dto)) {
				ResultView.successMsg(user_id + " 회원을 삭제했습니다. ");
			}
		} catch (Exception e) {
			e.printStackTrace();
			ResultView.errorMsg("회원 삭제 오류");
		}
	}
	public void getAllMember() {
		try {
			Vector<MemberDTO> dataSet = dao.getAllMember();
			
			if (dataSet.size() != 0) {
				MemberListView.showAllMember(dataSet);
			} else {
				ResultView.successMsg("검색 결과가 없습니다.");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
			ResultView.errorMsg("잠시후에 재요청 바랍니다. ");
		}
	}
	
	public boolean login(String user_id, String password) {
		try {
	        MemberDTO dto = dao.login(user_id, password);
	        if (dto != null) {
	        	ResultView.successMsg(user_id + "님! 환영합니다.");
	        	return true;
	        } else {
	        	ResultView.errorMsg("아이디와 비밀번호를 확인해주세요.");
	        	return false;
	        }
	    } catch (Exception e) {
	        e.printStackTrace();
	        ResultView.errorMsg("로그인 중 오류가 발생했습니다.");
	        return false;
	    }
	}
}


