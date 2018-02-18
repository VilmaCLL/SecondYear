import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.activation.CommandInfo;
import javax.swing.*;
import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DoctorType extends JFrame implements ActionListener{
//This is the main screen for doctor users. Here, they can search for patients, visit cards and messages; and also get to the other
//screens doctors need to use. From every other screen, doctors can always come back to this one. 

    JScrollBar tableBar = null;
    JScrollPane jScrollPane1 = null;
    JTextArea textArea1 = null;
    JTextField instText = null;
    String date = null;
    double totalAmmount = 0;
    String Pat_Name = null;
	String Pat_SurName = null;
	String DocRefer = null;
	String services = null;
	String contact = null;
	int age = 0;
	String Message = null;
	String StatusMes = null;
	int docIdPres = 0;
	String MedPres = null;
	DBH db = new DBH();

	private AbstractButton textArea;
    
	public DoctorType (){
		
		super ("Narnia Hospital");
		setSize(500,500);
		setVisible(true);
		this.setLayout(new GridLayout(12,1));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		JPanel panel1 = new JPanel();
		this.add(panel1);
	
			JLabel Greeting = new JLabel("Welcome " + LogginPage.RightName); //Greeting user with her or his name. 
			panel1.add(Greeting);
		
		JPanel secondOne = new JPanel();
		this.add(secondOne);
		
			
			JButton seeBills = new JButton ("See Appointments");
			secondOne.add(seeBills);
			seeBills.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
							new AllApp ();
						}
			   
			});
			
		JPanel fiftinthOne = new JPanel();
		this.add(fiftinthOne);
			
				
				JButton seeMessages = new JButton ("See Messages");
				fiftinthOne.add(seeMessages);
				seeBills.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
								new MessageScreen ();
							}
				   
				});
			
		JPanel thirdOne = new JPanel();
		this.add(thirdOne);
		
			JLabel searchBill = new JLabel ("Search Patient or Visit Card:");
			thirdOne.add(searchBill);
		
			
		JPanel fourthOne = new JPanel();
		this.add(fourthOne);	
			
			JLabel inst = new JLabel ("Please write Patient Name or Last name:  ");
			fourthOne.add(inst);
		
		JPanel fifthOne = new JPanel();
		this.add(fifthOne);	
		
			instText = new JTextField (20);
			fifthOne.add(instText);
			
		JPanel sixthOne = new JPanel();
		this.add(sixthOne);		
			JButton findBill = new JButton ("Find Patient");
			sixthOne.add(findBill);
			findBill.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {	
					String searchName = instText.getText();
					
					//DBH db = new DBH();
					ResultSet rs = null;
					String sql = ("select Patients_Name, Patients_Surname, Patients_Age, Patients_Phone, user_name FROM Patients, system_users WHERE (referDoctor = idsystem_users) AND (Patients_Name = '"+searchName+"' OR Patients_Surname = '"+searchName+"')"); 
					
					
				try{
					  rs = db.executeCall(sql);
			       		
					  while(rs.next()){
						  
						 
						  //showBill ();
						  //System.out.println(sql);
						
						  	//System.out.println(Pat_id);
						  	Pat_Name = rs.getString("user_name");
						  	System.out.println ("Patient ID: " + Pat_Name);
							//String Pat_SurName = rs.getString("user_type");
							//int Pat_Age = rs.getInt("user_type");
							//String Pat_Address = rs.getString("user_type");
							//String Pat_ContactNumber = rs.getString("user_type");
							
					  }
						  	
					}	
					  catch (Exception ex) {}
					
		//Each button represents a different sql call to the database, but the DB handler is instantiated only once, globally. 
		//The searching calls work, however, I could not figure out the way to show the information on a separated pop-up screen, as desired.
		//They were tasted by printing some information on the console of Eclipse. 
						
			   
			}
			});
			
			JPanel eigthOne = new JPanel();
			this.add(eigthOne);	
			
				JButton findMessage = new JButton ("Find Message");
				eigthOne.add(findMessage);
				findMessage.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {	
						String searchName = instText.getText();
						
						//DBH db = new DBH();
						ResultSet rs = null;
						String sql = ("select Patients_Name, Patients_Surname, Patients_Age, Patients_Phone, user_name, MessageText, MessageStatus FROM Patients, system_users, Messages WHERE (MesPatId = idPatients) AND (MesDocId = idsystem_users) AND (Patients_Name = '"+searchName+"' OR Patients_Surname = '"+searchName+"')"); 
						
						
					try{
						  rs = db.executeCall(sql);
				       		
						  while(rs.next()){
							  
							 
							  //showBill ();
							  //System.out.println(sql);
							
							  	//System.out.println(Pat_id);
							  	Pat_Name = rs.getString("user_name");
							  	System.out.println ("Patient ID: " + Pat_Name);
								//String Pat_SurName = rs.getString("user_type");
								//int Pat_Age = rs.getInt("user_type");
								//String Pat_Address = rs.getString("user_type");
								//String Pat_ContactNumber = rs.getString("user_type");
								
						  }
							  	
						}	
						  catch (Exception ex) {}
						
					
							
				   
				}
				});
				
			JPanel nineteenthOne = new JPanel();
			this.add(nineteenthOne);		
				JButton findCard = new JButton ("Find Visit Card");
				nineteenthOne.add(findCard);
				findBill.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {	
						String searchName = instText.getText();
						
						//DBH db = new DBH();
						ResultSet rs = null;
						String sql = ("select VisitDate, VisitComments, VisitPres, PresType, Patients_Name, Patients_Surname, user_name,  FROM VisitRegister, Patients, system_users WHERE (idVisitRegister = idPatients) AND (VisitDocId = idsystem_users) AND (Patients_Name = '"+searchName+"' OR Patients_Surname = '"+searchName+"')"); 
						
						
					try{
						  rs = db.executeCall(sql);
				       		
						  while(rs.next()){
							  
							 
							  //showBill ();
							  //System.out.println(sql);
							
							  	//System.out.println(Pat_id);
							  	Pat_Name = rs.getString("user_name");
							  	System.out.println ("Patient ID: " + Pat_Name);
								//String Pat_SurName = rs.getString("user_type");
								//int Pat_Age = rs.getInt("user_type");
								//String Pat_Address = rs.getString("user_type");
								//String Pat_ContactNumber = rs.getString("user_type");
								
						  }
							  	
						}	
						  catch (Exception ex) {}
						
					
							
				   
				}
				});
				
			JPanel seventhOne = new JPanel();
			this.add(seventhOne);
			
				
				JButton createBill = new JButton ("Create new Visit Card");
				seventhOne.add(createBill);
				createBill.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
								new NewVisitCard ();
							}
				   
				});


			validate();
			repaint();
	
	
}


public static void main(String[] args) {
	new DoctorType();

}
		
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
	public void JTextPane() {
		
		setPreferredSize(new Dimension(450, 110));
		
		        textArea.setText("Pat_Name ");
		
			//}
		
		
		
		
		//return BillShown;
			
		//System.out.println ("Patient ID: " + Pat_id);
		//System.out.println ("Patient Name: " + Pat_Name);
	}

}

