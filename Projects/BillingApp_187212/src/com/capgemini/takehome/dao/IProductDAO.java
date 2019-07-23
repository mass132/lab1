package com.capgemini.takehome.dao;

import com.capgemini.takehome.bean.Product;

public interface IProductDAO {
	/* getProductDetails - Returns product if found in the hashmap else null
	 * @param productCode int datatype 
	 * @return Product data type
	 */
	Product getProductDetails(int productCode);

}
