
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class ReturnFailGUI extends JFrame{
	
	JFrame frame=new JFrame();
	ReturnFailGUI()
	{
		frame.setSize(180, 75);
		frame.setVisible(true);
		frame.add(new JLabel("This book is not borrowed"),BorderLayout.CENTER);
	}
}
