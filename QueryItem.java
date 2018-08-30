
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class QueryItem {

	public QueryItem(ArrayList<Employee> add,JFrame frame)
	{
		list = add;
		
		//creating frame for display option
		JFrame queryFrame = new QueryFrame(list,frame);
		queryFrame.setVisible(true);
		
	}
	
	ArrayList<Employee> list;
}


class QueryFrame extends JFrame
{
	public QueryFrame(ArrayList<Employee> add,JFrame frame)
	{
		list = add;
		JFrame f = this;
		setSize(600 , 400);
		
		JPanel queryPanel = new QueryPanel();
		JPanel btn = new QueryBtnPanel(queryPanel , list);
		JPanel exitPanel = new JPanel();
		
		add(exitPanel , BorderLayout.SOUTH);
		add(btn , BorderLayout.NORTH);
		add(queryPanel , BorderLayout.CENTER);
		
		JButton exitbtn = new JButton("EXIT");
		exitPanel.add(exitbtn,BorderLayout.SOUTH);
		exitbtn.addActionListener(new ActionListener(){
		
			public void actionPerformed(ActionEvent evt)
			{
					f.dispose();
					frame.setVisible(true);
			}
			
			
		});
		
		
	}



	ArrayList<Employee> list;
}

class QueryBtnPanel extends JPanel
{
	public QueryBtnPanel(JPanel ob , ArrayList<Employee> add)
	{	
		panel = (QueryPanel)ob;
		
		
		
		
		list = add;
		
		JLabel label = new JLabel("ENTER ID");
		JTextField jId = new JTextField(5);
		JButton disBtn = new JButton("SHOW");
		add(label);
		add(jId);
		add(disBtn);
		
		
		
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
		
		
		
		
	}

	private ArrayList<Employee> list;
	private QueryPanel panel;
	private String Id;

}


class QueryPanel extends JPanel
{
	public QueryPanel()
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
		id = Id;
		EmpID.setText(id);
		EmpID.setEditable(false);
	}
	
	public void setName(String n)
	{
		name = n;
		EmpNM.setText(name);
		EmpNM.setEditable(false);
	}
	
	public void setGender(String g)
	{
		gender = g;
		EmpG.setText(gender);
		EmpG.setEditable(false);
	}
	
	public void setSal(String s)
	{
		sal = s;
		EmpS.setText(sal);
		EmpS.setEditable(false);
	}
	
	public void setDesc(String d)
	{
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