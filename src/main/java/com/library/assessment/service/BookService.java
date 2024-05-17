package com.library.assessment.service;

import com.library.assessment.dto.BookDto;
import com.library.assessment.entity.BookEntity;
import java.util.List;

public interface BookService {


  List<BookDto> getAllBooks();

  BookDto register(BookEntity book);
}
