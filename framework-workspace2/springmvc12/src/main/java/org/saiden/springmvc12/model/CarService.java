package org.saiden.springmvc12.model;

import java.util.List;

public interface CarService {
	int getTotalCarCount();
	List<CarVO> getAllCarList();
}
