

public class Book {
	private String id;
	private String year;
	private String name;
	private String author;
	private String able="YES";
	
	Book()
	{
		
	}
	
	Book(String id,String name,String author,String year,String able)
	{
		this.id=id;
		this.year=year;
		this.name=name;
		this.author=author;
		this.able=able;
	}
	
	public void set_id(String id)
	{
		this.id=id;
	}
	public void set_year(String year)
	{
		this.year=year;
	}
	public void set_name(String name)
	{
		this.name=name;
		
	}
	public void set_author(String author)
	{
		this.author=author;
	}
	
	public String get_id()
	{
		return this.id;
	}
	public String get_year()
	{
		return this.year;
	}
	public String get_name()
	{
		return this.name;
	}
	public String get_author()
	{
		return this.author;
	}
	public String get_able()
	{
		return this.able;
	}
	
}
