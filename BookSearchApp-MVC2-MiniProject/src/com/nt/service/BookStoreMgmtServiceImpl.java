package com.nt.service;

import java.util.ArrayList;
import java.util.List;

import com.nt.bo.BookDetailsBO;
import com.nt.dao.BookStoreDAOImpl;
import com.nt.dao.IBookStoreDAO;
import com.nt.dto.BookDetailsDTO;

public class BookStoreMgmtServiceImpl implements IBookStoreMgmtService {
  private IBookStoreDAO  dao;
  
  public BookStoreMgmtServiceImpl() {
	 dao=new BookStoreDAOImpl();
}
	
	@Override
	public List<BookDetailsDTO> fetchBooksByCategory(String category) throws Exception {
		//use DAO
		List<BookDetailsBO> listBO=dao.getBooksByCategory(category);
		//convert listBO to listDTO
		List<BookDetailsDTO> listDTO=new ArrayList();
		listBO.forEach(bo->{
		   BookDetailsDTO  dto=new BookDetailsDTO();
		   dto.setBookId(bo.getBookId());
		   dto.setBookName(bo.getBookName());
		   dto.setAuthor(bo.getAuthor());
		   dto.setPrice(bo.getPrice());
		   dto.setCategory(bo.getCategory());
		   dto.setStatus(bo.getStatus());
		   dto.setSerialNo(listDTO.size()+1);
		  listDTO.add(dto);
		});
		return listDTO;
	}//method
}//class
