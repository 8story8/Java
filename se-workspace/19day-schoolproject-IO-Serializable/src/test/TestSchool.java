package test;

import school.ConsoleUI;
import school.DuplicateTelException;

public class TestSchool
{
	public static void main(String[] args)
	{
		try 
		{
			new ConsoleUI().execute();
		} 
		catch (DuplicateTelException de) 
		{
			de.printStackTrace();
		}
	}
}