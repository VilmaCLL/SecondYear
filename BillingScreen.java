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

//This is the page the users from Billing are redirected to after login in. On this screen, the billing user 
//is offered to see all pending bills, search for any bill (paid or unpaid) or create a new bill. After taking an option
//the user is redirected to a different screen, depending on the choice.

public class BillingScreen extends JFrame implements ActionListener{
	

    JScrollBar tableBar = null;
    JScrollPane jScrollPane1 = null;
    JTextArea textArea1 = null;
    JTextField instText = null;
    String date = null;
    double totalAmmount = 0;
    String Pat_Name = null;
	//String Pat_SurName = null;
	//String DocName = null;
	//String services = null;
	//String statusBill = null;

	private AbstractButton textArea;
    
	public BillingScreen (){
		
		super ("Narnia Hospital");
		setSize(400,400);
		setVisible(true);
		this.setLayout(new GridLayout(8,1));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		
		JPanel panel1 = new JPanel();
		this.add(panel1);
	
			JLabel Greeting = new JLabel("Welcome " + LogginPage.RightName); //This variable comes from the login page to 
																			//show the user name on the greeting label.
			panel1.add(Greeting);
		
		JPanel secondOne = new JPanel();
		this.add(secondOne);
		
			
			JButton seeBills = new JButton ("See Bills");
			secondOne.add(seeBills);
			seeBills.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
							new AdminFrame ();
						}
			   
			});
			
			
		JPanel thirdOne = new JPanel();
		this.add(thirdOne);
		
			JLabel searchBill = new JLabel ("Search bill:");
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
			JButton findBill = new JButton ("Find Bill");
			sixthOne.add(findBill);
			findBill.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {	
					String searchName = instText.getText();
					
					DBH db = new DBH();//connecting to the DBHandler to search for specific bills. This connection is only 
					ResultSet rs = null; //associated to this JButton.
					String sql = ("select Bills_date, BillAmmount, BillService, BillStatus, Patients_Name, Patients_Surname, user_name FROM Bills, Patients, system_users WHERE (BillPatId = idPatients) AND (BillDoctor = idsystem_users) AND (Patients_Name = '"+searchName+"' OR Patients_Surname = '"+searchName+"')"); 
					//Specific call to DB for this screen needs. 
					
				try{
					  rs = db.executeCall(sql);
			       		
					  while(rs.next()){
						  
						 //The idea was to show the found bill information on a pop-up screen, however, I could not find the right
						  //component to do it. The call works well though, as I could try it by printing some information
						  //on the console in Eclipse.
						  
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
			
				
				JButton createBill = new JButton ("Create new Bill");
				seventhOne.add(createBill);
				createBill.addActionListener(new ActionListener() {
					public void actionPerformed(ActionEvent arg0) {
								new CreatingBills ();
							}
				   
				});


			validate();
			repaint();
	
	
}


public static void main(String[] args) {
	new BillingScreen();

}
		
	
	
	@Override
	public void actionPerformed(ActionEvent e) {
		
		
	}
	
	public void JTextPane() {
		
		setPreferredSize(new Dimension(450, 110));
		
		        textArea.setText("Pat_Name ");
		
			//}
		
		
		
	//public showBill(){ // this was one of the different methods I tried to create to show the found bill.
		        //Do something
		//return BillShown;
			
		//System.out.println ("Patient ID: " + Pat_id);
		//System.out.println ("Patient Name: " + Pat_Name);
	//}
		        
	}

}

	  