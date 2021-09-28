package model;

public class Staff {

	private int staffId;
	private String staffName;
	private String pass;
	
	public Staff(int staffId, String staffName) {
		this.staffId = staffId;
		this.staffName = staffName;
	}
	
	public Staff(int staffId, String staffName, String pass) {
		this.staffId = staffId;
		this.staffName = staffName;
		this.pass = pass;
	}
	
	public int getStaffId() {
		return staffId;
	}
	
	public String getStaffName() {
		return staffName;
	}
	
	public String getPass() {
		return pass;
	}
}
