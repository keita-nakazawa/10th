package model;

public class Memo {

	private int memoId;
	private String studentNumber;
	private int updatedStaffId;
	private String memo;
	
	public Memo(int memoId, String studentNumber, int updatedStaffId, String memo) {
		this.memoId = memoId;
		this.studentNumber = studentNumber;
		this.updatedStaffId = updatedStaffId;
		this.memo = memo;
	}
	
	public int getMemoId() {
		return memoId;
	}
	
	public String getStudentNumber() {
		return studentNumber;
	}
	
	public int getUpdatedStaffId() {
		return updatedStaffId;
	}
	
	public String getMemo() {
		return memo;
	}
	
	public void setMemo(String memo) {
		this.memo = memo;
	}
}
