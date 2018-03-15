package model;

import java.util.ArrayList;

public class ListVO {
	private ArrayList<CarVO> carList;
	private PagingBean pagingBean;
	
	public ListVO() {
		super();
		// TODO Auto-generated constructor stub
	}

	public ListVO(ArrayList<CarVO> carList, PagingBean pagingBean) {
		super();
		this.carList = carList;
		this.pagingBean = pagingBean;
	}

	public ArrayList<CarVO> getCarList() {
		return carList;
	}

	public void setCarList(ArrayList<CarVO> carList) {
		this.carList = carList;
	}

	public PagingBean getPagingBean() {
		return pagingBean;
	}
	
	public void setPagingBean(PagingBean pagingBean) {
		this.pagingBean = pagingBean;
	}

	@Override
	public String toString() {
		return "ListVO [carList=" + carList + ", pagingBean=" + pagingBean + "]";
	}
	
	
}
