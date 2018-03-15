package org.saiden.springmvc21.model;

import org.springframework.web.multipart.MultipartFile;

public class ProductVO {
	private String name;
	private MultipartFile uploadFile;

	public ProductVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ProductVO(String name, MultipartFile uploadFile) {
		super();
		this.name = name;
		this.uploadFile = uploadFile;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public MultipartFile getUploadFile() {
		return uploadFile;
	}

	public void setUploadFile(MultipartFile uploadFile) {
		this.uploadFile = uploadFile;
	}

	@Override
	public String toString() {
		return "ProductVO [name=" + name + ", uploadFile=" + uploadFile + "]";
	}
}
