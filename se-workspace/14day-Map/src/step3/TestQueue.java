package step3;

import java.util.LinkedList;
import java.util.Queue;

public class TestQueue 
{
	public static void main(String[] args) 
	{
		Queue<String> queue = new LinkedList<String>();
		queue.add("규익 오빠 나 설현이야");
		queue.add("어디야 뿌잉뿌잉");
		queue.add("대답안해!!!");
		queue.add("헤어져~");
		while(queue.isEmpty() == false)
		{
			System.out.println(queue.poll());
		}
		// Queue는 First In First Out
	}
}
