import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.io.BufferedReader;
import java.io.FileReader;

public class BookListGUI extends JFrame implements ActionListener {
	JFrame frame=new JFrame("Book List");
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JButton button_ok = new JButton("OK");
	JButton button_cancel = new JButton("CANCEL");

	private String colName[] = { "No.", "Name", "Author" ,"Year","Available"};
	private String data[]=new String[5];
	public DefaultTableModel model_book = new DefaultTableModel(colName, 0);
	public JTable table_book=new JTable(model_book)
	{
		public boolean isCellEditable(int rowIndex,int colIndex)
		{
			return false;
		}
	};	
	
	BookListGUI() {
		frame.setSize(400, 300);
		frame.setVisible(true);
		setLayout();
		//addLabel();		
		mergePanel();
		addRow();
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
		BookManager I=new BookManager();
		I.list_book(this);
		
	}	
	private void mergePanel() {
		p2.add(new JScrollPane(table_book),BorderLayout.CENTER);
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