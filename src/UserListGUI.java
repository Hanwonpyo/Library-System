import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class UserListGUI extends JFrame implements ActionListener {
	JFrame frame=new JFrame("User List");
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JButton button_ok = new JButton("OK");
	JButton button_cancel = new JButton("CANCEL");
	
	private String data[]=new String[6];
	private String colName[] = { "Number", "Name", "Age" ,"Tel","Address","Book ID"};	
	
	public DefaultTableModel model_user = new DefaultTableModel(colName, 0);
	public JTable table_user=new JTable(model_user)
	{
		public boolean isCellEditable(int rowIndex,int colIndex)
		{
			return false;
		}
	};	
	
	UserListGUI() {
		frame.setSize(425, 300);
		frame.setVisible(true);
		addRow();
		setLayout();
		//addLabel();		
		mergePanel();
		frame.add(p2,BorderLayout.CENTER);
		frame.add(p1,BorderLayout.NORTH);		
	}	
	private void setLayout() {
		p1.setLayout(new GridLayout(1,2));
		p2.setLayout(new BorderLayout(1,1));
		
	}
	private void addButton() {
		button_ok.addActionListener(this);
		button_cancel.addActionListener(this);
		p1.add(button_ok);
		p1.add(button_cancel);
	}
	private void addRow() {
		UserManager I=new UserManager();
		I.list_user(this);
		
	}	
	private void mergePanel() {
		p2.add(new JScrollPane(table_user),BorderLayout.CENTER);
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button_ok) {
			frame.dispose();
		}
		else if(e.getSource()==button_cancel) {
			frame.dispose();
		}
		else {
			
		}
	}
}