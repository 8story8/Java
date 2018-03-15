package step5;

public class Person {
	private String name;
	
	Person(String name)
	{
		this.name = name;
	}
	
	public String getName()
	{
		return this.name;
	}

	public void tour() {
		// 렌트카를 이용한다. : use a
		RentCar rc = new RentCar("소나타", 10);
		System.out.println(rc.getModel() + "를 타고 " + name + "와 여행하다.");
		// 이 메서드가 종료되면 RentCar 객체는 Garbage Collection 대상
	}
}
