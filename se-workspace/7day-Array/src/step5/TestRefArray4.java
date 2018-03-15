package step5;

public class TestRefArray4 {

	public static void main(String[] args) {	
		
		ProductVO[] pa = new ProductVO[3];
		
		pa[0] = new ProductVO("iPhone 7", "Apple", 120);
		pa[1] = new ProductVO("Galaxy S4", "Samsung", 20);
		pa[2] = new ProductVO("iPhone 5", "Apple", 60);
		
		ProductService service = new ProductService();
		ProductVO vo = service.findProductVOByName(pa, "Galaxy S4");
		
		if(vo != null)
		{
			System.out.println(vo.getName() + "\t" + vo.getPrice());
		}
		else
		{
			System.out.println("정보 없음!");
		}
		
		System.out.println("********************");
		
		ProductVO[] reList = service.findProductListByMaker(pa, "Apple");
		
		for(int i = 0; i < reList.length; i++)
		{
			System.out.println(reList[i].getName() + "\t" + reList[i].getPrice());
		}
	}
}
