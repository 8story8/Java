package model;

import java.util.List;

import org.mybatis.spring.SqlSessionTemplate;

public class ProductDAOImpl implements ProductDAO{
	private SqlSessionTemplate sqlSessionTemplate;

	public ProductDAOImpl(SqlSessionTemplate sqlSessionTemplate) {
		this.sqlSessionTemplate = sqlSessionTemplate;
		System.out.println(sqlSessionTemplate+" injection");
	}
	public void register(ProductVO vo) {
		sqlSessionTemplate.insert("product.register",vo);	
		
	}
	@Override
	public ProductVO findProductById(String id)  {
		return sqlSessionTemplate.selectOne("product.findProductById", id);
	}
	@Override
	public List<ProductVO> findProductByName(String name)  {
		return sqlSessionTemplate.selectList("product.findProductByName", name);
	}
	@Override
	public List<ProductVO> findProductByMaker(String maker)  {
		return sqlSessionTemplate.selectList("product.findProductByMaker", maker);
	}
}








