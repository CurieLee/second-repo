package game_project.model;

public class MemberDTO {
	String user_id;
	String password;
	String name;
	String email;
	String phone;
	String reg_date;
	
	public MemberDTO() {}
	public MemberDTO(String user_id, String password, String name, String email, String phone) {
		this.user_id = user_id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.reg_date = reg_date;
	}
	
	public MemberDTO(String user_id, String password, String name, String email, 
					 String phone, String reg_date) {
		this.user_id = user_id;
		this.password = password;
		this.name = name;
		this.email = email;
		this.phone = phone;
		this.reg_date = reg_date;
	}
	public String getUser_id() {
		return user_id;
	}
	public void setUser_id(String user_id) {
		this.user_id = user_id;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPhone() {
		return phone;
	}
	public void setPhone(String phone) {
		this.phone = phone;
	}
	public String getReg_date() {
		return reg_date;
	}
	public void setReg_date(String reg_date) {
		this.reg_date = reg_date;
	}
	
	public String toString() {
		return user_id + "\t" + password + "\t" + name + "\t" + email + "\t" + phone + "\t" + reg_date;
	}
	
	
}
