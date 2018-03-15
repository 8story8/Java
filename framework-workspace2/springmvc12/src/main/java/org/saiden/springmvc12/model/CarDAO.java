package org.saiden.springmvc12.model;

import java.util.List;

public interface CarDAO {
	int getTotalCarCount();
	List<CarVO> getAllCarList();
}
