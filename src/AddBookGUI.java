
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddBookGUI extends JFrame implements ActionListener {
	
	JFrame frame=new JFrame("Add Book");
	JPanel p[] = new JPanel[6];
	JButton button_ok = new JButton("OK");
	JButton button_cancel = new JButton("CANCEL");
	JLabel label_name = new JLabel("Name : ");
	JLabel label_year = new JLabel("Year : ");
	JLabel label_id = new JLabel("ID number: ");
	JLabel label_author = new JLabel("Author : ");
	JTextField text_name = new JTextField(15);
	JTextField text_year = new JTextField(15);
	JTextField text_id = new JTextField(15);
	JTextField text_author = new JTextField(15);
	
	
	AddBookGUI() {
		frame.setSize(300, 200);
		frame.setVisible(true);
		for(int i=0;i<6;i++)
			p[i]=new JPanel();
		setLayout();
		addButton();
		addLabel();
		addTextField();
		mergePanel();
		frame.add(p[4],BorderLayout.CENTER);
		frame.add(p[5],BorderLayout.SOUTH);
	}
	private void setLayout() {
		p[4].setLayout(new GridLayout(4,1));
		for(int i=0;i<4;i++) {
			p[i].setLayout(new FlowLayout());
		}
	}
	private void addButton() {
		button_ok.addActionListener(this);
		button_cancel.addActionListener(this);
		p[5].add(button_ok);
		p[5].add(button_cancel);
	}
	
	private void addLabel() {
		p[0].add(label_id);
		p[1].add(label_name);
		p[2].add(label_author);
		p[3].add(label_year);
	}
	
	private void addTextField() {
		p[0].add(text_id);
		p[1].add(text_name);
		p[2].add(text_author);
		p[3].add(text_year);
	}
	private void mergePanel() {
		for(int i=0;i<4;i++) {
			p[4].add(p[i]);
		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==button_ok) {
			BookManager O=new BookManager();
			Book B=new Book(text_id.getText(), text_name.getText(),text_author.getText(),text_year.getText(),"YES");
			O.register_book(B);
			frame.dispose();
		}
		else if(e.getSource()==button_cancel) {
			frame.dispose();
		}
		else {
			
		}
	}	
}