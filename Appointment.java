// The object called "Appointment" which is created each time a form for appointments is fully filled and registered. 
public class Appointment {
	
	String appDate = null;
	String appTime = null;
	String patientName = null;
	String patientSurname = null;
	int PatId = 0;
	String doctorName= null;
	String serviceRequired = null;
	
	public String getAppDate() {
		return appDate;
	}
	public void setAppDate(String appDate) {
		this.appDate = appDate;
	}
	public String getAppTime() {
		return appTime;
	}
	public void setAppTime(String appTime) {
		this.appTime = appTime;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientSurname() {
		return patientSurname;
	}
	public void setPatientSurname(String patientSurname) {
		this.patientSurname = patientSurname;
	}
	public int getPatId() {
		return PatId;
	}
	public void setPatId(int patId) {
		PatId = patId;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getServiceRequired() {
		return serviceRequired;
	}
	public void setServiceRequired(String serviceRequired) {
		this.serviceRequired = serviceRequired;
	}
	
	

	
	
}
