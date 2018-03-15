package model;

public class CustomerDAOImpl implements CustomerDAO {
	@Override
	public String findCustomerById(String id){
		if(id.equals("java"))
			return "임경수 판교";
		else
			return null;
	}
}
