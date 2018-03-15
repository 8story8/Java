package model;

public class InsufficientBalanceException extends Exception 
{
	private static final long serialVersionUID = 3958535503188233576L;

	public InsufficientBalanceException(String message) 
	{
		super(message);
	}
}
