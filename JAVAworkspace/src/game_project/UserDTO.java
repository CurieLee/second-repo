package game_project;

public class UserDTO {
	private String userID;
	private String userPWD;
	private String userName;
	
	public UserDTO(String userID, String userPWD, String userName) {
		this.userID = userID;
		this.userPWD = userPWD;
		this.userName = userName;
	}

	public String getUserID() {
		return userID;
	}

	public void setUserID(String userID) {
		this.userID = userID;
	}

	public String getUserPWD() {
		return userPWD;
	}

	public void setUserPWD(String userPWD) {
		this.userPWD = userPWD;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}
	
	// UserID/UserName 이 같으면 같은 사람-> 추가하지 않음
	@Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (!(obj instanceof UserDTO)) return false;
        UserDTO other = (UserDTO) obj;
        return userID.equals(other.userID) && userName.equals(other.userName);
    }

    @Override
    public int hashCode() {
        return (userID + userName).hashCode();
    }

    // user 확인용
    @Override
    public String toString() {
        return "UserDTO [userID=" + userID + ", userPWD=" + userPWD + ", userName=" + userName + "]";
    }
	
}
