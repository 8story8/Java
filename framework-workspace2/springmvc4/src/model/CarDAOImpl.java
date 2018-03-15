package model;

public class CarDAOImpl implements CarDAO {
	@Override
	public void register(CarDTO dto){
		System.out.println(dto+" insert ok~");
	}
}
