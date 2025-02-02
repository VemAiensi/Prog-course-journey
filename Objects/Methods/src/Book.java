class Book 
{
	private String bookTitle;
	private Author author;
	private double price;
	private int stock = 0;
	
	Book(String bookTitle, Author author, double price, int stock)
	{
		this.bookTitle = bookTitle;
		this.author = author;
		setPrice(price);
		setStock(stock);
	}
	
	public String getBookTitle()
	{
		return bookTitle;
	}
	
	public void setBookTitle(String bookTitle)
	{
		this.bookTitle = bookTitle;
	}
	
	public Author getAuthor()
	{
		return author;
	}
	
	public void setAuthor(Author author)
	{
		this.author = author;
	}
	
	public double getPrice()
	{
		return price;
	}
	
	public void setPrice(double price)
	{
		if (price >= 0)
		{
			this.price = price;
		}
		else
		{
			System.out.println("Note: Price should be positive! Set to 0");
			this.price = 0.0;
		}
	}
	
	public int getStock()
	{
		return stock;
	}
	
	public void setStock(int stock)
	{
		if (stock >= 0)
		{
			this.stock = stock;
		}
		else
		{
			System.out.println("Book stocks cannot be negative! Set to 0\n\n");
		}	
	}
	
	public String getAuthorName()
	{
		return author.getAuthor();
	}
	
	void print()
	{
		System.out.println("Book Title : " + bookTitle);
		author.print();
	}
}
