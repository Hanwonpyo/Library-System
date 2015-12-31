import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JScrollPane;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class SearchGUI extends JFrame implements ActionListener {
	JFrame frame=new JFrame("Search");
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JPanel p3=new JPanel();
	JPanel p4=new JPanel();
	JPanel p5=new JPanel();
	JPanel p6=new JPanel();
	JButton button_ok = new JButton("OK");
	JButton button_cancel = new JButton("CANCEL");
	JButton button_search= new JButton("Search");
	JTextField text_result= new JTextField("Result:");
	JTextField text_search= new JTextField(20);
	private String[] searchby={"ID","NAME","AUTHOR","YEAR"};
	private String colName[] = { "No.", "Name", "Author" ,"Year","Available"};
	private String []data=new String[6];
	JComboBox jcb=new JComboBox(searchby);
	BookManager I=new BookManager();
		
	public DefaultTableModel model_search = new DefaultTableModel(colName, 0);
	public JTable table_search=new JTable(model_search)
	{
		public boolean isCellEditable(int rowIndex,int colIndex)
		{
			return false;
		}
	};
	SearchGUI()
	{
		
	}
	SearchGUI(User U) {
		frame.setSize(475, 300);
		frame.setVisible(true);
		//addRow();
		setLayout();
		addLabel();
		addTextField();
		addButton();
		mergePanel();
		table_search.addMouseListener(new MouseAdapter() {
		@Override
			public void mouseClicked(MouseEvent e) {
				if (e.getClickCount() == 2) {
			         JTable target = (JTable)e.getSource();
			         int row = target.getSelectedRow();
			         data[0]=(String) model_search.getValueAt(row, 0);
			         data[1]=(String) model_search.getValueAt(row, 1);
			         data[2]=(String) model_search.getValueAt(row, 2);
			         data[3]=(String) model_search.getValueAt(row, 3);
			         data[4]=(String) model_search.getValueAt(row, 4);
			         if(I.canBorrowBook(data[0])==true) {
			        	 UserManager O=new UserManager();
			        	 O.delete_User(U.get_id_number());
			        	 System.out.println(data[0]);
			        	 U.set_book_id(data[0]);
			        	 O.register_user(U);
			         }
			         else {
			        	 LoginFailGUI F=new LoginFailGUI();
			         }
			        
				}
			}
		});
		frame.add(p1,BorderLayout.NORTH);
		frame.add(p4,BorderLayout.CENTER);
		frame.add(p5,BorderLayout.SOUTH);
	}
	private void addLabel() {
		p3.add(text_result);
	}
	private void addTextField() {
		p1.add(jcb);
		p1.add(text_search);
	}
	private void addButton() {
		button_ok.addActionListener(this);
		button_search.addActionListener(this);
		button_cancel.addActionListener(this);		
		p1.add(button_search);
		p5.add(button_ok);
		p5.add(button_cancel);	
		
	}
	private void mergePanel() {
		
		p4.add(new JScrollPane(table_search),BorderLayout.CENTER);
	}
	
	private void setLayout() {
		p1.setLayout(new FlowLayout());
		p2.setLayout(new BorderLayout(1,1));
		
	}
	private void addRow() {
		I.search_book(this,(String)this.jcb.getSelectedItem(),
				text_search.getText());
	}	
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button_ok) {
			frame.dispose();
		}
		else if(e.getSource()==button_cancel) {
			frame.dispose();
		}
		else if(e.getSource()==button_search) {
			addRow();
		}
	}
}