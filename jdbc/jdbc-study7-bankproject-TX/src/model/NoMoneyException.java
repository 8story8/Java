package model;

public class NoMoneyException extends Exception 
{
	private static final long serialVersionUID = 775006520188250399L;

	public NoMoneyException(String message) 
	{
		super(message);
	}
}
