package model;

public class Memo {

	private int memoId;
	private String studentNumber;
	private int staffId;
	private String memo;
	
	public Memo(int memoId, String studentNumber, int staffId, String memo) {
		this.memoId = memoId;
		this.studentNumber = studentNumber;
		this.staffId = staffId;
		this.memo = memo;
	}
	
	public int getMemoId() {
		return memoId;
	}
	
	public String getStudentNumber() {
		return studentNumber;
	}
	
	public int getStaffId() {
		return staffId;
	}
	
	public String getMemo() {
		return memo;
	}
	
	public void setMemo(String memo) {
		this.memo = memo;
	}
}
