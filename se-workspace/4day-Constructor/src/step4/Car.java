package step4;   // Package : 디렉토리별 분류

public class Car {   // Class : 객체 생성
	
	private String model;   // Instance Variable : 객체 속성 정보 저장

	// Constructor : 객체 생성시 필요한 초기 작업 수행, 회원 정보 등록
	public Car(String model){   // model -> Local Variable
		this.model = model;   // 전달받은 정보를 객체 속성에 저장
	}
	
	public void setModel(String model)   // method setter : 객체 속성 정보 할당, 회원 정보 수정
	{
		this.model = model;
	}
	
	public String getModel()   // method getter : 객체 속성 정보 반환 
	{
		return this.model;   // = return model;
	}

}
