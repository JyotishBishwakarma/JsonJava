
public class CustomerDetailsAppium {
	
	private String CourseName;
	private String PurchasedDate;
	private int Amount;
	private String Location;
	private String studentName;
	
	public String getStudentName() {
		return studentName;
	}
	public void setStudentName(String studentName) {
		this.studentName = studentName;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	public String getPurchasedDate() {
		return PurchasedDate;
	}
	public void setPurchasedDate(String purchasedDate) {
		PurchasedDate = purchasedDate;
	}
	public int getAmount() {
		return Amount;
	}
	public void setAmount(int amount) {
		Amount = amount;
	}
	public String getLocation() {
		return Location;
	}
	public void setLocation(String location) {
		Location = location;
	}
	
	public String toString() {
		return (CourseName);
		
	}
	

}
