package step6;

public class Student {
	
	private String name;
	private String stuId;
	private SmartPhone smartPhone;
	
	public Student(String name, String stuId, SmartPhone smartPhone)
	{
		this.name = name;
		this.stuId = stuId;
		this.smartPhone = smartPhone;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return this.name;
	}

	public void setStuId(String stuId) {
		this.stuId = stuId;
	}

	public String getStuId() {
		return this.stuId;
	}
	
	public void setSmartPhone(SmartPhone smartPhone)
	{
		this.smartPhone = smartPhone;
	}
	
	public SmartPhone getSmartPhone()
	{
		return this.smartPhone;
	}
}
