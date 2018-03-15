package step5;

public class ProductService {

	public ProductVO findProductVOByName(ProductVO pa[], String string) {
		
		ProductVO pvo = null;
		
		for (int i = 0; i < pa.length; i++) {
			if (pa[i].getName().equals(string)) {
				pvo = pa[i];
				break;
			}
		}
		return pvo;
	}

	public ProductVO[] findProductListByMaker(ProductVO[] pa, String string) {
		
		int count = 0;
		
		for (int i = 0; i < pa.length; i++) 
		{
			if (pa[i].getMaker().equals(string)) 
			{
				count++;
			}
		}
		
		ProductVO[] reList = null;
		
		if(count > 0)
		{
			reList = new ProductVO[count];
			int index = 0;
			
			for (int i = 0; i < pa.length; i++) 
			{
				if (pa[i].getMaker().equals(string)) 
				{
					reList[index++] = pa[i];
				}
			}
		}
		return reList;
	}
}
