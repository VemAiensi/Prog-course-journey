public class BookObject 
{
	public static void main(String[] args) 
	{
		Author author1 = new Author("Marcus Laurence", "milaurence@neu.edu.ph", "Male");
		author1.print();
		
		Book bk1 = new Book("Java Book", author1, 1499, 10);
		bk1.print();
		
		author1.setEmail("cuscus@gmail.com");
		
		author1.print();
		bk1.print();
		
		bk1.getAuthor().setEmail("Laurence.marcus@gmail.com");
		bk1.print();
	}
}