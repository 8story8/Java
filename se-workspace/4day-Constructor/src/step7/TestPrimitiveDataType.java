package step7;

public class TestPrimitiveDataType {
	public static void main(String[] args) {
		// 정수형
		byte b1 = 11;
		// 참고 : byte형의 최대값
		System.out.println(Byte.MAX_VALUE);
		// 참고 : byte형의 최소값
		System.out.println(Byte.MIN_VALUE);
		// byte b2 = 130;   // 최대값을 넘으므로 Error
		short s = 130;   // 2byte이므로 가능
		int i = 131;   // 4byte이므로 가능
		long lo = 130;   // 8byte이므로 가능
		
		// 실수형
		// float f = 3.14; // 실수형의 기본형은 double이므로 Error
		float f = 3.14f;   // float형임을 f를 명시해 알려준다.
		double d = 3.14;   // 실수형의 기본형 double 8byte
		
		// 문자형
		// char c = '헐ㅎ';   // char형은 한문자만 가능하므로 Error
		
		// 논리형 boolean형은 오직 true or false만 가능
		boolean flag = true;
		boolean bo = false;
		
		System.out.println("--------------------");
		byte by1 = 1;
		byte by2 = 4;
		// byte by3 = by1 + by2 --> 연산 후에는 정수형의 기본인 int형으로 인식
		// 해결 방안은 by3a의 Type을 int로 변경
		int by3a = by1 + by2;
		// 또 다른 해결 방안은 연산 결과를 byte형으로 Casting
		byte by3b = (byte) (by1+by2);
	}
}
