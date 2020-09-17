package com.semi.product.model.dao;

import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;
import java.util.Properties;

import com.semi.product.model.vo.Product;

public class ProductDao {

	private Properties prop=new Properties();
	public ProductDao() {
		try {
			String path=ProductDao.class.getResource("/sql/product/product_sql.properties").getPath();
			prop.load(new FileReader(path));
		}catch(IOException e) {
			e.printStackTrace();
		}
		
	}
	
	public List<Product> filterProductList(Connection conn,Product p){
		PreparedStatement pstmt=null;
		ResultSet rs=null;
		List<Product> list=new ArrayList();
		
		try {
			pstmt=conn.prepareStatement(prop.getProperty(""));
			pstmt.setString(parameterIndex, x);
		}
		
	}
	
	
	
	
}
