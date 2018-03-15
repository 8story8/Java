package model;

public class AccountNotFoundException extends Exception 
{
	private static final long serialVersionUID = -8850404338345723717L;

	public AccountNotFoundException(String message) 
	{
		super(message);
	}
}
