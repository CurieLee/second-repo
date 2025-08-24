package game_project.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Vector;

import game_project.util.DBConnect;
import game_project.view.ResultView;

public class MemberDAOImpl implements MemberDAO {
	
	private final Connection con;
	public MemberDAOImpl(Connection con) {
		this.con = con;
	}

	@Override
	public boolean join(MemberDTO dto) throws Exception {
		// Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			// con = DBConnect.getConnection();
			pstmt = con.prepareStatement("INSERT INTO member(user_id, password, name, email, phone)"
										+ " VALUES(?, ?, ?, ?, ?)");
			pstmt.setString(1, dto.getUser_id());
			pstmt.setString(2, dto.getPassword());
			pstmt.setString(3, dto.getName());
			pstmt.setString(4, dto.getEmail());
			pstmt.setString(5, dto.getPhone()); 
		
			int result = pstmt.executeUpdate();
			if (result == 0) {
				return false;
			}
			
		} catch (Exception e) {
			throw e; 
		} finally {
			DBConnect.close(pstmt);
		}
		
		return true;
	}

	@Override
	public boolean update(MemberDTO dto) throws Exception {
		// Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			// con = DBConnect.getConnection();
			
			String sql = "UPDATE member SET password=?, name=?, email=?, phone=? "
							+ "WHERE user_id=?";
			pstmt = con.prepareStatement(sql);
			
			pstmt.setString(1, dto.getPassword());
			pstmt.setString(2, dto.getName());
			pstmt.setString(3, dto.getEmail());
			pstmt.setString(4, dto.getPhone()); 
			pstmt.setString(5, dto.getUser_id());
			
			int result = pstmt.executeUpdate();
			return result > 0;
			
		} catch (Exception e) {
			throw e;
		} finally {
			DBConnect.close(pstmt);
		}
	}

	@Override
	public boolean delete(MemberDTO dto) throws Exception {
		// Connection con = null;
		PreparedStatement pstmt = null;
		
		try {
			// con = DBConnect.getConnection();
			String sql = "DELETE member WHERE user_id=?";
			pstmt = con.prepareStatement(sql);
			pstmt.setString(1,  dto.getUser_id());
			
			int result = pstmt.executeUpdate();
			
			if (result == 0) {

				return false;
			} else {
				return true;
			}
		} catch (Exception e) {
			throw e;
		} finally {
			DBConnect.close(pstmt);
		}
	}

	@Override
	public Vector<MemberDTO> getAllMember() throws Exception {
		// Connection con = null;
		PreparedStatement pstmt = null;
		ResultSet rs = null;
		Vector<MemberDTO> dataset = null;
		
		try {
			// con = DBConnect.getConnection();
			pstmt = con.prepareStatement("SELECT * FROM member ORDER BY user_id");
			rs = pstmt.executeQuery();
			dataset = new Vector<MemberDTO> ();
			
			while (rs.next()) {
				dataset.add(new MemberDTO(
						rs.getString(1),
						rs.getString(2), 
						rs.getString(3),
						rs.getString(4), 
						rs.getString(5),
						rs.getString(6)
					));
			}
			
		} catch (Exception e) {
			throw e;
		} finally {
			DBConnect.close(pstmt, rs);
		}
		
		return dataset;
	}

	@Override
	public MemberDTO login(String user_id, String password) throws Exception {
		// Connection con = null;
	    PreparedStatement pstmt = null;
	    ResultSet rs = null;
	    MemberDTO dto = null;

	    try {
	        // con = DBConnect.getConnection();
	        String sql = "SELECT * FROM member WHERE user_id=? AND password=?";
	        pstmt = con.prepareStatement(sql);
	        pstmt.setString(1, user_id);
	        pstmt.setString(2, password);

	        rs = pstmt.executeQuery();

	        if (rs.next()) {
	        	dto = new MemberDTO();
	            dto.setUser_id(rs.getString("user_id"));
	            dto.setPassword(rs.getString("password"));
	            dto.setName(rs.getString("name"));
	            dto.setEmail(rs.getString("email"));
	            dto.setPhone(rs.getString("phone"));
	            // dto.setReg_date(rs.getDate("reg_date"));
	        }
	        
	    } catch (Exception e) {
	        throw e;
	    } finally {
	        DBConnect.close(pstmt);
	    }

	    return dto;
	}

}
