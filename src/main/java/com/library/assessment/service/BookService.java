package com.library.assessment.service;

import com.library.assessment.dto.BookDto;
import com.library.assessment.entity.BookEntity;
import com.library.assessment.entity.BorrowerEntity;
import java.util.List;

public interface BookService {


  List<BookDto> getAllBooks();

  BookDto register(BookEntity book);

  BookEntity getAvailableBookById(Long bookId);

  BookEntity getBorrowedBookById(Long bookId, Long borrowerId);

}
