
package com.semi.product.controller;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.semi.product.model.vo.Product;

/**
 * Servlet implementation class ProductServlet
 */
@WebServlet("/product/productList")
public class ProductServlet extends HttpServlet{
   @Override
   protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
      
      String url = "jdbc:oracle:thin:@localhost:1521:xe"; 
      String sql = "SELECT * FROM PRODUCT";
      
      try {
         Class.forName("oracle.jdbc.driver.OracleDriver");
         Connection con = DriverManager.getConnection(url, "jisunsemi", "0000"); 
         Statement st = con.createStatement();
         ResultSet rs = st.executeQuery(sql);
         
         while(rs.next()) {
            
            Product p = new Product();
            p.setpNum(rs.getInt("p_num"));
			p.setpBigNameEng(rs.getString("p_big_name_eng"));
			p.setpBigNameKor(rs.getString("p_big_name_kor"));
			p.setpName(rs.getString("p_name"));
			p.setpPriceA(rs.getInt("p_price_a"));
			p.setpPriceC(rs.getInt("p_price_c"));
			p.setpDateStart(rs.getDate("p_date_start"));
			p.setpDateFinish(rs.getDate("p_date_finish"));
			p.setpTime(rs.getString("p_time"));
			
           p.setTitleImgPath(rs.getString("title_img_path"));
           p.setpImgPath(rs.getString("p_img_path"));
           p.setpInfo(rs.getString("p_info"));
           p.setpPointInfo(rs.getString("p_point_info"));
           p.setpIntd(rs.getString("p_intd"));
           p.setRuntime(rs.getString("runtime"));
           p.setScheduleImgPath(rs.getString("schedule_img_path"));
           p.setPrecaution(rs.getString("precaution"));
           p.setpMapName(rs.getString("p_map_name"));
           p.setpMap(rs.getString("p_map"));
           p.setpScore(rs.getInt("p_score"));
           p.setPartnerNum(rs.getInt("partner_num"));
               
               request.setAttribute("p", p);
               

         }
         
         rs.close();
         st.close();
         con.close();
         
      } catch (ClassNotFoundException e) {
         e.printStackTrace();
      } catch (SQLException e) {
         e.printStackTrace();
      }
      
      RequestDispatcher dispatcher = request.getRequestDispatcher("/views/product/product.jsp"); 
      dispatcher.forward(request, response);

   }
}