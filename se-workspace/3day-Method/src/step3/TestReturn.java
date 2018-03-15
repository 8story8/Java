package step3;

public class TestReturn {
	public static void main(String[] args) {
		Person p = new Person();
		System.out.println("리턴값 : " + p.getNickName());
		
		String data = "리턴값 : " + p.getNickName();
		System.out.println(data);
	}
}
