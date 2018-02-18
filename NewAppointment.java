import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.SelectionKey;

import javax.swing.*;
//JButton;
//import javax.swing.JComboBox;
//import javax.swing.JFrame;
//import javax.swing.JOptionPane;
//import javax.swing.JTextField;

import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//This screen allows the secretary users to create a new appointment and registered it in the database. By doing this, a new object
//of "Appointment" type is also instantiated. 

public class NewAppointment extends JFrame implements ActionListener{
	
	
//	JComboBox Services = null;
	String[] PatService = { "First Consultation", "Blood Test", "Consultation & Blood Test", "Treatment Follow Up", "Regular Consultation"};
	JTextField AppDateField = null;
	JTextField AppTimeField = null;
	JTextField AppPatNameField = null;
	JTextField AppPatSurnameField = null;
	JTextField AppPatIdField = null;
	JTextField AppDocNameField = null;
	JComboBox SelectTask = null;
	
	public NewAppointment() {
			
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
			
				JLabel AppDate = new JLabel ("Date: ");
				secondOne.add(AppDate);
				
				AppDateField = new JTextField(20);
				secondOne.add(AppDateField);
			
			JPanel thirdOne = new JPanel();
			this.add(thirdOne);
			
				JLabel AppTime = new JLabel ("Time (Please use 24 hours format): ");
				thirdOne.add(AppTime);
		
				AppTimeField = new JTextField(20);
				thirdOne.add(AppTimeField);
		
		
			JPanel fourthOne = new JPanel();
			this.add(fourthOne);
			
				JLabel AppPatName = new JLabel ("Patient Name: ");
				fourthOne.add(AppPatName);
	
				AppPatNameField = new JTextField(20);
				fourthOne.add(AppPatNameField);
			
			JPanel fifththOne = new JPanel();
			this.add(fifththOne);
				
				JLabel AppPatSurname = new JLabel ("Patient Surname: ");
				fifththOne.add(AppPatSurname);
		
				AppPatSurnameField = new JTextField(20);
				fifththOne.add(AppPatSurnameField);
			
			JPanel sixththOne = new JPanel();
			this.add(sixththOne);
					
				JLabel AppPatId = new JLabel ("Patient Id: ");
				sixththOne.add(AppPatId);
			
				AppPatIdField = new JTextField(10);
				sixththOne.add(AppPatIdField);
				
			JPanel seventhOne = new JPanel();
			this.add(seventhOne);
						
				JLabel AppDocName = new JLabel ("Doctor Name: ");
				seventhOne.add(AppDocName);
				
				AppDocNameField = new JTextField(20);
				seventhOne.add(AppDocNameField);
				
			JPanel eigthOne = new JPanel();
			this.add(eigthOne);
							
				JLabel AppService = new JLabel ("Please select service: ");
				eigthOne.add(AppService);
				
				
				SelectTask = new JComboBox (PatService);	
				eigthOne.add(SelectTask);
				
				SelectTask.setSelectedIndex(4);
				SelectTask.addActionListener(SelectTask);
				
			
			JPanel ninthOne = new JPanel();
			this.add(ninthOne);
				
				JButton createApp = new JButton("Create Appointment");
				createApp.addActionListener(this);
				createApp.setActionCommand("createApp");
				ninthOne.add(createApp);
			
			JPanel twelvethOne = new JPanel ();
			this.add(twelvethOne);
					
					JButton goBack = new JButton ("Go Back");
					twelvethOne.add(goBack);
					goBack.addActionListener(new ActionListener() {
			           public void actionPerformed(ActionEvent e) {
			        	   new SecretaryScreen();
			        	   
			           }
				});
	
			validate();
			repaint();
		
		
	}


	

	public static void main(String[] args) {
		new NewAppointment();

	}
	
	//Information is sent and written on database and new object is instantiated:
	@Override
	public void actionPerformed(ActionEvent e) {
		String date = AppDateField.getText();
		String Time = AppTimeField.getText();	
		String Name = AppPatNameField.getText();
		String Surname = AppPatSurnameField.getText();
		int Id = Integer.parseInt(AppPatIdField.getText());
		String Doctor = AppDocNameField.getText();
		String Service = (String) SelectTask.getSelectedItem();
		
		DBH db = new DBH();
		
		String sql = "INSERT INTO  `Narnia_Hospital`.`Appointments` (`Appointment_Date`, `Appointment_Time`, `AppPat_Name`, `AppPat_Surname`, `AppPatId`, `AppDoctor`, `AppService`) VALUES ('"+date+"','"+Time+"','"+Name+"','"+Surname+"','"+Id+"','"+Doctor+"','"+Service+"')"; 
		
		
		ResultSet rs = null;
		
		try{
		  rs = db.executeCall(sql);
       		
		  while(rs.next()){
			  
			  Appointment A1 = new Appointment();
			  
			  A1.setAppDate (date);
			  A1.setAppTime(Time);
			  A1.setPatientName(Name);
			  A1.setPatientSurname(Surname);
			  A1.setPatId(Id);
			  A1.setDoctorName(Doctor);
			  A1.setServiceRequired(Service);
			  
			  
			  	
				 }
			  
		  
		 
		  
		}catch (Exception ex){}
		
		//Offers the option to create a new one or leave this screen.
		
		JOptionPane.showMessageDialog(this, "Appointment Registered!");
		
		 int n = JOptionPane.showConfirmDialog(this,"Do you want to add another appointment?", "Message Selected", JOptionPane.YES_NO_OPTION);
			
		 if (n == 0){ 
			 this.setVisible(false);
			 new NewAppointment();
			
		} else if (n == 1){
			 this.setVisible(false);
			 new SecretaryScreen();
		}
		
	}
}