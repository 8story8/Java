package step4;

import java.util.TreeSet;

public class TestLottoService 
{
	public static void main(String[] args) 
	{
		LottoService service = new LottoService();
		TreeSet<Integer> lottoNumSet = service.createLottoNum();
		
		System.out.println(lottoNumSet);
	}
}
