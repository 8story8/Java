package model;

import java.util.List;

public interface ProductDAO {
	public void register(ProductVO vo);
	public ProductVO findProductById(String id);
	public List<ProductVO> findProductByName(String name);
	public List<ProductVO> findProductByMaker(String maker);
}
