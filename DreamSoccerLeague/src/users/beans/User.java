package users.beans;

public class User 
{
	private String userName;
	private String password;
	private int credits;
	private String mail;
	private long phoneNo;
	private long panNo;
	
	public User()
	{
		
	}
	
	public User(String userName, String password,String mail,long phoneNo,long panNo) {
		super();
		this.userName = userName;
		this.password = password;
		this.mail = mail;
		this.phoneNo=phoneNo;
		this.panNo=panNo;

	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getCredits() {
		return credits;
	}
	public void setCredits(int credits) {
		this.credits = credits;
	}
	public String getMail() {
		return mail;
	}
	public void setMail(String mail) {
		this.mail = mail;
	}
	public long getPhoneNo() {
		return phoneNo;
	}

	public void setPhoneNo(long phoneNo) {
		this.phoneNo = phoneNo;
	}

	public long getPanNo() {
		return panNo;
	}

	public void setPanNo(long panNo) {
		this.panNo = panNo;
	}

	@Override
	public String toString() {
		return "User [userName=" + userName + ", password=" + password + ", credits=" + credits + ", mail=" + mail
				+ ",  phoneNo=" + phoneNo + ", panNo=" + panNo + "]";
	}
	
	
}
