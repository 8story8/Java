package org.kosta.springmvc15.model;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
	@Resource
	private ProductDAO productDAO;
	
	@Override
	public void registerProduct(ProductVO pvo) {
		productDAO.registerProduct(pvo);
	}

	@Override
	public ProductVO findProductById(String id) {
		return productDAO.findProductById(id);
	}

	@Override
	public List<ProductVO> findProductListByType(String type, String keyword) {
		List<ProductVO> list = null;
		
		if(type.equals("findProductListByName")){
			list = productDAO.findProductListByName(keyword);
		}
		else if(type.equals("findProductListByMaker")){
			list = productDAO.findProductListByMaker(keyword);
		}
		
		return list;
	}

}
