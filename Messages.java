//This is the object called "messages", which will be instantiated each time a messages form is fully filled and registered 
//in the database.
public class Messages {
	
	String date = null;
	int PatId = 0;
	String messageContent = null;
	int doctorRefer = 0;
	String statusMes = null;
	
	
	public String getStatusMes() {
		return statusMes;
	}
	public void setStatusMes(String statusMes) {
		this.statusMes = statusMes;
	}
	public int getDoctorRefer() {
		return doctorRefer;
	}
	public void setDoctorRefer(int doctorRefer) {
		this.doctorRefer = doctorRefer;
	}
	String checked = null;
	
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	public int getPatId() {
		return PatId;
	}
	public void setPatId(int patId) {
		PatId = patId;
	}
	public String getMessageContent() {
		return messageContent;
	}
	public void setMessageContent(String messageContent) {
		this.messageContent = messageContent;
	}
	public String getChecked() {
		return checked;
	}
	public void setChecked(String checked) {
		this.checked = checked;
	}
	
	
	

}
