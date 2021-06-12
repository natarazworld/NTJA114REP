package com.nt.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import javax.naming.InitialContext;
import javax.sql.DataSource;

import com.nt.bo.BookDetailsBO;

public class BookStoreDAOImpl implements IBookStoreDAO {
	 private static final String  GET_BOOKS_BY_CATEGORY="SELECT BOOKID,BOOKNAME,CATEGORY,AUTHOR,PRICE,STATUS FROM  BOOKS_INFO  WHERE CATEGORY=? ";
	
	private Connection  getPooledJdbcConnection() throws Exception{
		 //get DataSource obj from Jndi registry
		InitialContext ic=new InitialContext();
		DataSource ds=(DataSource)ic.lookup("java:/comp/env/DsJndi");
		//get Pooled jdbc con object
		Connection con=ds.getConnection();
		return con;
	}

	@Override
	public List<BookDetailsBO> getBooksByCategory(String category) throws Exception {
		List<BookDetailsBO> listBO=null;
		try(  //get Pooled JDBC con
				Connection con=getPooledJdbcConnection();
				 //get PreparedSatement obj
				PreparedStatement ps=con.prepareStatement(GET_BOOKS_BY_CATEGORY);){
				//set query param value
			ps.setString(1,category);
			listBO=new ArrayList();
			//execute query
				try ( ResultSet rs=ps.executeQuery();	){
			             //copy Result Object records ListBO 
					 while(rs.next()) {
						 BookDetailsBO bo=new BookDetailsBO();
						 bo.setBookId(rs.getInt(1));
						 bo.setBookName(rs.getString(2));
						 bo.setCategory(rs.getString(3));
						 bo.setAuthor(rs.getString(4));
						 bo.setPrice(rs.getFloat(5));
						 bo.setStatus(rs.getString(6));
						 listBO.add(bo);
						 }//while
				   }//try2
		}//try1
		catch(SQLException se) {
			se.printStackTrace();
			throw se;
		}
		catch(Exception e) {
			e.printStackTrace();
			throw e;
		}
		return listBO;
	}//method
}//class
