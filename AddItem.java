import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.awt.event.*;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;


//creating class AddItem
class AddItem
{	
	//constructor with parameter to receive arraylist
	public AddItem(ArrayList<Employee> add,JFrame frame)
	{	
		//including list here so that i can access it in this frame
		list = add;
		
		//creating frame for add item selection
		JFrame addItemFrame = new AddItemFrame(list,frame);
		addItemFrame.setVisible(true);
		
	}


	ArrayList<Employee> list;
}


//class AddItemFrame 
class AddItemFrame extends JFrame
{
	public AddItemFrame(ArrayList<Employee> add,JFrame frame)
	{
		setSize(600,400);
		//receive arraylist
		list1 = add;
		
		//panel for text area
		JPanel panel = new TextPanel();
		
		//panel for buttons
		JPanel btnPanel = new AddButtonPanel( panel , list1,frame);
		
		//adding panels to frame
		add(panel , BorderLayout.CENTER);
		add(btnPanel , BorderLayout.SOUTH);
	
	}
	
	ArrayList<Employee> list1;

}

class AddButtonPanel extends JPanel
{	
	public AddButtonPanel(JPanel panel2 , ArrayList<Employee>list,JFrame frame)
	{
		this.list = list;
		//textPanel object
		panel = (TextPanel)panel2;
		//downcasting panel
		
		//making buttons
		JButton New = new JButton("NEW");
		JButton Save = new JButton("SAVE");
		JButton Exit = new JButton("EXIT");
		
		//adding buttons to panel
		add(New);
		add(Save);
		add(Exit);
	
		//enabling and disablling button
		boolean b1 = true;
		boolean b2 = false;
		
		Save.setEnabled(b1);
		New.setEnabled(b2);
		
		//Save button action :
		Save.addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent evt)
			{
				Employee e = new Employee();
				//
				 
				e.setEmpId(panel.getEmpId());
				e.setEmpName(panel.getEmpName());
				e.setEmpSal(panel.getEmpSal());
				e.setEmpGen(panel.getEmpG());
				e.setEmpDes(panel.getEmpD());
				
				//adding e to list
				list.add(e);
				
				//setting add to true and save to disable
				Save.setEnabled(b2);
				New.setEnabled(b1);
				//
				System.out.println("Added to employee");
				
			}
				
		});

		//Add button listner
		New.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt)
			{
				Save.setEnabled(b1);
				New.setEnabled(b2);
				
				//AddItem New = new AddItem(list);
				System.out.println("new created");
				
				
			}
			
		});
		//Exit
		Exit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt)
			{
				//addFrame.dispose();
				frame.setVisible(true);
				
			}
			
		}); 
		
	}
	

	private TextPanel panel;
	private ArrayList<Employee> list;
}

class TextPanel extends JPanel
{
	public TextPanel()
	{
		//setting layout
		GridLayout g = new GridLayout(5,2);
		this.setLayout(g);
		
		//adding label and textarea
		JLabel EmpId = new JLabel("EMP ID:");
		JTextField EmpID = new JTextField(10);
		add(EmpId);
		add(EmpID);
		
		JLabel EmpNm = new JLabel("EMP NAME:");
		JTextField EmpNM = new JTextField(10);
		add(EmpNm);
		add(EmpNM);
		
		JLabel Emps = new JLabel("EMP SAL:");
		JTextField EmpS = new JTextField(10);
		add(Emps);
		add(EmpS);
		
		JLabel Empg = new JLabel("EMP GENDER:");
		JTextField EmpG = new JTextField(5);
		add(Empg);
		add(EmpG);
		
		JLabel Empd = new JLabel("EMP DESC:");
		JTextField EmpD = new JTextField(10);
		add(Empd);
		add(EmpD);
		
		//storing inputed text to a variable
		tempId = EmpID.getText();
		tempName = EmpNM.getText();
		tempSal = EmpS.getText();
		tempG = EmpG.getText();
		tempD = EmpD.getText();
	}
	
		//creating a function which would give us inputed text
		public String getEmpId()
		{
			System.out.println("added to list");
			return tempId;
		}
		public String getEmpName()
		{System.out.println("added to list");
			return tempName;
		}
		public String getEmpSal()
		{System.out.println("added to list");
			return tempSal;
		}
		public String getEmpG()
		{System.out.println("added to list");
			return tempG;
		}
		public String getEmpD()
		{System.out.println("added to list");
			return tempD;
		}

		private String tempId;
		private String tempName;
		private String tempSal;
		private String tempG;
		private String tempD;
}

