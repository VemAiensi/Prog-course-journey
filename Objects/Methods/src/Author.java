class Author
{
	private String author;
	private String email;
	private String gender;
	
	Author(String author, String email, String gender)
	{
		this.author = author;
		setEmail(email);
		setGender(gender);
	}
	
	public String getAuthor()
	{
		return author;
	}
	
	public void setAuthor(String author)
	{
		this.author = author;
	}
	
	public String getEmail()
	{
		return email;
	}
	
	public void setEmail(String email)
	{
		if (emailValidity(email))
		{
			this.email = email;
		}
		else
		{
			System.out.println("Invalid email! Set to empty string.");
			this.email = " ";
		}
	}
	
	public String getGender()
	{
		return gender;
	}
	
	public void setGender(String gender)
	{
		if (gender == "Male" || gender == "Female")
		{
			this.gender = gender;
		}
		else
		{
			System.out.println("Invalid gender! Set to Unknown.");
			this.gender = "Unknown";
		}
	}
	
	boolean emailValidity(String email)
	{
		for (int count = 0; count<email.length(); count++)
		{//e-mails must contain '@'
			if (email.charAt(count) == '@')
			{
				return true;
			}
		}
		return false;
	}
	
	void print()
	{
		System.out.println("AUTHOR\t: " + author);
		System.out.println("GENDER\t: " + gender);
		System.out.println("E-MAIL\t: " + email);
		System.out.println();
	}
}
