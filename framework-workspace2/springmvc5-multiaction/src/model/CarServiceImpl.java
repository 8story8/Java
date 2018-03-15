package model;

public class CarServiceImpl implements CarService {
	private CarDAO carDAO;	
	public CarServiceImpl(CarDAO carDAO) {
		super();
		this.carDAO = carDAO;
	}
	@Override
	public void register(CarDTO dto){
		carDAO.register(dto);
	}
	@Override
	public CarDTO findCarDTO(){
		return carDAO.findCarDTO();
	}
}











