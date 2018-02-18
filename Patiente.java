// This is the object called "Patient", which will be instantiated each time a patient is created.
public class Patiente {
	String Pat_Name = null;
	String Pat_SurName = null;
	int Pat_Age = 0;
	String Pat_Address = null;
	String Pat_ContactNumber = null;
	int Pat_id = 0;
	int docRefer = 0;
	
	
	public int getPat_id() {
		return Pat_id;
	}
	public void setPat_id(int pat_id) {
		Pat_id = pat_id;
	}
	public String getPat_Name() {
		return Pat_Name;
	}
	public void setPat_Name(String pat_Name) {
		Pat_Name = pat_Name;
	}
	public String getPat_SurName() {
		return Pat_SurName;
	}
	public void setPat_SurName(String pat_SurName) {
		Pat_SurName = pat_SurName;
	}
	public int getPat_Age() {
		return Pat_Age;
	}
	public void setPat_Age(int pat_Age) {
		Pat_Age = pat_Age;
	}
	public String getPat_Address() {
		return Pat_Address;
	}
	public void setPat_Address(String pat_Address) {
		Pat_Address = pat_Address;
	}
	public String getPat_ContactNumber() {
		return Pat_ContactNumber;
	}
	public void setPat_ContactNumber(String pat_ContactNumber) {
		Pat_ContactNumber = pat_ContactNumber;
	}
	public int getDocRefer() {
		return docRefer;
	}
	public void setDocRefer(int docRefer) {
		this.docRefer = docRefer;
	}

}
//or Patients_Surname = '"+searchName+"'