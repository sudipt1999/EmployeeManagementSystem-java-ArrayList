import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DisplayItem
{
	public DisplayItem(ArrayList<Employee> add,JFrame frame)
	{
		list = add;
		JFrame display = new DisplayFrame(list,frame);
		display.setVisible(true);
	}

	private ArrayList<Employee> list;
}

class DisplayFrame extends JFrame
{
	public DisplayFrame(ArrayList<Employee> add,JFrame frame)
	{
		JFrame f = this;
		//seting size
		setSize(600 , 600);
		
		//receiving arraylist
		list = add;
		
		//creating a panel to add 
		JPanel displayPanel = new DisplayPanel(list);
		
		//adding panel
		add(displayPanel , BorderLayout.NORTH);
		
		//add a button exit to return to main frame
		JButton exit = new JButton("EXIT");
		add(exit,BorderLayout.SOUTH);
		//add exit button action listener
		exit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt)
			{
				f.dispose();
				frame.setVisible(true);
				
			}
			
		});
	}
	
	private ArrayList<Employee> list;
}


class DisplayPanel extends JPanel
{
	public DisplayPanel(ArrayList<Employee> add)
	{
		that = this;
		list = add;
		int i = list.size();
		
		//setting grid layout
		GridLayout g = new GridLayout(i+1,5);
		this.setLayout(g);
		
		//making a table
	
		
		JLabel EmpId = new JLabel("EMP ID:");
		add(EmpId);
		
		
		JLabel EmpNm = new JLabel("EMP NAME:");
		add(EmpNm);
		
		
		JLabel Emps = new JLabel("EMP SAL:");
		add(Emps);
		
		
		JLabel Empg = new JLabel("EMP GENDER:");
		add(Empg);
		
		
		JLabel Empd = new JLabel("EMP DESC:");
		add(Empd);
		
		int j = 1;
		//adding the data
		for(Employee e : list)
		{
			//adding
		
			
			JLabel tEmpId = new JLabel(e.getEmpId());
			that.add(tEmpId);
			
			
			JLabel tEmpNm = new JLabel(e.getEmpName());
			that.add(tEmpNm);
			
			
			JLabel tEmps = new JLabel(e.getEmpSal());
			that.add(tEmps);
			
			
			JLabel tEmpg = new JLabel(e.getEmpGen());
			that.add(tEmpg);
			
			
			JLabel tEmpd = new JLabel(e.getEmpDes());
			that.add(tEmpd);
			
			
		}
		
		
		
	}
	private DisplayPanel that;
	private ArrayList<Employee> list;
}