package com.capgemini.takehome.service;

import com.capgemini.takehome.bean.Product;
import com.capgemini.takehome.dao.IProductDAO;
import com.capgemini.takehome.dao.ProductDAO;
import com.capgemini.takehome.util.ProductNotFoundException;

public class ProductService implements IProductService {
	private static IProductDAO productDao = new ProductDAO();
	public static IProductDAO getProductDao()
	{
		return productDao;
	}
	
	
	@Override
	public Product getProductDetails(int productCode) throws ProductNotFoundException {
		Product product = getProductDao().getProductDetails(productCode);
		if(product == null)
		{
			throw new ProductNotFoundException("Sorry ! The Product Code\'"+productCode+"\' is not available.");
		}
		return product;
	}

}
