package com.nt.service;

import java.util.List;

import com.nt.dto.BookDetailsDTO;

public interface IBookStoreMgmtService {
    public  List<BookDetailsDTO>  fetchBooksByCategory(String category)throws Exception;
}
