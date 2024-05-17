package com.library.assessment.service;

import com.library.assessment.config.LibraryException;
import com.library.assessment.dto.BorrowerDto;
import com.library.assessment.entity.BookEntity;
import com.library.assessment.entity.BorrowerEntity;
import com.library.assessment.mapper.MapperUtils;
import com.library.assessment.repository.BorrowerRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BorrowerServiceImpl implements BorrowerService {

  private final BorrowerRepository repository;
  private final BookService bookService;

  public BorrowerServiceImpl(final BorrowerRepository repository, BookService bookService) {
    this.repository = repository;
    this.bookService = bookService;
  }


  @Transactional
  @Override
  public BorrowerDto registerBorrower(final BorrowerEntity borrower) {
    return MapperUtils.toBorrowerDto(repository.save(borrower));
  }

  @Transactional(rollbackFor = LibraryException.class)
  @Override
  public void borrowBook(Long bookId, Long borrowerId) {
    BookEntity book = bookService.getBookById(bookId);
    var borrower = getBorrowerNotFound(borrowerId);
    borrower.addBook(book);
    repository.save(borrower);
  }

  private BorrowerEntity getBorrowerNotFound(Long borrowerId) {
    return repository.findById(borrowerId)
        .orElseThrow(() -> new LibraryException(HttpStatus.NOT_FOUND.value(), "Borrower not found"));
  }
}
