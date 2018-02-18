// This is the object called "System_user", which represents the three types of users of the system. Each time
//a new user is registered, this object is instantiated.

public class systemUser {

	int system_userId;
	String user_fullName;
	String userName;
	String userPassword;
	String userType;
	
	
	public int getSystem_userId() {
		return system_userId;
	}
	public void setSystem_userId(int system_userId) {
		this.system_userId = system_userId;
	}
	public String getUser_fullName() {
		return user_fullName;
	}
	public void setUser_fullName(String user_fullName) {
		this.user_fullName = user_fullName;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public String getUserType() {
		return userType;
	}
	public void setUserType(String userType) {
		this.userType = userType;
	}
	
	
	
}
