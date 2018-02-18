// This is the object called "Bill", which will be instantiated each time a bill is created.
public class Bill {

	
	String visitDate = null;
	int billIdPat = 0;
	int DoctorId = 0;
	String servicios = null;
	double totalVisit = 0.0;
	String billStatus = null;
	
	public String getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}
	public int getBillIdPat() {
		return billIdPat;
	}
	public void setBillIdPat(int billIdPat) {
		this.billIdPat = billIdPat;
	}
	public int getDoctorId() {
		return DoctorId;
	}
	public void setDoctorId(int DoctorId) {
		this.DoctorId = DoctorId;
	}
	public String getServicios() {
		return servicios;
	}
	public void setServicios(String servicios) {
		this.servicios = servicios;
	}
	public double getTotalVisit() {
		return totalVisit;
	}
	public void setTotalVisit(double totalVisit) {
		this.totalVisit = totalVisit;
	}
	public String getBillStatus() {
		return billStatus;
	}
	public void setBillStatus(String billStatus) {
		this.billStatus = billStatus;
	}
	
	
	
}
