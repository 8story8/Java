package org.kosta.springmvc15.model;

import java.util.List;

import javax.annotation.Resource;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.stereotype.Repository;

@Repository
public class ProductDAOImpl implements ProductDAO {
	@Resource
	private SqlSessionTemplate template;
	
	@Override
	public void registerProduct(ProductVO pvo) {
		template.insert("myproduct.registerProduct", pvo);
	}

	@Override
	public ProductVO findProductById(String id) {
		return template.selectOne("myproduct.findProductById", id);
	}

	@Override
	public List<ProductVO> findProductListByName(String name) {
		return template.selectList("myproduct.findProductListByName", name);
	}

	@Override
	public List<ProductVO> findProductListByMaker(String maker) {
		return template.selectList("myproduct.findProductListByMaker", maker);
	}

}
