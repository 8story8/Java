package step4;

import java.util.Random;
import java.util.TreeSet;

public class LottoService 
{	
	public TreeSet<Integer> createLottoNum()
	{
		// 중복을 허용하지 않고 정렬되기 위해 TreeSet을 생성해서 이용
		TreeSet<Integer> ts = new TreeSet<Integer>();
		
		// 임의의 수를 발생시키기 위해 Random을 생성해서 이용
		Random r = new Random();
		
		// 중복된 임의의 수가 반환될 수 있으므로 set의 size가 6보다 작을 동안 계속 수행하도록 while문을 이용
		while(ts.size() < 6)
		{
			ts.add(r.nextInt(45) + 1);   // 0 ~ 44까지 임의의 수가 반환되므로 +1해서 set에 추가
		}
		
		return ts;
	}
}
