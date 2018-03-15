package step1;

abstract class Animal
{
	Animal()
	{
		System.out.println("Animal 何葛 积己");
	}
}

class Person extends Animal
{
	Person()
	{
		super();
	}
}

public class TestAbstractReview 
{
	public static void main(String[] args)
	{
		// new Animal();   // 流立 按眉 积己 阂啊
		new Person();
	}
}
