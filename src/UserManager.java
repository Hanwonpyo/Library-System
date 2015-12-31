import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class UserManager {
	public void list_user(UserListGUI U)
	{
		String []temp=new String[6];
		FileReader input;
		BufferedReader bf;
		String Input;
		
		try {
			input = new FileReader("user_info.txt");
			bf = new BufferedReader(input);
			while ((Input = bf.readLine()) != null) {
				String[] TEMP = Input.split(":");
				for (int i = 0; i < 6; i++)
					TEMP[i]=TEMP[i].trim();
				if(TEMP[5].compareTo("0")==0)
					TEMP[5]="NONE";
				U.model_user.addRow(TEMP);
			}			
			bf.close();
			}catch (Exception ex) {
			
			}	
	}
	public void register_user(User U) {
		
		try {
			FileWriter output=new FileWriter("user_info.txt", true);
			BufferedWriter writer = new BufferedWriter(output);
			writer.write(U.get_id_number());
			writer.write(":");
			writer.write(U.get_name());
			writer.write(":");
			writer.write(U.get_age());
			writer.write(":");
			writer.write(U.get_tel());
			writer.write(":");
			writer.write(U.get_address());
			writer.write(":");
			writer.write(U.get_book_id());
			writer.newLine();
			writer.close();
			
		}catch(Exception Ex) {
			
		}
	}

public User find_User_id(String id)
{
	User T=new User("0","0","0","0","0","0");
	FileReader input;
	BufferedReader bf;
	String Input;
	int count=0;
	
	try {
		input = new FileReader("user_info.txt");
		bf = new BufferedReader(input);
		while ((Input = bf.readLine()) != null) {
			String[] TEMP = Input.split(":");
			for (int i = 0; i < 6; i++) {
				TEMP[i]=TEMP[i].trim();
			}
			if(TEMP[0].compareTo(id)==0) {
				User A=new User(TEMP[0],TEMP[1],TEMP[2],TEMP[3],TEMP[4],TEMP[5]);
				return A;
			}
		}
		bf.close();
		
	}catch(Exception Ex) {
	 }
	return T;
}
public User find_User_book(String book_id)
{
	User T=new User("0","0","0","0","0","0");
	FileReader input;
	BufferedReader bf;
	String Input;
	int count=0;

	try {
		input = new FileReader("user_info.txt");
		bf = new BufferedReader(input);
		while ((Input = bf.readLine()) != null) {
			String[] TEMP = Input.split(":");
			for (int i = 0; i < 6; i++) {
				TEMP[i]=TEMP[i].trim();
			}
			if(TEMP[5].compareTo(book_id)==0) {
				User A=new User(TEMP[0],TEMP[1],TEMP[2],TEMP[3],TEMP[4],TEMP[5]);
				return A;
			}
		}
		bf.close();
		
	}catch(Exception Ex) {
	 }
	return T;
}
public void delete_User(String id) {
		
		FileReader input;
		BufferedReader bf;
		String Input;
		
		String [][]buffer=new String[1000][7];
		int count=0;
		
		try {
			input = new FileReader("user_info.txt");
			bf = new BufferedReader(input);
			while ((Input = bf.readLine()) != null) {
				
				String[] TEMP = Input.split(":");
				for (int i = 0; i < 6; i++) {
					TEMP[i]=TEMP[i].trim();
					buffer[count][i]=TEMP[i];
				}
				count++;
			}
			bf.close();
			
		}catch(Exception Ex) {
		 }
		
		try {
			FileWriter output = new FileWriter("user_info.txt",false);
			BufferedWriter writer = new BufferedWriter(output);
			for(int i=0;i<count;i++) {
				if(id.compareTo(buffer[i][0])==0) {
					continue;
				}
				else {
					writer.write(buffer[i][0]);
					writer.write(":");
					writer.write(buffer[i][1]);
					writer.write(":");
					writer.write(buffer[i][2]);
					writer.write(":");
					writer.write(buffer[i][3]);
					writer.write(":");
					writer.write(buffer[i][4]);
					writer.write(":");
					writer.write(buffer[i][5]);
					writer.newLine();
				}
			}
			writer.close();
			
		}catch(Exception Ex) {
		 }
	}
}
