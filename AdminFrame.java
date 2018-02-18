
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;
//This screen shows a table with the current unpaid bills, offering the option to the user to mark any bill as paid
//which will make it disappear from the table; or delete a bill, which will delete the record permanently from the database.
//The user can also go back to the billing screen to choose a different option.

public class AdminFrame extends JFrame implements ActionListener {

	JPanel top = new JPanel();
	JPanel bottom = new JPanel();
	JPanel left = new JPanel();
	JPanel right = new JPanel();
	String selectingRow = null;
	DBH db = new DBH(); //Here, the DB Handler is instantiated globally, because it will be used several times, using
						//different sql calls along the screen.
	
	public AdminFrame(){
		
		top.add(new JLabel("Full history of unpaid bills:"));
		
		JButton MarkedPaid = new JButton("Mark as paid");
		bottom.add(MarkedPaid);
		MarkedPaid.addActionListener(this);
		MarkedPaid.setActionCommand("MarkedPaid");
		
		
		JButton DeleteBill = new JButton("Delete Bill");
		bottom.add(DeleteBill);
		DeleteBill.addActionListener(this);
		DeleteBill.setActionCommand("DeleteBill");
		
		JButton goBack = new JButton ("Go Back");
		bottom.add(goBack);
		goBack.addActionListener(this);
		goBack.setActionCommand("goBack");
		
	     setSize(500,500);
	     setVisible(true);
	 	 this.setLayout(new BorderLayout());
	 	 setDefaultCloseOperation(EXIT_ON_CLOSE);
	 	
			
	 	 
    	    Object[][] data = new Object[100][9];
    	    ResultSet rs = null;
    	    //First sql call, to populate the JTable:
    	    	int rowCounter = 0;
	    			try{
	    			  rs = db.executeCall("SELECT * From Bills, Patients WHERE BillStatus = 'Unpaid' AND idPatients = BillPatId");

	    	    
	    	    while(rs.next()){
	    	    	
	    	    	
	    	    	int id = rs.getInt("idBills");
	    	    	
	    	    	data[rowCounter][0] = id;
	 
	    	        String DateBill = rs.getString("Bills_Date");
	    	    	data[rowCounter][1] = DateBill;
	    	    	
	    	    	String billNamePat = rs.getString("Patients_Name");
	    	    	data[rowCounter][2] = billNamePat;
	    	    	
	    	    	String billSurnamePat = rs.getString("Patients_Surname");
	    	    	data[rowCounter][3] = billSurnamePat;
	    	    	
	    	    	int PatientBill = rs.getInt("BillPatId");    	    
	    	    	data[rowCounter][4] = PatientBill;
	    	    	
	    	    	String billDoctor = rs.getString("BillDoctor");
	    	    	data[rowCounter][5] = billDoctor;
	    	    	
	    	    	String BillServices = rs.getString("BillService");
	    	    	data[rowCounter][6] = BillServices;
	    	    	
	    	    	double Ammount = rs.getDouble("BillAmmount");
	    	    	data[rowCounter][7] = Ammount;
	    	    	
	    	    	String BillStatus = rs.getString("BillStatus");
	    	    	data[rowCounter][8] = BillStatus;
	    	  	
	    	    	
	    	         rowCounter++;    
	    	        
	        	    
	    	        
	    	    } 	}catch (Exception ex){}
	    
	    	
	    	
	    	
	    	String[] columnNames = {"id",
	                "Date",
	                "Patient Name",
	                "Patient Surname",
	                "Patient Id",
	                "Doctor",
	                "Service",
	                "Ammount",
	                "Status"};
	    	
	    	JTable table = new JTable(data, columnNames);
	    	
	    	JScrollPane js=new JScrollPane(table);
	    	left.add(js);
	    	
	    	//Adding a row listener to choose the record that will be updated or erased:
	    	table.getSelectionModel().addListSelectionListener(new ListSelectionListener() {
	    	
	    @Override
	    	public void valueChanged(ListSelectionEvent event) {
	    	
	    	selectingRow= table.getValueAt(table.getSelectedRow(), 0).toString();
   	        	
 	         }
   	         
		 });
	    	
	  
	         
	         this.add(top, BorderLayout.NORTH);
	         
	         this.add(bottom, BorderLayout.SOUTH);
	         
	         this.add(left, BorderLayout.WEST);
	         this.add(right, BorderLayout.EAST);
	      
	         
	     validate();
	     repaint();
	     
	    } 


    
	public static void main(String[] args) {
		new AdminFrame ();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		String command = e.getActionCommand();
		
		//Second sql call, to update the record on the Database:
		
        if (command.equals("MarkedPaid")) {
        	String sql = ("UPDATE Narnia_Hospital.Bills SET BillStatus='Paid' WHERE  idBills='"+selectingRow+"'"); 
    		ResultSet rs = null;
    			db.executeCall(sql);  
    			this.setVisible(false);
    			new AdminFrame();
        	
    	//Third sql call, to delete the record on the Database:
		}else if (command.equals("DeleteBill")){
			
			String sql = ("DELETE FROM Narnia_Hospital.Bills WHERE idBills='"+selectingRow+"'"); 
    		ResultSet rs = null;
    			db.executeCall(sql);  
    			this.setVisible(false);
    			new AdminFrame();
    			
		}else if (command.equals("goBack")){
			new BillingScreen ();
		}
        
        
        
	
	}
	
	
		
		
		
	}
    		
    	
	   
	   
		


	
	

