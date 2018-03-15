package model;

public class CustomerServiceImpl implements CustomerService {
	private CustomerDAO customerDAO;
	public CustomerServiceImpl(CustomerDAO customerDAO) {
		super();
		this.customerDAO = customerDAO;
	}
	@Override
	public String findCustomerById(String id){
		return customerDAO.findCustomerById(id);
	}
}
