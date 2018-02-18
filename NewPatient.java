import java.awt.ComponentOrientation;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class NewPatient extends JFrame implements ActionListener {
	
	//This screen allows the secretary users to create a new appointment and registered it in the database. By doing this, a new object
	//of "Patient" type is also instantiated. 
	
		JTextField patient_nameField = null;
		JTextField patient_surnameField = null;
		JTextField patient_ageField = null;
		JTextField patient_addressField = null;
		JTextField patient_phoneField = null;
		JTextField DoctorRefer = null;
		
	public NewPatient() {
			
		super ("Narnia Hospital");
		setSize(600,600);
		setVisible(true);
		this.setLayout(new GridLayout(12,1));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		JPanel firstOneSec = new JPanel();
		this.add(firstOneSec);
		//Greets with user's name:
			JLabel GreetingSec = new JLabel("Hello " + LogginPage.RightName + ". " + "Please fill in the following information:");
			firstOneSec.add(GreetingSec);
		
		JPanel secondOne = new JPanel();
		this.add(secondOne);
		
			JLabel PatName = new JLabel ("Name: ");
			secondOne.add(PatName);
			
			patient_nameField = new JTextField(20);
			secondOne.add(patient_nameField);
		
		JPanel thirdOne = new JPanel();
		this.add(thirdOne);
		
			JLabel PatSurname = new JLabel ("Surname: ");
			thirdOne.add(PatSurname);
	
			patient_surnameField = new JTextField(20);
			thirdOne.add(patient_surnameField);
	
	
		JPanel fourthOne = new JPanel();
		this.add(fourthOne);
		
			JLabel PatAge = new JLabel ("Age: ");
			fourthOne.add(PatAge);

			patient_ageField = new JTextField(20);
			fourthOne.add(patient_ageField);
		
		JPanel fifththOne = new JPanel();
		this.add(fifththOne);
			
			JLabel PatAddress = new JLabel ("Address: ");
			fifththOne.add(PatAddress);
	
			patient_addressField = new JTextField(20);
			fifththOne.add(patient_addressField);
		
		JPanel sixththOne = new JPanel();
		this.add(sixththOne);
				
			JLabel PatPhone = new JLabel ("Phone: ");
			sixththOne.add(PatPhone);
		
			patient_phoneField = new JTextField(10);
			sixththOne.add(patient_phoneField);
			
		JPanel seventhOne = new JPanel();
		this.add(seventhOne);
					
			JLabel AppDocName = new JLabel ("Doctor Id: ");
			seventhOne.add(AppDocName);
			
			DoctorRefer = new JTextField(20);
			seventhOne.add(DoctorRefer);
			
		
		JPanel ninthOne = new JPanel();
		this.add(ninthOne);
			
			JButton createPat = new JButton("Register patient");
			createPat.addActionListener(this);
			createPat.setActionCommand("createPat");
			ninthOne.add(createPat);
			
		JPanel tenthOne = new JPanel();
		this.add(tenthOne);
		
			JButton goBack = new JButton ("Go Back");
			tenthOne.add(goBack);
			goBack.addActionListener(new ActionListener() {
		           public void actionPerformed(ActionEvent e) {
		        	   new SecretaryScreen();
		        	   
		           }
			});
			
		validate();
		repaint();
	
	
}




public static void main(String[] args) {
	new NewPatient();

}

//Information is sent and written on database and new object is instantiated:
		
		@Override
		public void actionPerformed(ActionEvent e) {
				
			String Name = patient_nameField.getText();
			String Surname = patient_surnameField.getText();
			int Age = Integer.parseInt(patient_ageField.getText());
			String Address = patient_addressField.getText();
			String Phonne = patient_phoneField.getText();
			int Doctor = Integer.parseInt(DoctorRefer.getText());
			
			
			DBH db = new DBH();
			
			String sql = "INSERT INTO  `Narnia_Hospital`.`Patients` (`Patients_Name`, `Patients_Surname`, `Patients_Age`, `Patients_Address`, `Patients_Phone`, `referDoctor`) VALUES ('"+Name+"','"+Surname+"','"+Age+"','"+Address+"', '"+Phonne+"','"+Doctor+"')"; 
			
			
			ResultSet rs = null;
			
			try{
			  rs = db.executeCall(sql);
	       		
			  while(rs.next()){
				  
				  
				  Patiente P1 = new Patiente();
				  
				  P1.setPat_Name(Name);
				  P1.setPat_SurName(Surname);
				  P1.setPat_Age(Age);
				  P1.setPat_Address(Address);
				  P1.setPat_ContactNumber(Phonne);
				  P1.setDocRefer(Doctor);
				 
				  
				  
				  	
					 }
				  
	  	 
			 
			  
			}catch (Exception ex){}
			
			//Offers the option to create a new one or leave this screen.
			JOptionPane.showMessageDialog(this, "Register Successful!");
			
			 int n = JOptionPane.showConfirmDialog(this,"Do you want to add another patient?", "Message Selected", JOptionPane.YES_NO_OPTION);
				
			 if (n == 0){ 
				 this.setVisible(false);
				 new NewPatient();
				
			} else if (n == 1){
				 this.setVisible(false);
				 new SecretaryScreen();
			}
		}
}

