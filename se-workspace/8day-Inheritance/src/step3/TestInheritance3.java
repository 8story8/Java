package step3;

import step3.vo.Bank;;

class KostaBank
{
	public void accessTest()
	{
		Bank b = new Bank();
		// 다른 패키지에서 접근할 수 있는 것은 public외에는 없다.
		// KostaBank2에서 다시 확인
		b.publicTest();
	}
}

class KostaBank2 extends Bank
{
	public void accessTest()
	{
		// KostaBank와는 다르게 Bank와 상속 관계에 있다.
		// 이 경우 protected도 접근 가능
		publicTest();
		protectedTest();
	}
}

public class TestInheritance3 {
	// Access Modifier Test Example

}
