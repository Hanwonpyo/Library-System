import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class ReturnGUI extends JFrame implements ActionListener{

	JFrame frame = new JFrame("Return");
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JLabel label_id=new JLabel("Book ID : ");
	JLabel label_null=new JLabel(" ");
	JTextField text_id=new JTextField(10);
	JButton button_ok = new JButton("OK");
	JButton button_cancel = new JButton("CANCEL");
	

	ReturnGUI()
	{
		frame.setSize(220,110);
		frame.setVisible(true);
		setLayout();
		addButton();
		addLabel();
		addTextField();
		mergePanel();
		
		frame.add(p1,BorderLayout.CENTER);
		frame.add(p2,BorderLayout.SOUTH);
	
	}
	public void setLayout() {
		p1.setLayout(new FlowLayout());
		
	}
	public void addButton() {
		button_ok.addActionListener(this);
		button_cancel.addActionListener(this);
		p2.add(button_ok);
		p2.add(button_cancel);
	}
	private void addLabel() {
		p1.add(label_id);
		p1.add(label_null);
	}
	
	private void addTextField() {
		p1.add(text_id);
	}
	public void mergePanel() {
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button_ok) {
			BookManager I=new BookManager();
			UserManager O=new UserManager();
			if(I.canBorrowBook(text_id.getText())==false ){
				 User U=O.find_User_book(text_id.getText());
	        	 O.delete_User(U.get_id_number());
	        	 U.set_book_id("0");
	        	 O.register_user(U);
				frame.dispose();
			}
			else {
				ReturnFailGUI F=new ReturnFailGUI();
				frame.dispose();
			}
		}
		else if(e.getSource()==button_cancel) {
			frame.dispose();
		}
		else {
			
		}
	}
}
