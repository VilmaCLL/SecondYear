import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

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


//This screen is the first secretary user gets to, and shows the different tasks this user can choose. 
//Each task selected will send the user to a different screen.Tasks appear in combo box to be selected.
public class SecretaryScreen extends JFrame implements ActionListener{
	
	
	JComboBox SecretaryTask = null;
	String[] userTask = { "Take New Message", "Make New Appointment", "Edit/Cancel Appointment", "Create New Patient"};
	JComboBox SelectTask = new JComboBox (userTask);
		
	public SecretaryScreen() {
			
			super ("Narnia Hospital");
			setSize(300,300);
			setVisible(true);
			this.setLayout(new GridLayout(4,1));
			setDefaultCloseOperation(EXIT_ON_CLOSE);
			
			JPanel firstOneSec = new JPanel();
			this.add(firstOneSec);
		
			JLabel GreetingSec = new JLabel("Welcome " + LogginPage.RightName);
			firstOneSec.add(GreetingSec);
			
			JPanel secondOneSec = new JPanel();
			this.add(secondOneSec);
			
			JLabel selecting = new JLabel ("Please select your task");
			secondOneSec.add(selecting);
			
			JPanel thirdOneSec = new JPanel();
			this.add(thirdOneSec);
			
			SelectTask.setSelectedIndex(3);
			SelectTask.addActionListener(SelectTask);
			thirdOneSec.add(SelectTask);
			
			JPanel fourthOneSec = new JPanel();
			this.add(fourthOneSec);
			
			JButton Go = new JButton("GO!");
			Go.addActionListener(this);
			Go.setActionCommand("login");
			fourthOneSec.add(Go);
			
			validate();
			repaint();
	}

		public static void main(String[] args) {
			new SecretaryScreen();

		}
	@Override
	public void actionPerformed(ActionEvent e) {
		
		Object selecting =SelectTask.getSelectedItem();//getting string from Combo Box
		String selectedTask = selecting.toString();
		
        if (selectedTask.equals("Take New Message")){
        	new LogginPage(); 
        	}
        else if (selectedTask.equals("Make New Appointment")){
        	new NewAppointment(); 
    	}
        else if (selectedTask.equals("Edit/Cancel Appointment")){
        	new LogginPage(); 
    	}
        else if (selectedTask.equals("Create New Patient")){
        	new LogginPage(); 
    	}


}
}
	

