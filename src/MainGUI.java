
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
	public class MainGUI extends JFrame implements ActionListener {
		JFrame frame=new JFrame("Library System");
		JPanel p1=new JPanel();
		JPanel p2=new JPanel();
		JPanel p3=new JPanel();
		JPanel p4=new JPanel();
		JPanel p5=new JPanel();
		JPanel p6=new JPanel();
		JButton button_borrow = new JButton("Borrow");
		JButton button_return = new JButton("Return");
		JButton button_add = new JButton("Add");
		JButton button_delete = new JButton("Delete");
		JButton button_user = new JButton("User list");
		JButton button_join = new JButton("User Join");
		JButton button_book = new JButton("Book list");
		JLabel label_name = new JLabel("User Name : ");
		JLabel label_book = new JLabel("Book Name :");
		JLabel label_number = new JLabel("Book Number :");
		JLabel label_logo=new JLabel("Library System");
		JTextField text_name = new JTextField(10);
		JTextField text_book = new JTextField(10);
		JTextField text_number = new JTextField(10);
		
		
		MainGUI() {
			frame.setSize(400, 300);
			frame.setVisible(true);
			setLayout();
			addButton();
			addLabel();
			addTextField();
			mergePanel();
			frame.add(p6,BorderLayout.CENTER);
			frame.add(p1,BorderLayout.EAST);
			
		}
		private void setLayout() {
			p1.setLayout(new GridLayout(7,1));
			p2.setLayout(new FlowLayout());
			p3.setLayout(new FlowLayout());
			p4.setLayout(new GridLayout(7,1));
		}
		private void addButton() {
			button_borrow.addActionListener(this);
			button_return.addActionListener(this);
			button_add.addActionListener(this);
			button_delete.addActionListener(this);
			button_user.addActionListener(this);
			button_book.addActionListener(this);
			button_join.addActionListener(this);
			p1.add(button_borrow);
			p1.add(button_return);
			p1.add(button_add);
			p1.add(button_delete);
			p1.add(button_user);
			p1.add(button_book);
			p1.add(button_join);
		}
		private void addLabel() {
			p2.add(label_name);
			p3.add(label_book);
			p5.add(label_number);
			p6.add(label_logo);
		}
		private void addTextField() {
			p2.add(text_name);
			p3.add(text_book);
			p5.add(text_number);
		}
		private void mergePanel() {
			p4.add(p2);
			p4.add(p3);
			p4.add(p5);
		}
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			if(e.getSource()==button_borrow) {
				BorrowGUI G=new BorrowGUI();
			}
			else if(e.getSource()==button_return) {
				ReturnGUI R=new ReturnGUI();
			}
			else if(e.getSource()==button_add) {
				AddBookGUI A=new AddBookGUI();
			}
			else if(e.getSource()==button_delete) {
				DeleteBookGUI D=new DeleteBookGUI();
			}
			
			else if(e.getSource()==button_book){
				BookListGUI B=new BookListGUI();
			}
			else if(e.getSource()==button_user){
				UserListGUI U=new UserListGUI();
			}
			else if(e.getSource()==button_join) {
				AddUserGUI J=new AddUserGUI();
			}
		}
	}