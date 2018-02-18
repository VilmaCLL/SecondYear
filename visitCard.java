// This is the object called "VisitCard", which will be instantiated each time a doctor fills a patient visit card in the system. 
public class visitCard {
	
	int DocId = 0;
	String visitDate= null;
	int DocPatientId = 0;
	String visitComments = null;
	String medPresc = null;
	String prescType = null;
	
	
	public int getDocId() {
		return DocId;
	}
	public void setDocId(int docId) {
		DocId = docId;
	}
	public String getVisitDate() {
		return visitDate;
	}
	public void setVisitDate(String visitDate) {
		this.visitDate = visitDate;
	}
	public int getDocPatientId() {
		return DocPatientId;
	}
	public void setDocPatientId(int docPatientId) {
		DocPatientId = docPatientId;
	}
	public String getVisitComments() {
		return visitComments;
	}
	public void setVisitComments(String visitComments) {
		this.visitComments = visitComments;
	}
	public String getMedPresc() {
		return medPresc;
	}
	public void setMedPresc(String medPresc) {
		this.medPresc = medPresc;
	}
	public String getPrescType() {
		return prescType;
	}
	public void setPrescType(String prescType) {
		this.prescType = prescType;
	}
	
	
	
	
}
