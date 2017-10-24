import java.util.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.io.*;

public class EmployeeRoster{

	private Employee list[];
	private int ce;
	private int pe;
	private int he;
	private int all;
	private int size;

	//frame
	private JFrame main;

	//panel
	private JPanel top;
	private JPanel center;
	private JPanel bottom;

	//labels
	private JLabel header;
	private JLabel displayer;
	private JLabel status;
	private JLabel lblname;
	private JLabel lbladdress;
	private JLabel lblage;
	private JLabel lblcompany;
	private JLabel lblgender;
	private JLabel lblearnings;

	//label for Commission Employee
	private JLabel lblsalary;
	private JLabel lblcommission;
	private JLabel lblitemSold;

	//label for PieceWorker
	private JLabel lblnumItems;
	private JLabel lblwage;

	//label for Hourly Employee
	private JLabel lblhoursWorked;
	private JLabel lblrate;

	//menu label
	private JLabel madd;
	private JLabel mremove;
	private JLabel mdisplay;
	private JLabel mdisplayCE;
	private JLabel mdisplayHE;
	private JLabel mdisplayPE;
	private JLabel mpayroll;

	//generic TextFields
	private JTextField txtname;
	private JTextField txtaddress;
	private JTextField txtage;
	private JTextField txtgender;
	private JTextField txtcompany;

	//textarea
	private JTextArea txtsample;

	//JOptionPane
	private JOptionPane pane;


	//textfield for Commission Employee
	private JTextField txtsalary;
	private JTextField txtcommission;
	private JTextField txtitemSold;

	//textfield for Piece Worker
	private JTextField txtnumItems;
	private JTextField txtwage;

	//textfield for Hourly Employee
	private JTextField txthoursWorked;
	private JTextField txtrate;

	//generic combo box
	private JComboBox choice;

	//Buttons
	private JButton btnadd;
	private JButton btncadd;
	private JButton btnpadd;
	private JButton btnhadd;
	private JButton btnremove;
	private JButton btndisplay;
	private JButton btndisplayCE;
	private JButton btndisplayHE;
	private JButton btndisplayPE;
	private JButton btnpayroll;
	private JButton btnexport;
	private JButton btnexit;

	//required functions
	public void add(Employee e){
		if(e instanceof CommissionEmployee){
			ce++;
		}
		if(e instanceof PieceWorker){
		    pe++;
	     }
		if(e instanceof HourlyEmployee){
			he++;
		}
		this.list[this.all++] = e;
	 }
	 public void remove(Employee e){
	 	if(e instanceof CommissionEmployee){
			ce--;
		}
		else if(e instanceof PieceWorker){
		    	pe--;
		}
		else if(e instanceof HourlyEmployee){
			he--;
		}
		all--;
	 }
	 public Employee search(int index){
	 	return list[index-1];
	 }
	 public int count(){
	     return all;
	 }
	 public int countCE(){
	 	return ce;
	 }
	 public int countPE(){
	     return pe;
	 }
	 public int countHE(){
	     return he;
	 }
	 public void display(){
	 	System.out.println("Names of Employees: ");
	     	for(int i=0; i<all; i++){
	     			System.out.println("[" +i+ "] "+ list[i].getName());
	     	}
	 }
	 public void displayCE(){
	 	System.out.println("Commission Employees: ");
	 	for(int i=0; i<all; i++){
		    	if(list[i] instanceof CommissionEmployee){
				System.out.println("[" +i+ "] "+list[i].toString());
		    	}
		}
	 }
	public void displayPE(){
		System.out.println("Piece Workers: ");
	    	for(int i=0; i<all; i++){
			if(list[i] instanceof PieceWorker){
				System.out.println("[" +i+ "] "+list[i].toString());
	     		}
	    	}
	}
	public void displayHE(){
		System.out.println("Hourly Employees");
		for(int i=0; i<all; i++){
			if(list[i] instanceof HourlyEmployee){
				System.out.println("[" +i+ "] " +list[i].toString());
			}
		}
	}
	public void payroll(){
		System.out.println("Payroll:");
		for(int i=0; i<all; i++){
			System.out.println("[" +i+ "]:\t" +list[i].getName()+ "\tEarnings:\t" +list[i].earnings());
		}
	}

	//start

	public EmployeeRoster(int size){

		this.list = new Employee[size];
		this.size = 0;
		this.ce = 0;
		this.pe = 0;
		this.he = 0;
		this.all = 0;

		//frame
		main = new JFrame();
		main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Already there
		main.setExtendedState(JFrame.MAXIMIZED_BOTH);
		main.setUndecorated(true);

		//panel
		top = new JPanel();
		center = new JPanel();
		bottom =  new JPanel();

		//construct
		top.setLayout(new GridLayout(1,1));
		top.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
		center.setLayout(new GridLayout(7,1,5,5));
		center.setBorder(BorderFactory.createEmptyBorder(5,10,0,10));
		bottom.setLayout(new GridLayout(1,1));
		bottom.setBorder(BorderFactory.createEmptyBorder(0,5,20,5));

		header = new JLabel("<html><h1>EMPLOYEE DATABASE</h1></html>", SwingConstants.CENTER);
		displayer = new JLabel();
		btncadd = new JButton("<html><h3>ADD CE</h3></html>");
		btncadd.addActionListener(new addCE());
		btnpadd = new JButton("<html><h3>ADD PE</h3></html>");
		btnpadd.addActionListener(new addPE());
		btnhadd = new JButton("<html><h3>ADD HE</h3></html>");
		btnhadd.addActionListener(new addHE());
		btnremove = new JButton("<html><h3>REMOVE</h3></html>");
		btnremove.addActionListener(new removeEmployee());
		btndisplay = new JButton("<html><h3>DISPLAY ALL</h3></html>");
		btndisplay.addActionListener(new displayAll());
		btndisplayCE = new JButton("<html><h4>COMMISSION WORKER</h4></html>");
		btndisplayCE.addActionListener(new displayCE());
		btndisplayHE = new JButton("<html><h3>HOURLY EMPLOYEE</h3></html>");
		btndisplayHE.addActionListener(new displayHE());
		btndisplayPE = new JButton("<html><h3>PIECE WORKER</h3></html>");
		btndisplayPE.addActionListener(new displayPE());
		btnpayroll = new JButton("<html><h3>DISPLAY PAYROLL</h3></html>");
		btnpayroll.addActionListener(new payroll());
		btnexit = new JButton("<html><h3>EXIT</h3></html>");

		btnexit.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent ae){
				main.setVisible(false);
				System.out.println("\n\n\n");
				System.exit(0);
			}
		});

		//include in panel
		top.add(header);
		center.add(btncadd);
		center.add(btnpadd);
		center.add(btnhadd);
		center.add(btnremove);
		center.add(btndisplay);
		center.add(btndisplayCE);
		center.add(btndisplayHE);
		center.add(btndisplayPE);
		center.add(btnpayroll);
		center.add(btnexit);

		main.add(center, BorderLayout.CENTER);
		main.add(top, BorderLayout.NORTH);
		main.add(bottom, BorderLayout.SOUTH);
		main.pack();
		main.setSize(400, 600);
		main.setLocationRelativeTo(null);
		main.setVisible(true);
	}


	class addHE implements ActionListener{
		public void actionPerformed(ActionEvent ae){

			//frame
			main = new JFrame();
			main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Already there
			main.setExtendedState(JFrame.MAXIMIZED_BOTH);
			main.setUndecorated(true);

			//panel
			top = new JPanel();
			center = new JPanel();
			bottom = new JPanel();

			//construct
			top.setLayout(new GridLayout(1,1));
			center.setLayout(new GridLayout(7,2,-118,10));
			top.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
			center.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
			bottom.setBorder(BorderFactory.createEmptyBorder(20,5,10,5));
			bottom.setLayout(new GridLayout(1,2,5,5));
			header = new JLabel("<html><h1>HOURLY EMPLOYEE</h1></html>", SwingConstants.CENTER);
			txtname = new JTextField();
			txtaddress = new JTextField();
			txtage = new JTextField();
			txtcompany = new JTextField();
			txtgender = new JTextField();
			txthoursWorked = new JTextField();
			txtrate = new JTextField();
			lblname = new JLabel("<html><h3>NAME:</h3></html>");
			lbladdress  = new JLabel("<html><h3>ADDRESS:</h3></html>");
			lblage  = new JLabel("<html><h3>AGE:</h3></html>");
			lblcompany  = new JLabel("<html><h3>COMPANY:</h3></html>");
			lblgender = new JLabel("<html><h3>GENDER:</h3></html");
			lblhoursWorked = new JLabel("<html><h3>HOURS WORKED:</h3></html>");
			lblrate = new JLabel("<html><h3>RATE:</h3></html>");
			btnadd  = new JButton("<html><h3>ADD</h3></html>");
			btnexit  = new JButton("<html><h3>BACK</h3></html>");

			btnexit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					main.setVisible(false);
				}
			});

			//include in panel
			top.add(header);
			center.add(lblname);
			center.add(txtname);
			center.add(lbladdress);
			center.add(txtaddress);
			center.add(lblage);
			center.add(txtage);
			center.add(lblcompany);
			center.add(txtcompany);
			center.add(lblgender);
			center.add(txtgender);
			center.add(lblhoursWorked);
			center.add(txthoursWorked);
			center.add(lblrate);
			center.add(txtrate);
			bottom.add(btnadd);
			bottom.add(btnexit);

			btnadd.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					try {
					String name = null,company = null,gender = null,address = null;
					int age = 0,hoursWorked = 0;
					double rate = 0.0;

					name = txtname.getText();
					age = Integer.parseInt(txtage.getText());
					company = txtcompany.getText();
					gender = txtgender.getText();
					address =txtaddress.getText();
					rate = Double.parseDouble(txtrate.getText());
					hoursWorked = Integer.parseInt(txthoursWorked.getText());

					HourlyEmployee ce = new HourlyEmployee(name,address,age,gender,company,hoursWorked,rate);
					System.out.println("\n"+ce);
					add(ce);
					pane.showMessageDialog(null,"Successfully Added!");
					txtname.setText("");
					txtage.setText("");
					txtcompany.setText("");
					txtgender.setText("");
					txtaddress.setText("");
					txtrate.setText("");
					txthoursWorked.setText("");
					} catch (Exception ex) {
						System.out.println("\nError Detected. Input Again");
						pane.showMessageDialog(null,"Error Detected. Input Again");
						txtname.setText("");
						txtage.setText("");
						txtcompany.setText("");
						txtgender.setText("");
						txtaddress.setText("");
						txtrate.setText("");
						txthoursWorked.setText("");
						}
				}
			});

			//set
			main.add(center, BorderLayout.CENTER);
			main.add(top, BorderLayout.NORTH);
			main.add(bottom, BorderLayout.SOUTH);
			main.pack();
			main.setSize(400, 600);
			main.setLocationRelativeTo(null);
			main.setVisible(true);
		}
	}

	class addCE implements ActionListener{
		public void actionPerformed(ActionEvent ae){

			//frame
			main = new JFrame();
			main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Already there
			main.setExtendedState(JFrame.MAXIMIZED_BOTH);
			main.setUndecorated(true);

			//panel
			top = new JPanel();
			center = new JPanel();
			bottom = new JPanel();

			//construct
			top.setLayout(new GridLayout(1,1));
			center.setLayout(new GridLayout(8,2,-118,10));
			top.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
			center.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
			bottom.setBorder(BorderFactory.createEmptyBorder(20,5,10,5));
			bottom.setLayout(new GridLayout(1,2,5,5));
			header = new JLabel("<html><h1>COMMISSION EMPLOYEE</h1></html>", SwingConstants.CENTER);
			txtname = new JTextField();
			txtaddress = new JTextField();
			txtage = new JTextField();
			txtcompany = new JTextField();
			txtgender = new JTextField();
			txtsalary = new JTextField();
			txtcommission = new JTextField();
			txtitemSold = new JTextField();
			lblname = new JLabel("<html><h3>NAME:</h3></html>");
			lbladdress  = new JLabel("<html><h3>ADDRESS:</h3></html>");
			lblage  = new JLabel("<html><h3>AGE:</h3></html>");
			lblcompany  = new JLabel("<html><h3>COMPANY:</h3></html>");
			lblgender = new JLabel("<html><h3>GENDER:</h3></html>");
			lblsalary = new JLabel("<html><h3>SALARY:</h3></html>");
			lblcommission = new JLabel("<html><h3>COMMISSION:</h3></html>");
			lblitemSold = new JLabel("<html><h3>ITEMS SOLD:</h3></html>");
			btnadd  = new JButton("<html><h3>ADD</h3></html>");
			btnexit  = new JButton("<html><h3>BACK</h3></html>");

			btnexit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					main.setVisible(false);
				}
			});

			//include in panel
			top.add(header);
			center.add(lblname);
			center.add(txtname);
			center.add(lbladdress);
			center.add(txtaddress);
			center.add(lblage);
			center.add(txtage);
			center.add(lblcompany);
			center.add(txtcompany);
			center.add(lblgender);
			center.add(txtgender);
			center.add(lblsalary);
			center.add(txtsalary);
			center.add(lblcommission);
			center.add(txtcommission);
			center.add(lblitemSold);
			center.add(txtitemSold);
			bottom.add(btnadd);
			bottom.add(btnexit);

			btnadd.addActionListener(new ActionListener(){
				public void actionPerformed (ActionEvent ae){
					try {
					String name = null,company = null,gender = null,address = null;
					int age = 0,numberOfItems = 0;
					double salary = 0.0,commission = 0.0;

					name = txtname.getText();
					age = Integer.parseInt(txtage.getText());
					company = txtcompany.getText();
					gender = txtgender.getText();
					address = txtaddress.getText();
					salary = Double.parseDouble(txtsalary.getText());
					commission = Double.parseDouble(txtcommission.getText());
					numberOfItems = Integer.parseInt(txtitemSold.getText());

					CommissionEmployee ce = new CommissionEmployee(name,address,age,gender,company,salary,commission,numberOfItems);
					System.out.println("\n"+ce);
					pane.showMessageDialog(null,"Successfully Added!");
					txtname.setText("");
					txtage.setText("");
					txtcompany.setText("");
					txtgender.setText("");
					txtaddress.setText("");
					txtsalary.setText("");
					txtcommission.setText("");
					txtitemSold.setText("");
					add(ce);
					} catch (Exception ex) {
						System.out.println("\nError Detected. Input Again");
						pane.showMessageDialog(null,"Error Detected. Input Again");
						txtname.setText("");
						txtage.setText("");
						txtcompany.setText("");
						txtgender.setText("");
						txtaddress.setText("");
						txtsalary.setText("");
						txtcommission.setText("");
						txtitemSold.setText("");
						}
				}
			});

			//set
			main.add(center, BorderLayout.CENTER);
			main.add(top, BorderLayout.NORTH);
			main.add(bottom, BorderLayout.SOUTH);
			main.pack();
			main.setSize(400, 600);
			main.setLocationRelativeTo(null);
			main.setVisible(true);
		}
	}

	class addPE implements ActionListener{
		public void actionPerformed(ActionEvent ae){

			//frame
			main = new JFrame();
			main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Already there
			main.setExtendedState(JFrame.MAXIMIZED_BOTH);
			main.setUndecorated(true);

			//panel
			top = new JPanel();
			center = new JPanel();
			bottom = new JPanel();

			//construct
			top.setLayout(new GridLayout(1,1));
			center.setLayout(new GridLayout(7,2,-118,10));
			top.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
			center.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
			bottom.setBorder(BorderFactory.createEmptyBorder(20,5,10,5));
			bottom.setLayout(new GridLayout(1,2,5,5));
			header = new JLabel("<html><h1>PIECE WORKER</h1></html>", SwingConstants.CENTER);
			txtname = new JTextField();
			txtaddress = new JTextField();
			txtage = new JTextField();
			txtcompany = new JTextField();
			txtgender = new JTextField();
			txtnumItems = new JTextField();
			txtwage = new JTextField();
			lblname = new JLabel("<html><h3>NAME:</h3></html>");
			lbladdress  = new JLabel("<html><h3>ADDRESS:</h3></html>");
			lblage  = new JLabel("<html><h3>AGE:</h3></html>");
			lblcompany  = new JLabel("<html><h3>COMPANY:</h3></html>");
			lblgender = new JLabel("<html><h3>GENDER:</h3></html>");
			lblnumItems = new JLabel("<html><h3>NUMBER OF ITEMS:</h3></html>");
			lblwage = new JLabel("<html><h3>WAGE:</h3></html>");
			btnadd  = new JButton("<html><h3>ADD</h3></html>");
			btnexit  = new JButton("<html><h3>BACK</h3></html>");

			btnexit.addActionListener(new ActionListener(){
				public void actionPerformed(ActionEvent ae){
					main.setVisible(false);
				}
			});

			//include in panel
			top.add(header);
			center.add(lblname);
			center.add(txtname);
			center.add(lbladdress);
			center.add(txtaddress);
			center.add(lblage);
			center.add(txtage);
			center.add(lblcompany);
			center.add(txtcompany);
			center.add(lblgender);
			center.add(txtgender);
			center.add(lblnumItems);
			center.add(txtnumItems);
			center.add(lblwage);
			center.add(txtwage);
			bottom.add(btnadd);
			bottom.add(btnexit);

			btnadd.addActionListener(new ActionListener(){
				public void actionPerformed (ActionEvent ae){
					try {
					String name = null,company = null,gender = null,address = null;
					int age = 0,numberOfItems = 0;
					double wage = 0.0;

					name = txtname.getText();
					age = Integer.parseInt(txtage.getText());
					company = txtcompany.getText();
					gender = txtgender.getText();
					address = txtaddress.getText();
					wage = Double.parseDouble(txtwage.getText());
					numberOfItems = Integer.parseInt(txtnumItems.getText());

					PieceWorker ce = new PieceWorker(name,address,age,company,gender,numberOfItems,wage);
					System.out.println("\n"+ce);
					add(ce);
					pane.showMessageDialog(null,"Successfully Added!");
					txtname.setText("");
					txtage.setText("");
					txtcompany.setText("");
					txtgender.setText("");
					txtaddress.setText("");
					txtwage.setText("");
					txtnumItems.setText("");
					} catch (Exception ex) {
						System.out.println("\nError Detected. Input Again");
						pane.showMessageDialog(null,"Error Detected. Input Again");
						txtname.setText("");
						txtage.setText("");
						txtcompany.setText("");
						txtgender.setText("");
						txtaddress.setText("");
						txtwage.setText("");
						txtnumItems.setText("");
						}
				}
			});

			//set
			main.add(center, BorderLayout.CENTER);
			main.add(top, BorderLayout.NORTH);
			main.add(bottom, BorderLayout.SOUTH);
			main.pack();
			main.setSize(400, 600);
			main.setLocationRelativeTo(null);
			main.setVisible(true);
		}
	}

	class removeEmployee implements ActionListener{
		public void actionPerformed(ActionEvent ae){

				//frame
				main = new JFrame();
				main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Already there
				main.setExtendedState(JFrame.MAXIMIZED_BOTH);
				main.setUndecorated(true);

				//panel
				top = new JPanel();
				center = new JPanel();
				bottom = new JPanel();

				//construct
				top.setLayout(new GridLayout(1,1));
				top.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
				center.setLayout(new GridLayout(1,3,5,5));
				bottom.setLayout(new GridLayout(8,2,20,20));
				bottom.setBorder(BorderFactory.createEmptyBorder(10,50,180,20));
				center.setBorder(BorderFactory.createEmptyBorder(5,10,30,10));
				JButton removed = new JButton("<html><h3>REMOVE</h3></html>");
				header = new JLabel("<html><h1>REMOVE EMPLOYEE</h1></html>", SwingConstants.CENTER);
				choice = new JComboBox();
				lblname = new JLabel("Name:");
				lblage = new JLabel("Age:");
				lblcompany = new JLabel("Company:");
				lblgender = new JLabel("Gender:");
				lbladdress = new JLabel("Address");
				JLabel lblname1 = new JLabel();
				JLabel lblage1 = new JLabel();
				JLabel lblcompany1 = new JLabel();
				JLabel lblgender1 = new JLabel();
				JLabel lbladdress1 = new JLabel();
				JLabel lblfiller1 = new JLabel("affdadw");
				JLabel lblfiller2 = new JLabel("affdadw");
				JLabel lblfiller3 = new JLabel("affdadw");
				btnexit = new JButton("<html><h3>BACK</h3></html>");

				btnexit.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ae){
						main.setVisible(false);
					}
				});

				//label for Commission Employee
				lblsalary = new JLabel("Salary:");
				lblcommission = new JLabel("Commission:");
				lblitemSold = new JLabel("Item Sold:");
				JLabel lblsalary1 = new JLabel();
				JLabel lblcommission1 = new JLabel();
				JLabel lblitemSold1 = new JLabel();

				//label for PieceWorker
				lblnumItems  = new JLabel("Number of Items:");
				lblwage  = new JLabel("Wage:");
				JLabel lblnumItems1 = new JLabel();
				JLabel lblwage1 = new JLabel();


				//label for Hourly Employee
				lblhoursWorked  = new JLabel("Hours Worked:");
				lblrate  = new JLabel("Rate:");
				JLabel lblhoursWorked1= new JLabel();
				JLabel lblrate1 = new JLabel();

				//include in panel
				top.add(header);
				center.add(choice);
				center.add(removed);
				center.add(btnexit);

				bottom.add(lblname);
				bottom.add(lbladdress);
				bottom.add(lblage);
				bottom.add(lblgender);
				bottom.add(lblcompany);
				bottom.add(lblfiller1);
				bottom.add(lblfiller2);
				bottom.add(lblfiller3);

				choice.addItemListener(new ItemListener(){
					public void itemStateChanged(ItemEvent event){
						if(event.getStateChange() == ItemEvent.SELECTED){
							Object item = event.getItem();
							int i = (int) item;

							bottom.removeAll();
							bottom.revalidate();
							bottom.repaint();

							bottom.add(lblname);
							bottom.add(lblname1);
							lblname1.setText(list[i].getName());
							bottom.add(lbladdress);
							bottom.add(lbladdress1);
							lbladdress1.setText(list[i].getAddress());
							bottom.add(lblage);
							bottom.add(lblage1);
							lblage1.setText(Integer.toString(list[i].getAge()));
							bottom.add(lblgender);
							bottom.add(lblgender1);
							lblgender1.setText(list[i].getGender());
							bottom.add(lblcompany);
							bottom.add(lblcompany1);
							lblcompany1.setText(list[i].getCompany());

							if(list[i] instanceof CommissionEmployee){
								bottom.add(lblsalary);
								bottom.add(lblsalary1);
								lblsalary1.setText(Double.toString(((CommissionEmployee)list[i]).getSalary()));
								bottom.add(lblcommission);
								bottom.add(lblcommission1);
								lblcommission.setText(Double.toString(((CommissionEmployee)list[i]).getCommission()));
								bottom.add(lblitemSold);
								bottom.add(lblitemSold1);
								lblitemSold.setText(Integer.toString(((CommissionEmployee)list[i]).getItemSold()));
							}
							else if(list[i] instanceof PieceWorker){
								bottom.add(lblnumItems);
								bottom.add(lblnumItems1);
								lblnumItems1.setText(Double.toString(((PieceWorker)list[i]).getNumItems()));
								bottom.add(lblwage);
								bottom.add(lblwage1);
								lblwage1.setText(Double.toString(((PieceWorker)list[i]).getWage()));
								bottom.add(lblfiller1);
								bottom.add(lblfiller2);
							}
							else if(list[i] instanceof HourlyEmployee){
								bottom.add(lblhoursWorked);
								bottom.add(lblhoursWorked1);
								lblhoursWorked.setText(Integer.toString(((HourlyEmployee)list[i]).getHoursWorked()));
								bottom.add(lblrate);
								bottom.add(lblrate1);
								lblrate1.setText(Double.toString(((HourlyEmployee)list[i]).getRate()));
								bottom.add(lblfiller1);
								bottom.add(lblfiller2);
							}
						}
					}
				});
				for(int i=0;i<all;i++){
							choice.addItem(i);
				}

				removed.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ae){
						Object item = choice.getSelectedItem();
						int i = (int)item;
						/*if(){
							pane.showMessageDialog(null,"No entry available for removal.");
							main.setVisible(false);
						}*/
						System.out.println("\nRemoved");
						remove(list[i]);
						pane.showMessageDialog(null,"Successfully Removed!");

					}
				});

				//set
				main.add(center, BorderLayout.CENTER);
				main.add(top, BorderLayout.NORTH);
				main.add(bottom, BorderLayout.SOUTH);
				main.pack();
				main.setSize(400, 600);
				main.setLocationRelativeTo(null);
				main.setVisible(true);

		}
	}

	class displayAll implements ActionListener{
		public void actionPerformed(ActionEvent ae){

			//frame
				main = new JFrame();
				main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Already there
				main.setExtendedState(JFrame.MAXIMIZED_BOTH);
				main.setUndecorated(true);

			//panel
				top = new JPanel();
				center = new JPanel();
				bottom = new JPanel();

			//construct
				top.setLayout(new GridLayout(1,1));
				top.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
				center.setLayout(new GridLayout(1,3,5,5));
				bottom.setLayout(new GridLayout(8,2,20,20));
				bottom.setBorder(BorderFactory.createEmptyBorder(10,50,180,20));
				center.setBorder(BorderFactory.createEmptyBorder(5,10,30,10));
				header = new JLabel("<html><h1>Displaying all employee...</h1></html>", SwingConstants.CENTER);
				choice = new JComboBox();
				btnexport = new JButton("<html><h3>EXPORT</h3></html>");
				lblname = new JLabel("Name:");
				lblage = new JLabel("Age:");
				lblcompany = new JLabel("Company:");
				lblgender = new JLabel("Gender:");
				lbladdress = new JLabel("Address");
				JLabel lblname1 = new JLabel();
				JLabel lblage1 = new JLabel();
				JLabel lblcompany1 = new JLabel();
				JLabel lblgender1 = new JLabel();
				JLabel lbladdress1 = new JLabel();
				JLabel lblfiller1 = new JLabel("affdadw");
				JLabel lblfiller2 = new JLabel("affdadw");
				JLabel lblfiller3 = new JLabel("affdadw");
				btnexit = new JButton("<html><h3>BACK</h3></html>");

				btnexit.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ae){
						main.setVisible(false);
					}
				});

			//label for Commission Employee
				lblsalary = new JLabel("Salary:");
				lblcommission = new JLabel("Commission:");
				lblitemSold = new JLabel("Item Sold:");
				JLabel lblsalary1 = new JLabel();
				JLabel lblcommission1 = new JLabel();
				JLabel lblitemSold1 = new JLabel();

			//label for PieceWorker
				lblnumItems  = new JLabel("Number of Items:");
				lblwage  = new JLabel("Wage:");
				JLabel lblnumItems1 = new JLabel();
				JLabel lblwage1 = new JLabel();

			//label for Hourly Employee
				lblhoursWorked  = new JLabel("Hours Worked:");
				lblrate  = new JLabel("Rate:");
				JLabel lblhoursWorked1= new JLabel();
				JLabel lblrate1 = new JLabel();

			//include in panel
				top.add(header);
				center.add(choice);
				center.add(btnexport);
				center.add(btnexit);

				bottom.add(lblname);
				bottom.add(lbladdress);
				bottom.add(lblage);
				bottom.add(lblgender);
				bottom.add(lblcompany);
				bottom.add(lblfiller1);
				bottom.add(lblfiller2);
				bottom.add(lblfiller3);

			choice.addItemListener(new ItemListener(){
					public void itemStateChanged(ItemEvent event){
						if(event.getStateChange() == ItemEvent.SELECTED){
								Object item = event.getItem();
								int i = (int) item;

								bottom.removeAll();
								bottom.revalidate();
								bottom.repaint();

								bottom.add(lblname);
								bottom.add(lblname1);
								lblname1.setText(list[i].getName());
								bottom.add(lbladdress);
								bottom.add(lbladdress1);
								lbladdress1.setText(list[i].getAddress());
								bottom.add(lblage);
								bottom.add(lblage1);
								lblage1.setText(Integer.toString(list[i].getAge()));
								bottom.add(lblgender);
								bottom.add(lblgender1);
								lblgender1.setText(list[i].getGender());
								bottom.add(lblcompany);
								bottom.add(lblcompany1);
								lblcompany1.setText(list[i].getCompany());

								if(list[i] instanceof CommissionEmployee){
									bottom.add(lblsalary);
									bottom.add(lblsalary1);
									lblsalary1.setText(Double.toString(((CommissionEmployee)list[i]).getSalary()));
									bottom.add(lblcommission);
									bottom.add(lblcommission1);
									lblcommission.setText(Double.toString(((CommissionEmployee)list[i]).getCommission()));
									bottom.add(lblitemSold);
									bottom.add(lblitemSold1);
									lblitemSold.setText(Integer.toString(((CommissionEmployee)list[i]).getItemSold()));
								}
								else if(list[i] instanceof PieceWorker){
									bottom.add(lblnumItems);
									bottom.add(lblnumItems1);
									lblnumItems1.setText(Double.toString(((PieceWorker)list[i]).getNumItems()));
									bottom.add(lblwage);
									bottom.add(lblwage1);
									lblwage1.setText(Double.toString(((PieceWorker)list[i]).getWage()));
									bottom.add(lblfiller1);
									bottom.add(lblfiller2);
								}
								else if(list[i] instanceof HourlyEmployee){
									bottom.add(lblhoursWorked);
									bottom.add(lblhoursWorked1);
									lblhoursWorked.setText(Integer.toString(((HourlyEmployee)list[i]).getHoursWorked()));
									bottom.add(lblrate);
									bottom.add(lblrate1);
									lblrate1.setText(Double.toString(((HourlyEmployee)list[i]).getRate()));
									bottom.add(lblfiller1);
									bottom.add(lblfiller2);
								}

							}
						}
					});
					for(int i=0;i<all;i++){
						choice.addItem(i);
					}

				btnexport.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ae){

						String file = "all_Employees.txt";
						try{
						FileWriter f = new FileWriter(file);
						BufferedWriter b = new BufferedWriter(f);

						for(int i =0; i<all; i++){
							b.write("Name:" +list[i].getName());
							b.newLine();
							b.write("Address:" +list[i].getAddress());
							b.newLine();
							b.write("Age:" +list[i].getAge());
							b.newLine();
							b.write("Gender:" +list[i].getGender());
							b.newLine();
							b.write("Company:" +list[i].getCompany());
							b.newLine();
							if(list[i] instanceof CommissionEmployee){
								b.write("Salary:" +Double.toString(((CommissionEmployee)list[i]).getSalary()));
								b.newLine();
								b.write("Commission:" +Double.toString(((CommissionEmployee)list[i]).getCommission()));
								b.newLine();
								b.write("Item Sold:" +Integer.toString(((CommissionEmployee)list[i]).getItemSold()));
								b.newLine();
								b.newLine();
							}
							else if(list[i] instanceof PieceWorker){
								b.write("Number of Items:" +Double.toString(((PieceWorker)list[i]).getNumItems()));
								b.newLine();
								b.write("Wage:" +Double.toString(((PieceWorker)list[i]).getWage()));
								b.newLine();
								b.newLine();
							}
							else if(list[i] instanceof HourlyEmployee){
								b.write("Hours Worked:" +Integer.toString(((HourlyEmployee)list[i]).getHoursWorked()));
								b.newLine();
								b.write("Rate:" +Double.toString(((HourlyEmployee)list[i]).getRate()));
								b.newLine();
								b.newLine();
							}

						}
						b.close();
						}
						catch(FileNotFoundException exe){
							System.out.println("File not found");
						}
						catch(IOException exe){
							System.out.println("Unable to open file");
						}
						pane.showMessageDialog(null,"Exported to all_Employees.txt");
					}
				});

				//set
				main.add(center, BorderLayout.CENTER);
				main.add(top, BorderLayout.NORTH);
				main.add(bottom, BorderLayout.SOUTH);
				main.pack();
				main.setSize(400, 600);
				main.setLocationRelativeTo(null);
				main.setVisible(true);
		}
	}

	class displayCE implements ActionListener{
		public void actionPerformed(ActionEvent ae){

			//frame
				main = new JFrame();
				main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Already there
				main.setExtendedState(JFrame.MAXIMIZED_BOTH);
				main.setUndecorated(true);

			//panel
				top = new JPanel();
				center = new JPanel();
				bottom = new JPanel();

			//construct
				top.setLayout(new GridLayout(1,1));
				top.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
				center.setLayout(new GridLayout(1,3,5,5));
				bottom.setLayout(new GridLayout(8,2,20,20));
				bottom.setBorder(BorderFactory.createEmptyBorder(10,50,180,20));
				center.setBorder(BorderFactory.createEmptyBorder(5,10,30,10));
				header = new JLabel("<html><h1>Displaying all CEs...</h1></html>", SwingConstants.CENTER);
				choice = new JComboBox();
				btnexport = new JButton("<html><h3>EXPORT</h3></html>");
				lblname = new JLabel("Name:");
				lblage = new JLabel("Age:");
				lblcompany = new JLabel("Company:");
				lblgender = new JLabel("Gender:");
				lbladdress = new JLabel("Address");
				JLabel lblname1 = new JLabel();
				JLabel lblage1 = new JLabel();
				JLabel lblcompany1 = new JLabel();
				JLabel lblgender1 = new JLabel();
				JLabel lbladdress1 = new JLabel();
				JLabel lblfiller1 = new JLabel("affdadw");
				JLabel lblfiller2 = new JLabel("affdadw");
				JLabel lblfiller3 = new JLabel("affdadw");
				btnexit = new JButton("<html><h3>BACK</h3></html>");

				btnexit.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ae){
						main.setVisible(false);
					}
				});

			//label for Commission Employee
				lblsalary = new JLabel("Salary:");
				lblcommission = new JLabel("Commission:");
				lblitemSold = new JLabel("Item Sold:");
				JLabel lblsalary1 = new JLabel();
				JLabel lblcommission1 = new JLabel();
				JLabel lblitemSold1 = new JLabel();

			//include in panel
				top.add(header);
				center.add(choice);
				center.add(btnexport);
				center.add(btnexit);

				bottom.add(lblname);
				bottom.add(lbladdress);
				bottom.add(lblage);
				bottom.add(lblgender);
				bottom.add(lblcompany);
				bottom.add(lblfiller1);
				bottom.add(lblfiller2);
				bottom.add(lblfiller3);

			choice.addItemListener(new ItemListener(){
					public void itemStateChanged(ItemEvent event){
						if(event.getStateChange() == ItemEvent.SELECTED){
								Object item = event.getItem();
								int i = (int) item;

								if(list[i] instanceof CommissionEmployee){

								bottom.removeAll();
								bottom.revalidate();
								bottom.repaint();

								bottom.add(lblname);
								bottom.add(lblname1);
								lblname1.setText(list[i].getName());
								bottom.add(lbladdress);
								bottom.add(lbladdress1);
								lbladdress1.setText(list[i].getAddress());
								bottom.add(lblage);
								bottom.add(lblage1);
								lblage1.setText(Integer.toString(list[i].getAge()));
								bottom.add(lblgender);
								bottom.add(lblgender1);
								lblgender1.setText(list[i].getGender());
								bottom.add(lblcompany);
								bottom.add(lblcompany1);
								lblcompany1.setText(list[i].getCompany());
								bottom.add(lblsalary);
								bottom.add(lblsalary1);
								lblsalary1.setText(Double.toString(((CommissionEmployee)list[i]).getSalary()));
								bottom.add(lblcommission);
								bottom.add(lblcommission1);
								lblcommission.setText(Double.toString(((CommissionEmployee)list[i]).getCommission()));
								bottom.add(lblitemSold);
								bottom.add(lblitemSold1);
								lblitemSold.setText(Integer.toString(((CommissionEmployee)list[i]).getItemSold()));
								}
							}
						}
					});
					for(int i=0;i<all;i++){
						if(list[i] instanceof CommissionEmployee){
							choice.addItem(i);
						}
					}
				btnexport.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ae){

						String file = "commissioned_Employees.txt";
						try{
						FileWriter f = new FileWriter(file);
						BufferedWriter b = new BufferedWriter(f);

						for(int i =0; i<all; i++){
							if(list[i] instanceof CommissionEmployee){
								b.write("Name:" +list[i].getName());
								b.newLine();
								b.write("Address:" +list[i].getAddress());
								b.newLine();
								b.write("Age:" +list[i].getAge());
								b.newLine();
								b.write("Gender:" +list[i].getGender());
								b.newLine();
								b.write("Company:" +list[i].getCompany());
								b.newLine();
								b.write("Salary:" +Double.toString(((CommissionEmployee)list[i]).getSalary()));
								b.newLine();
								b.write("Commission:" +Double.toString(((CommissionEmployee)list[i]).getCommission()));
								b.newLine();
								b.write("Item Sold:" +Integer.toString(((CommissionEmployee)list[i]).getItemSold()));
								b.newLine();
								b.newLine();
							}
						}
						b.close();
						}
						catch(FileNotFoundException exe){
							System.out.println("File not found");
						}
						catch(IOException exe){
							System.out.println("Unable to open file");
						}
						pane.showMessageDialog(null,"Exported to commissioned_Employees.txt");
					}
				});

				//set
				main.add(center, BorderLayout.CENTER);
				main.add(top, BorderLayout.NORTH);
				main.add(bottom, BorderLayout.SOUTH);
				main.pack();
				main.setSize(400, 600);
				main.setLocationRelativeTo(null);
				main.setVisible(true);
		}
	}

class displayPE implements ActionListener{
		public void actionPerformed(ActionEvent ae){

			//frame
				main = new JFrame();
				main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Already there
				main.setExtendedState(JFrame.MAXIMIZED_BOTH);
				main.setUndecorated(true);

			//panel
				top = new JPanel();
				center = new JPanel();
				bottom = new JPanel();

			//construct
				top.setLayout(new GridLayout(1,1));
				top.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
				center.setLayout(new GridLayout(1,3,5,5));
				bottom.setLayout(new GridLayout(8,2,20,20));
				bottom.setBorder(BorderFactory.createEmptyBorder(10,50,180,20));
				center.setBorder(BorderFactory.createEmptyBorder(5,10,30,10));
				header = new JLabel("<html><h1>Displaying all Piece Workers...</h1></html>", SwingConstants.CENTER);
				choice = new JComboBox();
				btnexport = new JButton("<html><h3>EXPORT</h3></html>");
				lblname = new JLabel("Name:");
				lblage = new JLabel("Age:");
				lblcompany = new JLabel("Company:");
				lblgender = new JLabel("Gender:");
				lbladdress = new JLabel("Address");
				JLabel lblname1 = new JLabel();
				JLabel lblage1 = new JLabel();
				JLabel lblcompany1 = new JLabel();
				JLabel lblgender1 = new JLabel();
				JLabel lbladdress1 = new JLabel();
				JLabel lblfiller1 = new JLabel("affdadw");
				JLabel lblfiller2 = new JLabel("affdadw");
				JLabel lblfiller3 = new JLabel("affdadw");
				btnexit = new JButton("<html><h3>BACK</h3></html>");

				btnexit.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ae){
						main.setVisible(false);
					}
				});

			//label for PieceWorker
				lblnumItems  = new JLabel("Number of Items:");
				lblwage  = new JLabel("Wage:");
				JLabel lblnumItems1 = new JLabel();
				JLabel lblwage1 = new JLabel();

			//include in panel
				top.add(header);
				center.add(choice);
				center.add(btnexport);
				center.add(btnexit);

				bottom.add(lblname);
				bottom.add(lbladdress);
				bottom.add(lblage);
				bottom.add(lblgender);
				bottom.add(lblcompany);
				bottom.add(lblfiller1);
				bottom.add(lblfiller2);
				bottom.add(lblfiller3);

			choice.addItemListener(new ItemListener(){
					public void itemStateChanged(ItemEvent event){
						if(event.getStateChange() == ItemEvent.SELECTED){
								Object item = event.getItem();
								int i = (int) item;

							if(list[i] instanceof PieceWorker){

								bottom.removeAll();
								bottom.revalidate();
								bottom.repaint();

								bottom.add(lblname);
								bottom.add(lblname1);
								lblname1.setText(list[i].getName());
								bottom.add(lbladdress);
								bottom.add(lbladdress1);
								lbladdress1.setText(list[i].getAddress());
								bottom.add(lblage);
								bottom.add(lblage1);
								lblage1.setText(Integer.toString(list[i].getAge()));
								bottom.add(lblgender);
								bottom.add(lblgender1);
								lblgender1.setText(list[i].getGender());
								bottom.add(lblcompany);
								bottom.add(lblcompany1);
								lblcompany1.setText(list[i].getCompany());
								bottom.add(lblnumItems);
								bottom.add(lblnumItems1);
								lblnumItems1.setText(Double.toString(((PieceWorker)list[i]).getNumItems()));
								bottom.add(lblwage);
								bottom.add(lblwage1);
								lblwage1.setText(Double.toString(((PieceWorker)list[i]).getWage()));
								bottom.add(lblfiller1);
								bottom.add(lblfiller2);
								}
							}
						}
					});
					for(int i=0;i<all;i++){
						if(list[i] instanceof PieceWorker){
							choice.addItem(i);
						}
					}
					btnexport.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent ae){

							String file = "piece_Worker.txt";
							try{
							FileWriter f = new FileWriter(file);
							BufferedWriter b = new BufferedWriter(f);

							for(int i =0; i<all; i++){
								if(list[i] instanceof PieceWorker){
								b.write("Name:" +list[i].getName());
								b.newLine();
								b.write("Address:" +list[i].getAddress());
								b.newLine();
								b.write("Age:" +list[i].getAge());
								b.newLine();
								b.write("Gender:" +list[i].getGender());
								b.newLine();
								b.write("Company:" +list[i].getCompany());
								b.newLine();
								b.write("Number of Items:" +Double.toString(((PieceWorker)list[i]).getNumItems()));
								b.newLine();
								b.write("Wage:" +Double.toString(((PieceWorker)list[i]).getWage()));
								b.newLine();
								b.newLine();
								}
							}
							b.close();
							}
							catch(FileNotFoundException exe){
								System.out.println("File not found");
							}
							catch(IOException exe){
								System.out.println("Unable to open file");
							}
							pane.showMessageDialog(null,"Exported to piece_Worker.txt");
						}
				});

				//set
				main.add(center, BorderLayout.CENTER);
				main.add(top, BorderLayout.NORTH);
				main.add(bottom, BorderLayout.SOUTH);
				main.pack();
				main.setSize(400, 600);
				main.setLocationRelativeTo(null);
				main.setVisible(true);
		}
	}
	class displayHE implements ActionListener{
		public void actionPerformed(ActionEvent ae){

			//frame
				main = new JFrame();
				main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Already there
				main.setExtendedState(JFrame.MAXIMIZED_BOTH);
				main.setUndecorated(true);

			//panel
				top = new JPanel();
				center = new JPanel();
				bottom = new JPanel();

			//construct
				top.setLayout(new GridLayout(1,1));
				top.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
				center.setLayout(new GridLayout(1,3,5,5));
				bottom.setLayout(new GridLayout(8,2,20,20));
				bottom.setBorder(BorderFactory.createEmptyBorder(10,50,180,20));
				center.setBorder(BorderFactory.createEmptyBorder(5,10,30,10));
				header = new JLabel("<html><h1>Displaying all HEs...</h1></html>", SwingConstants.CENTER);
				choice = new JComboBox();
				btnexport = new JButton("<html><h3>EXPORT</h3></html>");
				lblname = new JLabel("Name:");
				lblage = new JLabel("Age:");
				lblcompany = new JLabel("Company:");
				lblgender = new JLabel("Gender:");
				lbladdress = new JLabel("Address");
				JLabel lblname1 = new JLabel();
				JLabel lblage1 = new JLabel();
				JLabel lblcompany1 = new JLabel();
				JLabel lblgender1 = new JLabel();
				JLabel lbladdress1 = new JLabel();
				JLabel lblfiller1 = new JLabel("affdadw");
				JLabel lblfiller2 = new JLabel("affdadw");
				JLabel lblfiller3 = new JLabel("affdadw");
				btnexit = new JButton("<html><h3>BACK</h3></html>");

				btnexit.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ae){
						main.setVisible(false);
					}
				});
			//label for Hourly Employee
				lblhoursWorked  = new JLabel("Hours Worked:");
				lblrate  = new JLabel("Rate:");
				JLabel lblhoursWorked1= new JLabel();
				JLabel lblrate1 = new JLabel();

			//include in panel
				top.add(header);
				center.add(choice);
				center.add(btnexport);
				center.add(btnexit);

				bottom.add(lblname);
				bottom.add(lbladdress);
				bottom.add(lblage);
				bottom.add(lblgender);
				bottom.add(lblcompany);
				bottom.add(lblfiller1);
				bottom.add(lblfiller2);
				bottom.add(lblfiller3);

			choice.addItemListener(new ItemListener(){
					public void itemStateChanged(ItemEvent event){
						if(event.getStateChange() == ItemEvent.SELECTED){
								Object item = event.getItem();
								int i = (int) item;

								if(list[i] instanceof HourlyEmployee){

								bottom.removeAll();
								bottom.revalidate();
								bottom.repaint();

								bottom.add(lblname);
								bottom.add(lblname1);
								lblname1.setText(list[i].getName());
								bottom.add(lbladdress);
								bottom.add(lbladdress1);
								lbladdress1.setText(list[i].getAddress());
								bottom.add(lblage);
								bottom.add(lblage1);
								lblage1.setText(Integer.toString(list[i].getAge()));
								bottom.add(lblgender);
								bottom.add(lblgender1);
								lblgender1.setText(list[i].getGender());
								bottom.add(lblcompany);
								bottom.add(lblcompany1);
								lblcompany1.setText(list[i].getCompany());
								bottom.add(lblhoursWorked);
								bottom.add(lblhoursWorked1);
								lblhoursWorked.setText(Integer.toString(((HourlyEmployee)list[i]).getHoursWorked()));
								bottom.add(lblrate);
								bottom.add(lblrate1);
								lblrate1.setText(Double.toString(((HourlyEmployee)list[i]).getRate()));
								bottom.add(lblfiller1);
								bottom.add(lblfiller2);
								}
							}
						}
					});
					for(int i=0;i<all;i++){
						if(list[i] instanceof HourlyEmployee){
							choice.addItem(i);
						}
					}
				btnexport.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent ae){

							String file = "hourly_Employees.txt";
							try{
							FileWriter f = new FileWriter(file);
							BufferedWriter b = new BufferedWriter(f);

							for(int i =0; i<all; i++){
								if(list[i] instanceof HourlyEmployee){
								b.write("Name:" +list[i].getName());
								b.newLine();
								b.write("Address:" +list[i].getAddress());
								b.newLine();
								b.write("Age:" +list[i].getAge());
								b.newLine();
								b.write("Gender:" +list[i].getGender());
								b.newLine();
								b.write("Company:" +list[i].getCompany());
								b.newLine();
								b.write("Hours Worked:" +Integer.toString(((HourlyEmployee)list[i]).getHoursWorked()));
								b.newLine();
								b.write("Rate:" +Double.toString(((HourlyEmployee)list[i]).getRate()));
								b.newLine();
								b.newLine();
								}
							}
							b.close();
							}
							catch(FileNotFoundException exe){
								System.out.println("File not found");
							}
							catch(IOException exe){
								System.out.println("Unable to open file");
							}
							pane.showMessageDialog(null,"Exported to hourly_Employees.txt");
						}
				});
				//set
				main.add(center, BorderLayout.CENTER);
				main.add(top, BorderLayout.NORTH);
				main.add(bottom, BorderLayout.SOUTH);
				main.pack();
				main.setSize(400, 600);
				main.setLocationRelativeTo(null);
				main.setVisible(true);
		}
	}
class payroll implements ActionListener{
		public void actionPerformed(ActionEvent ae){

			//frame
				main = new JFrame();
				main.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); // Already there
				main.setExtendedState(JFrame.MAXIMIZED_BOTH);
				main.setUndecorated(true);

			//panel
				top = new JPanel();
				center = new JPanel();
				bottom = new JPanel();

			//construct
				top.setLayout(new GridLayout(1,1));
				top.setBorder(BorderFactory.createEmptyBorder(5,10,5,10));
				center.setLayout(new GridLayout(1,3,5,5));
				bottom.setLayout(new GridLayout(9,2,20,20));
				bottom.setBorder(BorderFactory.createEmptyBorder(10,50,145,20));
				center.setBorder(BorderFactory.createEmptyBorder(5,10,30,10));
				header = new JLabel("<html><h1>Displaying payroll...</h1></html>", SwingConstants.CENTER);
				choice = new JComboBox();
				btnexport = new JButton("<html><h3>EXPORT</h3></html>");
				lblname = new JLabel("Name:");
				lblage = new JLabel("Age:");
				lblcompany = new JLabel("Company:");
				lblgender = new JLabel("Gender:");
				lbladdress = new JLabel("Address:");
				lblearnings = new JLabel("Earnings:");
				JLabel lblname1 = new JLabel();
				JLabel lblage1 = new JLabel();
				JLabel lblcompany1 = new JLabel();
				JLabel lblgender1 = new JLabel();
				JLabel lbladdress1 = new JLabel();
				JLabel lblfiller1 = new JLabel("affdadw");
				JLabel lblfiller2 = new JLabel("affdadw");
				JLabel lblfiller3 = new JLabel("affdadw");
				JLabel lblfiller4 = new JLabel("affdadw");
				JLabel lblearnings1 = new JLabel();
				btnexit = new JButton("<html><h3>BACK</h3></html>");

				btnexit.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent ae){
						main.setVisible(false);
					}
				});

			//label for Commission Employee
				lblsalary = new JLabel("Salary:");
				lblcommission = new JLabel("Commission:");
				lblitemSold = new JLabel("Item Sold:");
				JLabel lblsalary1 = new JLabel();
				JLabel lblcommission1 = new JLabel();
				JLabel lblitemSold1 = new JLabel();

			//label for PieceWorker
				lblnumItems  = new JLabel("Number of Items:");
				lblwage  = new JLabel("Wage:");
				JLabel lblnumItems1 = new JLabel();
				JLabel lblwage1 = new JLabel();

			//label for Hourly Employee
				lblhoursWorked  = new JLabel("Hours Worked:");
				lblrate  = new JLabel("Rate:");
				JLabel lblhoursWorked1= new JLabel();
				JLabel lblrate1 = new JLabel();

			//include in panel
				top.add(header);
				center.add(choice);
				center.add(btnexport);
				center.add(btnexit);

				bottom.add(lblname);
				bottom.add(lbladdress);
				bottom.add(lblage);
				bottom.add(lblgender);
				bottom.add(lblcompany);
				bottom.add(lblfiller1);
				bottom.add(lblfiller2);
				bottom.add(lblfiller3);
				bottom.add(lblfiller4);

				choice.addItemListener(new ItemListener(){
						public void itemStateChanged(ItemEvent event){
							if(event.getStateChange() == ItemEvent.SELECTED){
									Object item = event.getItem();
									int i = (int) item;

									bottom.removeAll();
									bottom.revalidate();
									bottom.repaint();

									bottom.add(lblname);
									bottom.add(lblname1);
									lblname1.setText(list[i].getName());
									bottom.add(lbladdress);
									bottom.add(lbladdress1);
									lbladdress1.setText(list[i].getAddress());
									bottom.add(lblage);
									bottom.add(lblage1);
									lblage1.setText(Integer.toString(list[i].getAge()));
									bottom.add(lblgender);
									bottom.add(lblgender1);
									lblgender1.setText(list[i].getGender());
									bottom.add(lblcompany);
									bottom.add(lblcompany1);
									lblcompany1.setText(list[i].getCompany());

									if(list[i] instanceof CommissionEmployee){
										bottom.add(lblsalary);
										bottom.add(lblsalary1);
										lblsalary1.setText(Double.toString(((CommissionEmployee)list[i]).getSalary()));
										bottom.add(lblcommission);
										bottom.add(lblcommission1);
										lblcommission.setText(Double.toString(((CommissionEmployee)list[i]).getCommission()));
										bottom.add(lblitemSold);
										bottom.add(lblitemSold1);
										lblitemSold.setText(Integer.toString(((CommissionEmployee)list[i]).getItemSold()));
										bottom.add(lblearnings);
										bottom.add(lblearnings1);
										lblearnings1.setText(Double.toString(((CommissionEmployee)list[i]).earnings()));
									}
									else if(list[i] instanceof PieceWorker){
										bottom.add(lblnumItems);
										bottom.add(lblnumItems1);
										lblnumItems1.setText(Double.toString(((PieceWorker)list[i]).getNumItems()));
										bottom.add(lblwage);
										bottom.add(lblwage1);
										lblwage1.setText(Double.toString(((PieceWorker)list[i]).getWage()));
										bottom.add(lblfiller1);
										bottom.add(lblfiller2);
										bottom.add(lblearnings);
										bottom.add(lblearnings1);
										lblearnings1.setText(Double.toString(((PieceWorker)list[i]).earnings()));
									}
									else if(list[i] instanceof HourlyEmployee){
										bottom.add(lblhoursWorked);
										bottom.add(lblhoursWorked1);
										lblhoursWorked.setText(Integer.toString(((HourlyEmployee)list[i]).getHoursWorked()));
										bottom.add(lblrate);
										bottom.add(lblrate1);
										lblrate1.setText(Double.toString(((HourlyEmployee)list[i]).getRate()));
										bottom.add(lblfiller1);
										bottom.add(lblfiller2);
										bottom.add(lblearnings);
										bottom.add(lblearnings1);
										lblearnings1.setText(Double.toString(((HourlyEmployee)list[i]).earnings()));
									}
								}
							}
						});
						for(int i=0;i<all;i++){
							choice.addItem(i);
					}

					btnexport.addActionListener(new ActionListener(){
						public void actionPerformed(ActionEvent ae){

							String file = "payroll.txt";
							try{
							FileWriter f = new FileWriter(file);
							BufferedWriter b = new BufferedWriter(f);

							for(int i =0; i<all; i++){
								b.write("Name:" +list[i].getName());
								b.newLine();
								b.write("Address:" +list[i].getAddress());
								b.newLine();
								b.write("Age:" +list[i].getAge());
								b.newLine();
								b.write("Gender:" +list[i].getGender());
								b.newLine();
								b.write("Company:" +list[i].getCompany());
								b.newLine();
								if(list[i] instanceof CommissionEmployee){
									b.write("Salary:" +Double.toString(((CommissionEmployee)list[i]).getSalary()));
									b.newLine();
									b.write("Commission:" +Double.toString(((CommissionEmployee)list[i]).getCommission()));
									b.newLine();
									b.write("Item Sold:" +Integer.toString(((CommissionEmployee)list[i]).getItemSold()));
									b.newLine();
									b.write("Earnings:" +Double.toString(((CommissionEmployee)list[i]).earnings()));
									b.newLine();
									b.newLine();
								}
								else if(list[i] instanceof PieceWorker){
									b.write("Number of Items:" +Double.toString(((PieceWorker)list[i]).getNumItems()));
									b.newLine();
									b.write("Wage:" +Double.toString(((PieceWorker)list[i]).getWage()));
									b.newLine();
									b.write("Earnings:" +Double.toString(((PieceWorker)list[i]).earnings()));
									b.newLine();
									b.newLine();
								}
								else if(list[i] instanceof HourlyEmployee){
									b.write("Hours Worked:" +Integer.toString(((HourlyEmployee)list[i]).getHoursWorked()));
									b.newLine();
									b.write("Rate:" +Double.toString(((HourlyEmployee)list[i]).getRate()));
									b.newLine();
									b.write("Earnings:" +Double.toString(((HourlyEmployee)list[i]).earnings()));
									b.newLine();
									b.newLine();
								}

							}
							b.close();
							}
							catch(FileNotFoundException exe){
								System.out.println("File not found");
							}
							catch(IOException exe){
								System.out.println("Unable to open file");
							}
							pane.showMessageDialog(null,"Exported to payroll.txt");
						}
				});
				//set
				main.add(center, BorderLayout.CENTER);
				main.add(top, BorderLayout.NORTH);
				main.add(bottom, BorderLayout.SOUTH);
				main.pack();
				main.setSize(400, 600);
				main.setLocationRelativeTo(null);
				main.setVisible(true);
		}
	}




	//main
	public static void main(String[] args){

		EmployeeRoster sample = new EmployeeRoster(10);
		/*
		Employee e;
		Scanner input = new Scanner(System.in);
		//main declaration
		int choice =0, flag =0, action=0;
		String fflush =null;

		//Employee declaration
		String name=null, gender=null, address=null, company=null;
		int age=0;

		//commissioned worker declaration
		float salary =0, commission =0;
		int itemSold =0;

		//piece worker declaration
		int numItems =0;
		float wage =0;

		//Hourly Employee declaration
		int hoursWorked =0;
		float rate =0;

		do{
			System.out.println("******************************************************");
			System.out.println("Employee Database");
			System.out.println("[1] Add Employee\n[2] Remove Employee\n[3] Display all Employee\n[4] Display all Commission Employee\n[5] Display all Piece Worker\n[6] Display all Hourly Employee\n[7] List Payroll");
			System.out.print("Input choice here: ");
			choice = input.nextInt();
			System.out.println("******************************************************");

			switch(choice){
				case 1: 	System.out.println("Add Employee:\t[1] Commission Employee\n\t\t[2]Piece Woker\n\t\t[3] Hourly Worker");
							System.out.print("Input Choice here: ");
							action = input.nextInt();
							System.out.print("\tName: ");
							name = input.nextLine();
							fflush = input.next();
							System.out.print("\tAddress: ");
							address = input.nextLine();
							fflush = input.next();
							System.out.print("\tAge: ");
							age = input.nextInt();
							System.out.print("\tGender: ");
							gender = input.nextLine();
							fflush = input.next();
							System.out.print("\tCompany: ");
							company = input.nextLine();
							fflush = input.next();
							if(action==1){
								System.out.print("\tSalary: ");
								salary = input.nextFloat();
								System.out.print("\tCommission: ");
								commission = input.nextFloat();
								System.out.print("\tItem Sold: ");
								itemSold = input.nextInt();
								e = new CommissionEmployee(name, address, age, gender, company, salary, commission, itemSold);
								sample.add(e);
							}
							else if(action==2){
								System.out.print("\tNumber of Items: ");
								numItems = input.nextInt();
								System.out.print("\tWage: ");
								wage = input.nextFloat();
								e = new PieceWorker(name, address, age, gender, company, numItems, wage);
								sample.add(e);
							}
							else if(action==3){
								System.out.print("\tHours Worked: ");
								hoursWorked = input.nextInt();
								System.out.print("\tRate: ");
								rate = input.nextFloat();
								e = new HourlyEmployee(name, address, age, gender, company, hoursWorked, rate);
								sample.add(e);
							}
							else{
								System.out.print("Wrong input. Please try again.");
								flag=0;
							}
							break;
				case 2: 	System.out.print("Enter employee index: ");
							action = input.nextInt();
							e = sample.search(action);
							sample.remove(e);
							break;
				case 3: 	System.out.println("Displaying all Employees...");
							sample.display();
							break;
				case 4:	System.out.println("Displaying all Commission Employees...");
							sample.displayCE();
							break;
				case 5:	System.out.println("Displaying all Piece Worker...");
							sample.displayPE();
							break;
				case 6: 	System.out.println("Displaying all Hourly Employee...");
							sample.displayHE();
							break;
				case 7:	System.out.println("Displaying payroll...");
							sample.payroll();
							break;
			}
			System.out.print("Run the program again? [0/1]: ");
			flag = input.nextInt();
		}while(flag==1);*/
	}

}