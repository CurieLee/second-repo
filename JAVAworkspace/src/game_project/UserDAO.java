package game_project;

public interface UserDAO {
	public void insertUser(UserDTO dto);
	public void printAllUser();
	UserDTO loginUser(String userID, String userPWD);
}
