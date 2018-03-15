package step11;

import java.util.Scanner;

public class TestArray1 {

	public static void main(String[] args) {
		int[] ages;
		ages = new int[3];   // length 3 硅凯 按眉 积己
		
		Scanner sc = new Scanner(System.in);
		
	    System.out.println(ages.length);
	  
	    for(int i = 0; i < ages.length; i++)
	    {
	    	ages[i] = sc.nextInt();
	    }
	    
	    for(int i = 0; i < ages.length; i++)
	    {
	    	System.out.println("ages[" + i + "] : " + ages[i]);
	    }
	    // System.out.println(ages[3]);   // exception 惯积
	}

}
