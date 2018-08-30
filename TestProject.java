import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.*;



//Main Class
public class TestProject {

	public static void main(String[] args)
	{
		//Creating Frame for EMS Project the main frame
		
		JFrame mainFrame = new MainFrame();
		
		mainFrame.setVisible(true);
		
		mainFrame.setDefaultCloseOperation(mainFrame.EXIT_ON_CLOSE);

	}

}

//MainFrame class main panel will be made and attached to it
class MainFrame extends JFrame
{
	private JFrame main;
	public MainFrame()
	{	
		
		
		//storing this.mainFrame in mainFrame
		main = this;
		//initializing arraylist
		list = new ArrayList<Employee>();
		
		unitTest a = new unitTest(list);
		
		//Setting size of the frame
		setSize(600,400);
		
		//Main panel
		mainPanel = new JPanel();
	
		//creating grid layout
		GridLayout g = new GridLayout(6,1);
		
		//setting panel layout grid
		mainPanel.setLayout(g); 
		
		//adding panel to frame
		add(mainPanel);
		
		//panel for select button
		JPanel selectPanel = new JPanel();
		
		// adding selectPanel to frame
		add(selectPanel , BorderLayout.SOUTH);
		
		//creating button Select
		JButton btn = new JButton("SELECT");
		
		//adding btn to panel
			selectPanel.add(btn);
			
			
		//creating array of radio btns
			JRadioButton[] rbtn = new JRadioButton[6];
			
			//creating name array
			String[] bName = {"ADD ITEM" , "DISPLAY DATA" , "QUERY DATA" , "EDIT DATA" , "DELETE DATA" , "QUIT"};
		
			//Creating ButtonGroup
			ButtonGroup b = new ButtonGroup();
			
			
			//setting radioButtons
			for(int i =0;i<rbtn.length;i++)
			{
				rbtn[i]= makeButton( b , bName[i]);
			}
			
			
			//action listener function for btn class
				btn.addActionListener(new ActionListener() 
			{
			
			public void actionPerformed(ActionEvent evt)
			{	// UNIT TESING CODE
				if(rbtn[0].isSelected())
				{
					main.setVisible(false);
					AddItem add = new AddItem(list,main);
					System.out.println("ADD Item");
					
				}
				if(rbtn[1].isSelected())
				{
					main.setVisible(false);
					DisplayItem display = new DisplayItem(list,main);
					System.out.println("DISPLAY");
				}
				if(rbtn[2].isSelected())
				{
					main.setVisible(false);
					QueryItem display = new QueryItem(list,main);
					System.out.println("QUERY");
				}
				if(rbtn[3].isSelected())
				{
					main.setVisible(false);
					EditItem display = new EditItem(list,main);
					System.out.println("EDIT");
				}
				if(rbtn[4].isSelected())
				{	
					main.setVisible(false);
					DeleteItem display = new DeleteItem(list,main);
					System.out.println("DELETE");
				}
				if(rbtn[5].isSelected())
				{
					System.out.println("QUIT");
					main.dispose();
				} 
				
			}
			
			
				});
		
				//main.setVisible(true);
		
		
	}
	
	public JRadioButton makeButton( ButtonGroup g , String name )
	{	//creating rbtn
		JRadioButton rbtn = new JRadioButton(name);
		
		//Adding button to buttongroup
		g.add(rbtn);
		
		//adding rbtn to panel
		mainPanel.add(rbtn);
		
		return rbtn;
	}

	private JPanel mainPanel;
	ArrayList <Employee> list;
	
}







//Employee Class 
class Employee
{	
	//Funtions for assinging value
		public void setEmpId(String i)
	{
		empId = i;
	}

	public void setEmpSal(String s)
	{
		empSal = s;
	}

	public void setEmpName(String n)
	{
		 empName =n;
	}

	public void setEmpDes(String j)
	{
		empDesignation = j;
	}

	public void setEmpGen(String g)
	{
		empGender = g;
	}
	
	//Funtions for returning value to object
	public String getEmpId()
	{
		return empId;
	}
	
	public String getEmpSal()
	{
		return empSal;
	}
	
	public String getEmpName()
	{
		return empName;
	}
	
	public String getEmpDes()
	{
		return empDesignation;
	}
	
	public String getEmpGen()
	{
		return empGender;
	}
	
	private String empId;
	private String empName;
	private String empSal;
	private String empDesignation;
	private String empGender;
	

}



class unitTest
{
	public unitTest( ArrayList<Employee> add)
	{
		list = add;
		Employee e = new Employee();
		e.setEmpId("1");
		e.setEmpName("sudipt");
		e.setEmpSal("10000");
		e.setEmpGen("MALE");
		e.setEmpDes("GOOD");
		list.add(e);
		Employee e1 = new Employee();
		e1.setEmpId("2");
		e1.setEmpName("sud0");
		e1.setEmpSal("1005656");
		e1.setEmpGen("MALE");
		e1.setEmpDes("Gajdja");
		list.add(e1);
		Employee e2 = new Employee();
		e2.setEmpId("3");
		e2.setEmpName("asjdakjda");
		e2.setEmpSal("mnasdaknda");
		e2.setEmpGen("MALEasdhad");
		e2.setEmpDes("GOODa54sda5s4d");
		list.add(e2);
		
	}

	private  ArrayList<Employee> list;
}










