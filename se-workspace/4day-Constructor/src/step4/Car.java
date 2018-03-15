package step4;   // Package : ���丮�� �з�

public class Car {   // Class : ��ü ����
	
	private String model;   // Instance Variable : ��ü �Ӽ� ���� ����

	// Constructor : ��ü ������ �ʿ��� �ʱ� �۾� ����, ȸ�� ���� ���
	public Car(String model){   // model -> Local Variable
		this.model = model;   // ���޹��� ������ ��ü �Ӽ��� ����
	}
	
	public void setModel(String model)   // method setter : ��ü �Ӽ� ���� �Ҵ�, ȸ�� ���� ����
	{
		this.model = model;
	}
	
	public String getModel()   // method getter : ��ü �Ӽ� ���� ��ȯ 
	{
		return this.model;   // = return model;
	}

}
