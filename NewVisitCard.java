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



public class NewVisitCard extends JFrame implements ActionListener{
	//This screen allows the secretary users to create a new appointment and registered it in the database. By doing this, a new object
	//of "VisitCard" type is also instantiated. 

	JTextField AppDateField = null;
	JTextField AppPatIdField = null;
	JTextArea CommentContent = null;
	JTextField AppDocNameField = null;
	JTextArea PressContent = null;
	String[] PresOptions = {"A", "B", "C", "NA"};
	JComboBox PresTypes = null;
	
	public NewVisitCard() {
			
			super ("Narnia Hospital");
			setSize(600,600);
			setVisible(true);
			this.setLayout(new GridLayout(14,1));
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
								
					JLabel MessageText = new JLabel ("Please write your comments: ");
					eigthOne.add(MessageText);
				
				JPanel tenthOne = new JPanel ();
				this.add(tenthOne);	
				
					CommentContent = new JTextArea(30,30);
					tenthOne.add(CommentContent);
					
				JPanel eleventhOne = new JPanel();
				this.add(eleventhOne);
									
						JLabel PresText = new JLabel ("Please write your prescription: ");
						eleventhOne.add(PresText);
					
					JPanel twelvethOne = new JPanel ();
					this.add(twelvethOne);	
					
						PressContent = new JTextArea(30,30);
						twelvethOne.add(PressContent);
						
					JPanel fourthOne = new JPanel();
					this.add(fourthOne);
					
						JLabel presType = new JLabel ("Prescription type: ");
						fourthOne.add(presType);
				
						PresTypes = new JComboBox(PresOptions);
						fourthOne.add(PresTypes);
			
						PresTypes.setSelectedIndex(1);
						PresTypes.addActionListener(PresTypes);
						
					JPanel ninthOne = new JPanel();
					this.add(ninthOne);
							
							JButton createMes = new JButton("Save Visit Card");
							createMes.addActionListener(this);
							createMes.setActionCommand("createMes");
							ninthOne.add(createMes);
					
					JPanel fifteenthOne = new JPanel ();
					this.add(fifteenthOne);
							
							JButton goBack = new JButton ("Go Back");
							fifteenthOne.add(goBack);
							goBack.addActionListener(new ActionListener() {
					           public void actionPerformed(ActionEvent e) {
					        	   new DoctorType();
					        	   
					           }
						});
			
					validate();
					repaint();
				
				
			}

	public static void main(String[] args) {
		new NewVisitCard ();

		//Information is sent and written on database and new object is instantiated:
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		String date = AppDateField.getText();
		int Id = Integer.parseInt(AppPatIdField.getText());
		int Doctor = Integer.parseInt(AppDocNameField.getText());
		String Message = CommentContent.getText();
		String Prescription = PressContent.getText();
		String TypePres = (String) PresTypes.getSelectedItem();
		
	
		DBH db = new DBH();
		
		String sql = "INSERT INTO  `Narnia_Hospital`.`VisitRegister` (`VisitDate`, `VisitPatId`, `VisitDocId`, `VisitComments`, `VisitPres`,`PresType`) VALUES ('"+date+"','"+Id+"', '"+Doctor+"','"+Message+"', '"+Prescription+"','"+TypePres+"')"; 
	
		
		
		ResultSet rs = null;
		
		try{
		  rs = db.executeCall(sql);
       		
		  while(rs.next()){
			  
			  visitCard V1 = new visitCard();
			  
			  V1.setVisitDate(date);
			  V1.setDocPatientId(Id);
			  V1.setDocId(Doctor);
			  V1.setVisitComments(Message);
			  V1.setMedPresc(Prescription);
			  V1.setPrescType(TypePres);
		
		  }
		  
		  }catch (Exception ex){}
		  
		//Offers the option to create a new one or leave this screen.
			
			JOptionPane.showMessageDialog(this, "Card Saved!");
			
			 int n = JOptionPane.showConfirmDialog(this,"Do you want to add another visit card?", "Message Selected", JOptionPane.YES_NO_OPTION);
				
			 if (n == 0){ 
				 this.setVisible(false);
				 new NewVisitCard();
				
			} else if (n == 1){
				 this.setVisible(false);
				 new DoctorType();
			}
			
		

			  	
 }
					
	}				
					
					
					
					
					
				