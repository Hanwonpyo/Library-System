import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;

public class LoginManager {
	
	
	public boolean login_check(String id, String password)
	{
		int i;
		FileReader input;
		BufferedReader bf;
		String Input;
		
		try {
			input = new FileReader("manager.txt");
			bf = new BufferedReader(input);
			while ((Input = bf.readLine()) != null) {
				String[] TEMP = Input.split(":");
				for (i = 0; i < 2; i++)
					TEMP[i]=TEMP[i].trim();
				if( TEMP[0].compareTo(id)==0 && TEMP[1].compareTo(password)==0) {
					return true;
				}
			}
			bf.close();
			} catch (Exception ex) {
			
		}
		return false;
	}
	public void register_manager(String id, String password) {	
		
		try {
			FileWriter output = new FileWriter("manager.txt",true);
			BufferedWriter writer = new BufferedWriter(output);
			writer.write(id);
			writer.write(":");
			writer.write(password);
			writer.newLine();
			writer.close();
		}catch(Exception Ex) {
			
		}
	}
}
