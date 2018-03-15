package step3;

import step2.Airplane;
import step2.Bird;
import step2.Eagle;
import step2.Helicopter;
import step2.SuperMan;

public class TestInterface3 
{
	public static void main(String[] args) 
	{
		FlyerService service = new FlyerService(10);
		service.addFlyer(new Airplane());
		service.addFlyer(new Helicopter());
		service.addFlyer(new Bird());
		service.addFlyer(new Eagle());
		service.addFlyer(new SuperMan());
		service.addFlyer(new IronMan());
		
		// service.executeFlyerAll();		// 비행기가 날다.
										     	// 헬리콥터가 날다.
										     	// 새가 날다.
										    	// 독수리가 날다.
									        	// 슈퍼맨이 날다.
										    	// 아이언맨이 날다.
		service.executeFighterAll();
	}
}
