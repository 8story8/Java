package step4;

class Car
{
	int count;   // Instance Variable : Heap ���� ����, ��ü �����ø��� ���� ������ ����
	static int sCount;   // Class Variable : Method ���� ����, class loading�ÿ� �� �� ���� �����Ǿ� ����
	Car()
	{
		count++;
		sCount++;
	}
}

/*
Instance Variable ������ static ���� ������ ����� � ���̸� ���̴� ���� ���� ����
*/

public class TestStatic3 {

	public static void main(String[] args) {
		Car c1 = new Car();
		System.out.println(c1.count);
		System.out.println(Car.sCount);
		Car c2 = new Car();
		System.out.println(c2.count);
		System.out.println(Car.sCount);
		Car c3 = new Car();
		System.out.println(c3.count);
		System.out.println(Car.sCount);
	}
}
