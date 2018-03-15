package org.saiden.springmvc12.model;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class CarServiceImpl implements CarService{
	@Resource
	private CarDAO carDAO;
	
	@Override
	public int getTotalCarCount() {
		return carDAO.getTotalCarCount();
	}

	@Override
	public List<CarVO> getAllCarList() {
		return carDAO.getAllCarList();
	}
	
}
