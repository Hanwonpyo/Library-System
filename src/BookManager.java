import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;

public class BookManager {
	
	BookManager()
	{
		
	}
	public boolean canBorrowBook(String id)
	{
		FileReader input;
		BufferedReader bf;
		String Input;
		
		try {
			input = new FileReader("book.txt");
			bf = new BufferedReader(input);
			while ((Input = bf.readLine()) != null) {
				String[] TEMP = Input.split(":");
				for (int i = 0; i < 5; i++)
					TEMP[i]=TEMP[i].trim();
				if(TEMP[0].compareTo(id)==0 && TEMP[4].compareTo("YES")==0) {
					this.delete_book(id);
					TEMP[4]="NO";
					Book B=new Book(TEMP[0],TEMP[1],TEMP[2],TEMP[3],TEMP[4]);
					bf.close();
					this.register_book(B);
					return true;
				}
				else if(TEMP[0].compareTo(id)==0 && TEMP[4].compareTo("NO")==0) {
					this.delete_book(id);
					TEMP[4]="YES";
					Book B=new Book(TEMP[0],TEMP[1],TEMP[2],TEMP[3],TEMP[4]);
					bf.close();
					this.register_book(B);
					return false;
				}
			}			
			bf.close();
			}catch (Exception ex) {
			
			 }
		return false;
	}
	public void list_book(BookListGUI B)
	{
		FileReader input;
		BufferedReader bf;
		String Input;
		
		try {
			input = new FileReader("book.txt");
			bf = new BufferedReader(input);
			while ((Input = bf.readLine()) != null) {
				String[] TEMP = Input.split(":");
				for (int i = 0; i < 5; i++)
					TEMP[i]=TEMP[i].trim();
				B.model_book.addRow(TEMP);
			}			
			bf.close();
			}catch (Exception ex) {
			
			 }	
	}
	public int match_type(String search_type)
	{
		if(search_type.compareTo("ID")==0)
			return 0;
		else if(search_type.compareTo("NAME")==0)
			return 1;
		else if(search_type.compareTo("AUTHOR")==0)
			return 2;
		else if(search_type.compareTo("YEAR")==0)
			return 3;
		return 0;
		
	}
	public void search_book(SearchGUI S,String search_type,String keyword)
	{
		FileReader input;
		BufferedReader bf;
		String Input;
		int type=match_type(search_type);
		try {
			input = new FileReader("book.txt");
			bf = new BufferedReader(input);
			while ((Input = bf.readLine()) != null) {
				String[] TEMP = Input.split(":");
				for (int i = 0; i < 5; i++)
					TEMP[i]=TEMP[i].trim();
				if(TEMP[type].compareTo(keyword)==0) {
					S.model_search.addRow(TEMP);
				}
			}			
			bf.close();
			}catch (Exception ex) {
			
			 }	
		
	}
	public void register_book(Book B) {
		
		try {
			FileWriter output=new FileWriter("book.txt", true);
			BufferedWriter writer = new BufferedWriter(output);
			writer.write(B.get_id());
			writer.write(":");
			writer.write(B.get_name());
			writer.write(":");
			writer.write(B.get_author());
			writer.write(":");
			writer.write(B.get_year());
			writer.write(":");
			writer.write(B.get_able());
			writer.newLine();
			writer.close();
			
		}catch(Exception Ex) {
			
		}
	}
	public void delete_book(String id) {
		
		FileReader input;
		BufferedReader bf;
		String Input;
		
		String [][]buffer=new String[1000][5];
		int count=0;
		
		try {
			input = new FileReader("book.txt");
			bf = new BufferedReader(input);
			while ((Input = bf.readLine()) != null) {
				
				String[] TEMP = Input.split(":");
				for (int i = 0; i < 5; i++) {
					TEMP[i]=TEMP[i].trim();
					buffer[count][i]=TEMP[i];
				}
				count++;
			}
			bf.close();
			
		}catch(Exception Ex) {
		 }
		
		try {
			FileWriter output = new FileWriter("book.txt",false);
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
					writer.newLine();
				}
			}
			writer.close();
			
		}catch(Exception Ex) {
		 }
	}
}
