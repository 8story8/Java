package model;

import org.mybatis.spring.SqlSessionTemplate;

public class CustomerDAOImpl implements CustomerDAO {
	private SqlSessionTemplate template;
	public CustomerDAOImpl(SqlSessionTemplate template) {
		super();
		this.template = template;
	}
	@Override
	public CustomerVO findCustomerById(String id){
		return template.selectOne("customer.findCustomerById",id);
	}
}
