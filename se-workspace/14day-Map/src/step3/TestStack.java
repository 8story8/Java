package step3;

import java.util.Stack;

public class TestStack 
{
	public static void main(String[] args) 
	{
		Stack<String> stack = new Stack<String>();
		stack.push("김규익");
		stack.push("설현");
		stack.push("아이유");
		System.out.println(stack);
		/*System.out.println(s.pop());
		System.out.println(s.pop());
		System.out.println(s.pop());*/
		// Stack은 Last in First Out
		System.out.println(stack);
		while(stack.isEmpty() == false)
		{
			System.out.println(stack.pop());
		}
		System.out.println(stack);
	}
}
