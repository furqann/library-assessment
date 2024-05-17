package com.library.assessment.service;

import com.library.assessment.config.LibraryException;
import com.library.assessment.dto.BookDto;
import com.library.assessment.entity.BookEntity;
import com.library.assessment.mapper.MapperUtils;
import com.library.assessment.repository.BookRepository;
import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BookServiceImpl implements BookService {

  private final BookRepository bookRepository;

  public BookServiceImpl(BookRepository bookRepository) {
    this.bookRepository = bookRepository;
  }


  @Transactional(readOnly = true)
  @Override
  public List<BookDto> getAllBooks() {
    return bookRepository.findAll()
        .stream()
        .map(MapperUtils::toBookDto)
        .toList();
  }

  @Transactional(rollbackFor = LibraryException.class)
  @Override
  public BookDto register(final BookEntity book) {
    var books = bookRepository.findAllByIsbn(book.getIsbn());
    if (books != null && !books.isEmpty()) {
      books.forEach(b -> {
            if (!b.equals(book)) {
              throw new LibraryException(HttpStatus.BAD_REQUEST.value(), "Isbn already exists with different "
                  + "details");
            }
          }
      );
    }
    return MapperUtils.toBookDto(bookRepository.save(book));
  }
}
