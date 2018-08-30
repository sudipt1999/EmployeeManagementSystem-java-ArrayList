
import java.util.ArrayList;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class EditItem {

	public EditItem(ArrayList<Employee> add,JFrame frame)
	{
		list = add;
		
		//creating frame for display option
		JFrame editFrame = new EditFrame(list,frame);
		editFrame.setVisible(true);
		
	}
	
	ArrayList<Employee> list;
}


class EditFrame extends JFrame
{
	public EditFrame(ArrayList<Employee> add,JFrame frame)
	{
		list = add;
		
		setSize(600 , 400);
		JFrame f = this;
		JPanel editPanel = new EditPanel();
		JPanel btn = new EditBtnPanel(editPanel , list,frame,f);
		
		add(btn , BorderLayout.NORTH);
		add(editPanel , BorderLayout.CENTER);
		
	}



	ArrayList<Employee> list;
}

class EditBtnPanel extends JPanel
{
	public EditBtnPanel(JPanel ob , ArrayList<Employee> add,JFrame frame,JFrame f)
	{	
		panel = (EditPanel)ob;
		list = add;
		
		JLabel label = new JLabel("ENTER ID");
		JTextField jId = new JTextField(5);
		JButton disBtn = new JButton("SHOW");
		JButton edit = new JButton("EDIT");
		JButton save = new JButton("SAVE");
		JButton exit = new JButton("EXIT");
		
		add(label);
		add(jId);
		add(disBtn);
		add(edit);
		add(save);
		add(exit);
		
		exit.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent evt)
			{
				f.dispose();
				frame.setVisible(true);
				
			}
			
		});
		
		edit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt)
			{
				panel.setEditable();
			}
			
		});
		
		save.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent evt)
			{
				panel.save(list.get(check));
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
						check =i;
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
	private EditPanel panel;
	private String Id;
	private int check; 

}


class EditPanel extends JPanel
{
	public EditPanel()
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
	
	public void setEditable()
	{
		EmpD.setEditable(true);
		EmpS.setEditable(true);
		EmpID.setEditable(true);
		EmpNM.setEditable(true);
		EmpG.setEditable(true);
	}
	
	public void save(Employee e)
	{

		e.setEmpDes(EmpD.getText());
		e.setEmpSal(EmpS.getText());
		e.setEmpId(EmpID.getText());
		e.setEmpName(EmpNM.getText());
		e.setEmpGen(EmpG.getText());
		
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