
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

	public class LoginGUI extends JFrame implements ActionListener {
		
	private JFrame frame=new JFrame("Login Menu");
	private JPanel p1=new JPanel();
	private JPanel p2=new JPanel();
	private	JPanel p3=new JPanel();
	private JPanel p4=new JPanel();
	private JPanel p5=new JPanel();
	private JButton button_login = new JButton("Login");
	private JButton button_join = new JButton("Join");
	private JLabel label_id = new JLabel("ID :");
	private JLabel label_password = new JLabel("Password : ");
	private JTextField text_id = new JTextField(10);
	private JPasswordField text_password = new JPasswordField(10);
		public LoginGUI() {
			frame.setSize(300,140);
			frame.setVisible(true);
			setLayout();
			addButton();
			addLabel();
			addTextField();
			mergePanel();
			frame.add(p4,BorderLayout.CENTER);
			frame.add(p3,BorderLayout.SOUTH);
		}
		
		private void setLayout() {
			p1.setLayout(new GridLayout(1,2));
			p2.setLayout(new GridLayout(1,2));
			p3.setLayout(new GridLayout(1,2));
		}
		
		private void addButton() {
			button_login.addActionListener(this);
			button_join.addActionListener(this);
			p3.add(button_login);
			p3.add(button_join);
		}
		
		private void addLabel() {
			p1.add(label_id);
			p2.add(label_password);
		}
		
		private void addTextField() {
			p1.add(text_id);
			p2.add(text_password);
		}		
		private void mergePanel() {
			p4.setLayout(new FlowLayout());
			p4.add(p1);
			p4.add(p2);
			
		}	
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==button_login) {
				LoginManager I=new LoginManager();
				if(I.login_check(text_id.getText(),text_password.getText())) {
					MainGUI M=new MainGUI();
				}
				else {
					LoginFailGUI F=new LoginFailGUI();
				}
			}
			else if(e.getSource()==button_join) {
				JoinGUI J=new JoinGUI();
			}
			else {
				
			}
		}
}
