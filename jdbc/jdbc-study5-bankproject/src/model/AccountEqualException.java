package model;

public class AccountEqualException extends Exception 
{
	private static final long serialVersionUID = -783856366985280233L;

	public AccountEqualException(String message) 
	{
		super(message);
	}
}
