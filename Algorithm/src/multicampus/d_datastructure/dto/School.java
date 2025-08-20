package multicampus.d_datastructure.dto;

public class School implements Comparable<School> {
	
	private String name;
	private String address;
	private String level;
	
	public School(String name, String address, String level) {
		super();
		this.name = name;
		this.address = address;
		this.level = level;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getLevel() {
		return level;
	}
	public void setLevel(String level) {
		this.level = level;
	}
	
	public String toString() {
		return "School [ name=" + name + ", address= " + address + ", level=" + level + "]";
	}
	@Override
	public int compareTo(School o) {
		if (this.level.equals(o.level) == true) {
			return this.name.compareTo(o.name) * -1;
		}
 		return this.level.compareTo(o.level);
	}
	
}
