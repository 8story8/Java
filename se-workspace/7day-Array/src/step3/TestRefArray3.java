package step3;

public class TestRefArray3 {

	public static void main(String[] args) {
		
		ItemVO[] items = {new ItemVO("Galaxy S7", 90), new ItemVO("G6", 120), new ItemVO("iPhone 7", 140)};
		
		ItemService service = new ItemService();
		
		service.printAll(items);
		/*
		Galaxy S7 : 90
		G6 : 120
		iPhone 7 : 140
		 */
		
		// price가 120인 아이템의 model 출력
		service.printModelByPrice(items, 120);   // G6
		
		service.printMaxPrice(items);   // 140
	}
}
