
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class DeleteBookGUI extends JFrame implements ActionListener {
	
	JFrame frame=new JFrame("Delete Book");
	JPanel p0 = new JPanel();
	JPanel p1 = new JPanel();
	JPanel p2 = new JPanel();
	JButton button_ok = new JButton("OK");
	JButton button_cancel = new JButton("CANCEL");
	JLabel label_id = new JLabel("Book ID number: ");
	JTextField text_id = new JTextField(10);
	
	
	DeleteBookGUI() {
		frame.setSize(320, 125);
		frame.setVisible(true);
		setLayout();
		addButton();
		addLabel();
		addTextField();
		mergePanel();
		frame.add(p1,BorderLayout.CENTER);
		frame.add(p2,BorderLayout.SOUTH);
	}
	private void setLayout() {
		p1.setLayout(new GridLayout(1,1));
	}
	private void addButton() {
		button_ok.addActionListener(this);
		button_cancel.addActionListener(this);
		p2.add(button_ok);
		p2.add(button_cancel);
	}
	
	private void addLabel() {
		p0.add(label_id,BorderLayout.WEST);
	}
	
	private void addTextField() {
		p0.add(text_id,BorderLayout.CENTER);
	}
	private void mergePanel() {
		p1.add(p0);
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource()==button_ok) {
			BookManager O=new BookManager();
			O.delete_book(text_id.getText());
			frame.dispose();
		}
		else if(e.getSource()==button_cancel) {
			frame.dispose();
		}
		else {
			
		}
	}	
}