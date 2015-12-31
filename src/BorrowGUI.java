import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class BorrowGUI extends JFrame implements ActionListener{

	JFrame frame = new JFrame("Borrow");
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JLabel label_id=new JLabel("User ID : ");
	JTextField text_id=new JTextField(10);
	JButton button_ok = new JButton("OK");
	JButton button_cancel = new JButton("CANCEL");

	BorrowGUI()
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
	}
	
	private void addTextField() {
		p1.add(text_id);
	}
	public void mergePanel() {
		
	}
	@Override
	public void actionPerformed(ActionEvent e) {
		if(e.getSource()==button_ok) {
			UserManager O=new UserManager();
			User U=O.find_User_id(text_id.getText());
			SearchGUI S=new SearchGUI(U);
			frame.dispose();
		}
		else if(e.getSource()==button_cancel) {
			frame.dispose();
		}
		else {
			
		}
	}
}
