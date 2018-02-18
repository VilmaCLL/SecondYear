
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.nio.channels.SelectionKey;

import javax.swing.*;

import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;



public class NewMessage extends JFrame implements ActionListener{
	
	//This screen allows the secretary users to create a new appointment and registered it in the database. By doing this, a new object
	//of "Message" type is also instantiated. 
	JTextField AppDateField = null;
	JTextField AppPatIdField = null;
	JTextArea MessageContent = null;
	JTextField AppDocNameField = null;
	String[] StatusOptions = {"Read", "Unread"};
	JComboBox StatusMessage = null;
	
	public NewMessage() {
			
			super ("Narnia Hospital");
			setSize(600,600);
			setVisible(true);
			this.setLayout(new GridLayout(10,1));
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
							
				JLabel MessageText = new JLabel ("Please write message: ");
				eigthOne.add(MessageText);
			
			JPanel tenthOne = new JPanel ();
			this.add(tenthOne);	
			
				MessageContent = new JTextArea(30,30);
				tenthOne.add(MessageContent);
		
			
			JPanel fourthOne = new JPanel();
			this.add(fourthOne);
			
				JLabel BillStatus = new JLabel ("Status: ");
				fourthOne.add(BillStatus);
		
				StatusMessage = new JComboBox(StatusOptions);
				fourthOne.add(StatusMessage);
	
				StatusMessage.setSelectedIndex(1);
				StatusMessage.addActionListener(StatusMessage);
				
			JPanel ninthOne = new JPanel();
			this.add(ninthOne);
					
					JButton createMes = new JButton("Save Message");
					createMes.addActionListener(this);
					createMes.setActionCommand("createMes");
					ninthOne.add(createMes);
			
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
		new NewMessage();

	}
	
	//Information is sent and written on database and new object is instantiated:
	@Override
	public void actionPerformed(ActionEvent e) {
		String date = AppDateField.getText();
		int Id = Integer.parseInt(AppPatIdField.getText());
		String Doctor = AppDocNameField.getText();
		String Message = MessageContent.getText();
		String Status = (String) StatusMessage.getSelectedItem();
		
		
		DBH db = new DBH();
		
		String sql = "INSERT INTO  `Narnia_Hospital`.`Messages` (`Message_Date`, `MesPatId`, `MessageText`, `MesDocId`, `MessageStatus`) VALUES ('"+date+"','"+Id+"','"+Message+"','"+Doctor+"', '"+Status+"')"; 
	
		
		
		ResultSet rs = null;
		
		try{
		  rs = db.executeCall(sql);
       		
		  while(rs.next()){
			  
			  Messages M1 = new Messages();
			  
			  M1.setDate(date); 
			  M1.setPatId(Id);
			  M1.setDoctorRefer(Id);
			  M1.setMessageContent(Message);
			  M1.setStatusMes(Status);
		
			  
			  
			  	
				 }
			  
		  
		 
		  
		}catch (Exception ex){}
		
		//Offers the option to create a new one or leave this screen.
		JOptionPane.showMessageDialog(this, "Message Saved!");
		
		 int n = JOptionPane.showConfirmDialog(this,"Do you want to add another message?", "Message Selected", JOptionPane.YES_NO_OPTION);
			
		 if (n == 0){ 
			 this.setVisible(false);
			 new NewMessage();
			
		} else if (n == 1){
			 this.setVisible(false);
			 new SecretaryScreen();
		}
		
	}
}