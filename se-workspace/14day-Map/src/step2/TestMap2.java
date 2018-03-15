package step2;


import java.util.Collection;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Set;

public class TestMap2 
{
	public static void main(String[] args) 
	{
		LinkedHashMap<String, ProductVO> lhm = new LinkedHashMap<String, ProductVO>();
		ProductVO vo1 = new ProductVO("iPhone 7", "Apple", 120);
		ProductVO vo2 = new ProductVO("Galaxy S7", "Samsung", 140);
		
		lhm.put("1", vo1);
		lhm.put("2", vo2);
		
		System.out.println(lhm);
		
		System.out.println("********************");
		
		System.out.println(lhm.get("2").getName());
		
		System.out.println("********************");
		
		// lhm의 key들을 열거, 출력
		Set<String> s = lhm.keySet();
		Iterator<String> it1 = s.iterator();
		
		while(it1.hasNext())
		{
			System.out.println(it1.next());
		}
		
		System.out.println("********************");
		
		// lhm의 value들을 반환받아 상품 name만 열거
		Collection<ProductVO> c = lhm.values();
		Iterator<ProductVO> it2 = c.iterator();
		
		/*
		while(it2.hasNext())
		{
			System.out.println(it2.next().getName());
		}
		*/
		
		System.out.println(it2.hasNext());
		System.out.println(it2.hasNext());
		System.out.println(it2.hasNext());
		System.out.println(it2.hasNext());
		
		System.out.println("********************");
		
		System.out.println(it2.next());
		System.out.println(it2.next());
		
		System.out.println("********************");
		
		System.out.println(it2.hasNext());
	}
}
