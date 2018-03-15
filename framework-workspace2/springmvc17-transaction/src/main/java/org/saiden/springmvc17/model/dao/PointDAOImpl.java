package org.saiden.springmvc17.model.dao;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.saiden.springmvc17.model.vo.PointVO;
import org.springframework.stereotype.Repository;

@Repository
public class PointDAOImpl implements PointDAO {
	@Resource
	private SqlSessionTemplate template;
	
	@Override
	public PointVO findPointById(String id) {
		return template.selectOne("point.findPointById", id);
	}

	@Override
	public void register(PointVO pvo) {
		template.insert("point.register", pvo);
	}

}
