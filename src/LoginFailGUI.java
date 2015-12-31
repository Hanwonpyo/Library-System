
import java.awt.BorderLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;

public class LoginFailGUI extends JFrame{
	
	JFrame frame=new JFrame();
	LoginFailGUI()
	{
		frame.setSize(120, 75);
		frame.setVisible(true);
		frame.add(new JLabel("Login Failed"),BorderLayout.CENTER);
	}
}
