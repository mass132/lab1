package com.capgemini.takehome.service;

import com.capgemini.takehome.bean.Product;
import com.capgemini.takehome.util.InvalidProductCodeException;
import com.capgemini.takehome.util.ProductNotFoundException;

public interface IProductService {
	/* getProductDetails - Returns product if found in the hashmap else null
	 * @param productCode int datatype 
	 * @return Product data type
	 */
	Product getProductDetails(int productCode) throws InvalidProductCodeException, ProductNotFoundException;

}
