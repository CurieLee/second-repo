package game_project.model;

import java.util.Vector;

public interface MemberDAO {
	
	public boolean join(MemberDTO dto) throws Exception;
	public boolean update(MemberDTO dto) throws Exception;
	public boolean delete(MemberDTO dto) throws Exception;
	public Vector<MemberDTO> getAllMember() throws Exception;
	public MemberDTO login(String user_id, String password) throws Exception;
}
