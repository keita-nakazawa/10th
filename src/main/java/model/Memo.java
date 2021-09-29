package model;

public class Memo {

	private int memoId;
	private String studentNumber;
	private int updatedStaffId;
	private String memoText;
	
	public Memo(String memoText) {
		this.memoText = memoText;
	}
	
	public Memo(int memoId, String studentNumber, int updatedStaffId, String memoText) {
		this.memoId = memoId;
		this.studentNumber = studentNumber;
		this.updatedStaffId = updatedStaffId;
		this.memoText = memoText;
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
	
	public String getMemoText() {
		return memoText;
	}
	
	public void setMemo(String memoText) {
		this.memoText = memoText;
	}
}
