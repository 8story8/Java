package com.example.kosta_inst.step12_userdefineadapter2;

public class FoodVO {
	private String name;
	private int imgId;
	private String info;
	public FoodVO() {
		super();		
	}
	public FoodVO(String name, int imgId, String info) {
		super();
		this.name = name;
		this.imgId = imgId;
		this.info = info;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getImgId() {
		return imgId;
	}
	public void setImgId(int imgId) {
		this.imgId = imgId;
	}
	public String getInfo() {
		return info;
	}
	public void setInfo(String info) {
		this.info = info;
	}
	@Override
	public String toString() {
		return "FoodVO [name=" + name + ", imgId=" + imgId + ", info=" + info
				+ "]";
	}
	
}
