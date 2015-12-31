

public class User {
	
	private String address;
	private String book_id="0";
	private String age;
	private String id_number;
	private String name;
	private String tel;
	
	User()
	{
		
	}
	User(String id_number,String name,String age,String tel,String address,String book_id) {
		this.id_number=id_number;
		this.name=name;
		this.age=age;
		this.tel=tel;
		this.address=address;
		this.book_id=book_id;
				
	}
	public void set_age(String age) {
		this.age=age;
	}
	public void set_id_number(String number) {
		this.id_number=number;
	}
	public void set_name(String name) {
		this.name=name;
	}
	public void set_tel(String tel) {
		this.tel=tel;
	}
	
	public String get_age() {
		return this.age;
	}
	public String get_id_number() {
		return this.id_number;
	}
	public String get_name() {
		return this.name;
	}
	public String get_tel() {
		return this.tel;
	}
	public void set_address(String address)
	{
		this.address=address;
	}
	public void set_book_id(String book_id)
	{
		this.book_id=book_id;
	}
	public String get_address()
	{
		return this.address;		
	}
	public String get_book_id()
	{
		return this.book_id;		
	}
}
