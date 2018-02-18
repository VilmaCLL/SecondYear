import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;
import java.sql.ResultSet;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


// Login page. Here, the user introduces username and password to get into the system and redirected to the proper page, 
//depending on the type of user: Doctor, Billing or Secretary. 

public class LogginPage extends JFrame implements ActionListener{
	
	JTextField usernameField = null;
	JTextField passwordField = null;
	public static String RightName; //to get user's name and pass it to the other screens.

	
	public LogginPage() {
	
		//Building the frame with components:
		
		super ("Narnia Hospital");
		setSize(500,400);
		setVisible(true);
		this.setLayout(new GridLayout(4,1));
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
			JPanel firstOne = new JPanel();
			this.add(firstOne);
		
				JLabel Greeting = new JLabel("Welcome to Narnia´s Hospital Internal System");
				firstOne.add(Greeting);
			
			JPanel secondOne = new JPanel();
			this.add(secondOne);
			
				JLabel UserName = new JLabel ("Username: ");
				secondOne.add(UserName);
				
				usernameField = new JTextField(20);
				secondOne.add(usernameField);
			
			JPanel thirdOne = new JPanel();
			this.add(thirdOne);
			
				JLabel PassWord = new JLabel ("Password: ");
				thirdOne.add(PassWord);
		
				passwordField = new JTextField(20);
				thirdOne.add(passwordField);
		
		
			JPanel fourthOne = new JPanel();
			this.add(fourthOne);
			
				JButton login = new JButton("login");
				login.addActionListener(this);
				login.setActionCommand("login");
				fourthOne.add(login);
				
				
				validate();
				repaint();
		
		
	}

	public static void main(String[] args) {
		new LogginPage();

	}

	@Override
	public void actionPerformed(ActionEvent e) {
		
		//Using the Database Handler to connect: 
		
		String un = usernameField.getText();
		String pw = passwordField.getText();		
		DBH db = new DBH(); //Instantiating the DB Handler.
		
		//Query according to this page needs:
		
		String sql = ("select * from system_users where user_userName = '"+un+"' and user_Password = '"+pw+"'"); 
		ResultSet rs = null;
		
		try{
		  rs = db.executeCall(sql);
       		
		  while(rs.next()){
			  
  	    	//JOptionPane.showMessageDialog(this, "Logged in!");
  	    	
  	    	RightName = rs.getString("user_name"); //Here the name of the user is got and kept to be passed to the other screens.
  	 
  	        String type = rs.getString("user_type");
  	       
  	        if(type.equals("doctor")){
  	        	this.setVisible(false);
  	        	new DoctorType();
  	        }
  	        else if (type.equals("receptionist")){
  	        	this.setVisible(false);
  	        	new SecretaryScreen();
  	        }
  	        else if (type.equals("billing")){
	        	this.setVisible(false);
	        	new BillingScreen();
  	      }
  	    } 
		  
		  
		}catch (Exception ex){}
		
		
		
	}

}
