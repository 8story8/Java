package org.kosta.springmvc15.model;

import java.util.List;

public interface ProductService {
	public void registerProduct(ProductVO pvo);
	public ProductVO findProductById(String id);
	public List<ProductVO> findProductListByType(String type, String keyword);
}
