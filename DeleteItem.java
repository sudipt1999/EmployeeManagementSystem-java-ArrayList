import java.awt.*;
import java.awt.event.*;
import javax.swing.*;


import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class DeleteItem {

	public DeleteItem(ArrayList<Employee> add,JFrame frame)
	{
		list = add;
		
		//creating frame for display option
		JFrame deleteFrame = new DeleteFrame(list,frame);
		deleteFrame.setVisible(true);
		
	}
	
	ArrayList<Employee> list;
}


class DeleteFrame extends JFrame
{
	public DeleteFrame(ArrayList<Employee> add,JFrame frame)
	{
		list = add;
		JFrame f = this;
		
		setSize(600 , 400);
		
		JPanel deletePanel = new DeletePanel();
		JPanel btn = new DeleteBtnPanel(deletePanel , list,frame,f);
		
		add(btn , BorderLayout.NORTH);
		add(deletePanel , BorderLayout.CENTER);
		
	}



	ArrayList<Employee> list;
}

class DeleteBtnPanel extends JPanel
{
	public DeleteBtnPanel(JPanel ob , ArrayList<Employee> add,JFrame frame,JFrame f)
	{	
		panel = (DeletePanel)ob;
		
		
		
		
		list = add;
		
		JLabel label = new JLabel("ENTER ID");
		JTextField jId = new JTextField(5);
		JButton disBtn = new JButton("SHOW");
		JButton delBtn = new JButton("DELETE");
		add(label);
		add(jId);
		add(disBtn);
		add(delBtn);
		JButton exit = new JButton("EXIT");
		add(exit);
		exit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt)
			{
				f.dispose();
				frame.setVisible(true);
				
			}
			
		});
		
		
		disBtn.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt)
			{
				//received the id
				Id = jId.getText();
				System.out.println("INPUT IS "+Id);
				
				//searchig in the arraylist
				for(int i =0 ; i<list.size(); i++)
				{
					System.out.println(i);
					
					Employee e = list.get(i);
					String temp = e.getEmpId();
					System.out.println(temp);
					if(temp.equals(Id))
					{		
						check = i;
						//sending data from employee to fields
						panel.setID(e.getEmpId());
						panel.setName(e.getEmpName());
						panel.setGender(e.getEmpGen());
						panel.setSal(e.getEmpSal());
						panel.setDesc(e.getEmpDes());
	
					}
					
				}
				
				
			}
			
		});
		
		//delbtn action listener
		delBtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt)
			{
				list.remove(check);
				panel.setID(" ");
				panel.setName(" ");
				panel.setGender(" ");
				panel.setSal(" ");
				panel.setDesc(" ");

			}
		});
		
		
		
		
	}

	private ArrayList<Employee> list;
	private DeletePanel panel;
	private String Id;
	private int check;

}


class DeletePanel extends JPanel
{
	public DeletePanel()
	{
		
		//setting layout
				GridLayout g = new GridLayout(5,2);
				this.setLayout(g);
				
				//adding label and textarea
				JLabel EmpId = new JLabel("EMP ID:");
				EmpID = new JTextField(10);
				add(EmpId);
				add(EmpID);
				
				
				JLabel EmpNm = new JLabel("EMP NAME:");
				EmpNM = new JTextField(10);
				add(EmpNm);
				add(EmpNM);
				
				
				JLabel Emps = new JLabel("EMP SAL:");
				EmpS = new JTextField(10);
				add(Emps);
				add(EmpS);
				
				
				JLabel Empg = new JLabel("EMP GENDER:");
				EmpG = new JTextField(5);
				add(Empg);
				add(EmpG);
				
				
				JLabel Empd = new JLabel("EMP DESC:");
				EmpD = new JTextField(10);
				add(Empd);
				add(EmpD);
				
		
	}

	public void setID(String Id)
	{
		EmpID.setEditable(true);
		id = Id;
		EmpID.setText(id);
		EmpID.setEditable(false);
	}
	
	public void setName(String n)
	{
		EmpNM.setEditable(true);
		name = n;
		EmpNM.setText(name);
		EmpNM.setEditable(false);
	}
	
	public void setGender(String g)
	{
		EmpG.setEditable(true);
		gender = g;
		EmpG.setText(gender);
		EmpG.setEditable(false);
	}
	
	public void setSal(String s)
	{
		EmpS.setEditable(true);
		sal = s;
		EmpS.setText(sal);
		EmpS.setEditable(false);
	}
	
	public void setDesc(String d)
	{
		EmpD.setEditable(true);
		desc = d;
		EmpD.setText(desc);
		EmpD.setEditable(false);
	}
	
	private String id;
	private String name;
	private String gender;
	private String desc;
	private String sal;
	private JTextField EmpID;
	private JTextField EmpNM;
	private JTextField EmpG;
	private JTextField EmpS;
	private JTextField EmpD;
	
}
