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


//This screen allows billing users to create a new bill and register it in the Database
public class CreatingBills extends JFrame implements ActionListener{
	
	

	String[] PatService = { "First Consultation", "Blood Test", "Consultation & Blood Test", "Treatment Follow Up", "Regular Consultation"};
	String[] StatusOptions = {"Paid", "Unpaid"};
	JTextField AppDateField = null;
	JTextField AppPatNameField = null;
	JTextField AppPatSurnameField = null;
	JTextField AppPatIdField = null;
	JTextField AppDocNameField = null;
	JTextField TotalBillField = null;
	JComboBox SelectTask = null;
	JComboBox StatusBill = null;
	
	public CreatingBills() {
			
			super ("Narnia Hospital");
			setSize(600,600);
			setVisible(true);
			this.setLayout(new GridLayout(12,1));
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			JPanel firstOneSec = new JPanel();
			this.add(firstOneSec);
		
				JLabel GreetingSec = new JLabel("Hello " + LogginPage.RightName + ". " + "Please fill in the following information:");
				firstOneSec.add(GreetingSec);
			
			JPanel secondOne = new JPanel();
			this.add(secondOne);
			
				JLabel AppDate = new JLabel ("Date: ");
				secondOne.add(AppDate);
				
				AppDateField = new JTextField(20);
				secondOne.add(AppDateField);
			
			JPanel sixththOne = new JPanel();
			this.add(sixththOne);
					
				JLabel AppPatId = new JLabel ("Patient Id: ");
				sixththOne.add(AppPatId);
			
				AppPatIdField = new JTextField(10);
				sixththOne.add(AppPatIdField);
				
			JPanel seventhOne = new JPanel();
			this.add(seventhOne);
						
				JLabel AppDocName = new JLabel ("Doctor Id: ");
				seventhOne.add(AppDocName);
				
				AppDocNameField = new JTextField(20);
				seventhOne.add(AppDocNameField);
				
			JPanel eigthOne = new JPanel();
			this.add(eigthOne);
							
				JLabel AppService = new JLabel ("Please select service: ");
				eigthOne.add(AppService);
				
				//Services are chosen through combo box, so they are already pre-determined.
				SelectTask = new JComboBox (PatService);	
				eigthOne.add(SelectTask);
				
				SelectTask.setSelectedIndex(4);
				SelectTask.addActionListener(SelectTask);
				
			
			JPanel ninthOne = new JPanel();
			this.add(ninthOne);
				
				JLabel BillTotal = new JLabel ("Total Bill: ");
				ninthOne.add(BillTotal);
			
				TotalBillField = new JTextField(20);
				ninthOne.add(TotalBillField);
				
			JPanel tenthOne = new JPanel();
			this.add(tenthOne);
					
				JLabel BillStatus = new JLabel ("Status: ");
				tenthOne.add(BillStatus);
			
				StatusBill = new JComboBox(StatusOptions);
				tenthOne.add(StatusBill);
		
				StatusBill.setSelectedIndex(1);
				StatusBill.addActionListener(StatusBill);
				
			JPanel eleventhOne = new JPanel();
			this.add(eleventhOne);
			
				JButton createBill = new JButton("Register Bill");
				createBill.addActionListener(this);
				createBill.setActionCommand("createBill");
				eleventhOne.add(createBill);
				
			JPanel twelvethOne = new JPanel ();
			this.add(twelvethOne);
				
				JButton goBack = new JButton ("Go Back");
				twelvethOne.add(goBack);
				goBack.addActionListener(new ActionListener() {
		           public void actionPerformed(ActionEvent e) {
		        	   new BillingScreen();
		        	   
		           }
			});
				
	
			validate();
			repaint();
		
		
	}


	

	public static void main(String[] args) {
		new CreatingBills();

	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String date = AppDateField.getText();	
		int Id = Integer.parseInt(AppPatIdField.getText());
		int DoctorId = Integer.parseInt(AppDocNameField.getText()); 
		String Service = (String) SelectTask.getSelectedItem();
		double billAmmount = Double.parseDouble(AppPatIdField.getText());
		String Status = (String) StatusBill.getSelectedItem();
		
		DBH db = new DBH();
		
		String sql = "INSERT INTO  `Narnia_Hospital`.`Bills` (`Bills_date`, `BillPatId`, `BillDoctor`, `BillService`, `BillAmmount`, `BillStatus`) VALUES ('"+date+"','"+Id+"','"+DoctorId+"','"+Service+"', '"+billAmmount+"', '"+Status+"')"; 
		
		//The new bill is registered in the database as we are also creating a new object "Bill".
		
		ResultSet rs = null;
		
		try{
		  rs = db.executeCall(sql);
       		
		  while(rs.next()){
			  
			  JOptionPane optionPane = new JOptionPane(
					    "Would you like to register another bill?",
					    JOptionPane.QUESTION_MESSAGE,
					    JOptionPane.YES_NO_OPTION);
				
				int value = ((Integer)optionPane.getValue()).intValue();
				if (value == JOptionPane.YES_OPTION){
					this.setVisible(false);
					new CreatingBills();
					
				}else if (value == JOptionPane.NO_OPTION){
					this.setVisible(false);
					new BillingScreen();
					
				}
			  Bill B1 = new Bill();
			  
			  B1.setVisitDate(date);
			  B1.setBillIdPat(Id);
			  B1.setDoctorId(DoctorId);
			  B1.setServicios(Service);
			  B1.setTotalVisit(billAmmount);
			  B1.setBillStatus(Status);
			  
			  	
				 }
			  
  	 
		 
		  
		}catch (Exception ex){}
		// Gives the option to the user to create a new bill or go back to the billing screen.
		JOptionPane.showMessageDialog(this, "Bill Created!");
		
		 int n = JOptionPane.showConfirmDialog(this,"Do you want to create another bill?", "Message Selected", JOptionPane.YES_NO_OPTION);
			
		 if (n == 0){ 
			 this.setVisible(false);
			 new CreatingBills();
			
		} else if (n == 1){
			 this.setVisible(false);
			 new BillingScreen();
		}
	}
}