
	import javax.swing.*;
	import java.awt.*;
	import java.awt.event.ActionEvent;
	import java.awt.event.ActionListener;

	public class JoinGUI extends JFrame implements ActionListener {
			
			private JPanel p[]=new JPanel[10];
			private JFrame frame=new JFrame("Join");
			private JLabel label_id = new JLabel("ID :");
			private JLabel label_password = new JLabel("Password : ");
			private JLabel label_name = new JLabel("Name :");
			private JLabel label_age = new JLabel("Age :");
			private JLabel label_tel = new JLabel("Tel :");
			private JLabel label_address = new JLabel("Address : ");
			
			private JTextField text_id = new JTextField(10);
			private JPasswordField text_password = new JPasswordField(10);
			private JTextField text_name = new JTextField(10);
			private JTextField text_age = new JTextField(10);
			private JTextField text_tel = new JTextField(10);
			private JTextField text_address = new JTextField(10);
			
			private JButton button_ok=new JButton("OK");
			private JButton button_cancel=new JButton("CANCEL");

			JoinGUI() {
				for(int i=0;i<10;i++)
					p[i]=new JPanel();
				setLayout();
				addButton();
				addLabel();
				addTextField();
				mergePanel();
				frame.add(p[6],BorderLayout.CENTER);
				frame.add(p[7],BorderLayout.SOUTH);
				frame.setSize(225,250);

				frame.setVisible(true);
			}
			
			private void setLayout() {
				p[6].setLayout(new GridLayout(6,1));
			//	for(int i=0;i<6;i++) {
			//		p[i].setLayout(new GridLayout(1,3));
			//	}
			}
			private void addButton() {
				button_ok.addActionListener(this);
				button_cancel.addActionListener(this);
				p[7].add(button_ok);
				p[7].add(button_cancel);
			}
			
			private void addLabel() {
				p[0].add(label_id);
				p[1].add(label_password);
				p[2].add(label_name);
				p[3].add(label_age);
				p[4].add(label_tel);
				p[5].add(label_address);
			}
			
			private void addTextField() {
				p[0].add(text_id);
				p[1].add(text_password);
				p[2].add(text_name);
				p[3].add(text_age);
				p[4].add(text_tel);
				p[5].add(text_address);
			}
			
			private void mergePanel() {
				for(int i=0;i<6;i++) {
					p[6].add(p[i]);
				}
			}	
			
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				if(e.getSource()==button_ok) {
					LoginManager O=new LoginManager();
					O.register_manager(text_id.getText(),text_password.getText());
					frame.dispose();
				}
				else if(e.getSource().equals(button_cancel)) {
					frame.dispose();
				}
				else {
					
				}
			}
}