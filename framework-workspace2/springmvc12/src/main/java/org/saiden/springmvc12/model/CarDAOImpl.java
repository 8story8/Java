package org.saiden.springmvc12.model;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class CarDAOImpl implements CarDAO{
	@Resource
	private SqlSessionTemplate template;
	
	@Override
	public int getTotalCarCount() {
		return template.selectOne("car.getTotalCarCount");
	}

	@Override
	public List<CarVO> getAllCarList() {
		return template.selectList("car.getAllCarList");
	}
	
}
