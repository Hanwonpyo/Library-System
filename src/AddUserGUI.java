import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class AddUserGUI extends JFrame implements ActionListener {
	
	JFrame frame=new JFrame("Add User");
	JPanel p[] = new JPanel[8];
	JButton button_ok = new JButton("OK");
	JButton button_cancel = new JButton("CANCEL");
	JLabel label_name = new JLabel("Name : ");
	JLabel label_age = new JLabel("Age : ");
	JLabel label_id = new JLabel("ID number: ");
	JLabel label_tel = new JLabel("Tel : ");
	JLabel label_address = new JLabel("Address : ");
	JTextField text_name = new JTextField(15);
	JTextField text_age = new JTextField(15);
	JTextField text_id = new JTextField(15);
	JTextField text_tel = new JTextField(15);
	JTextField text_address = new JTextField(15);
	
	AddUserGUI() {
		frame.setSize(350, 225);
		frame.setVisible(true);
		for(int i=0;i<8;i++)
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
		p[4].setLayout(new GridLayout(5,1));
		for(int i=0;i<4;i++) {
			p[i].setLayout(new FlowLayout());
		}p[7].setLayout(new FlowLayout());
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
		p[2].add(label_age);
		p[3].add(label_tel);
		p[7].add(label_address);
	}
	
	private void addTextField() {
		p[0].add(text_id);
		p[1].add(text_name);
		p[2].add(text_age);
		p[3].add(text_tel);
		p[7].add(text_address);
	}
	private void mergePanel() {
		for(int i=0;i<4;i++) {
			p[4].add(p[i]);
		}
		p[4].add(p[7]);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==button_ok) {
			UserManager O=new UserManager();
			User U=new User(text_id.getText(), text_name.getText(),
					text_age.getText(),text_tel.getText(),text_address.getText(),"0");
			O.register_user(U);
			frame.dispose();
		}
		else if(e.getSource()==button_cancel) {
			frame.dispose();
		}
		else {
			
		}
	}	
}