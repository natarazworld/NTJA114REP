package com.nt.dao;

import java.util.List;

import com.nt.bo.BookDetailsBO;

public interface IBookStoreDAO {
	
	public  List<BookDetailsBO>  getBooksByCategory(String category)throws Exception;

}
