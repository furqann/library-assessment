package com.library.assessment.mapper;

import com.library.assessment.dto.BookDto;
import com.library.assessment.dto.BorrowerDto;
import com.library.assessment.entity.BookEntity;
import com.library.assessment.entity.BorrowerEntity;

public final class MapperUtils {

  /**
   * Converts Book to BookDto
   * @param book
   * @return BookDto
   */
  public static BookDto toBookDto(final BookEntity book) {
    return new BookDto(book.getId(), book.getTitle(), book.getAuthor(), book.getIsbn());
  }

  /**
   * Converts BorrowerEntity to BorrowerDto
   * @param borrower
   * @return BorrowerDto
   */
  public static BorrowerDto toBorrowerDto(BorrowerEntity borrower) {
    return new BorrowerDto(borrower.getId(), borrower.getName(), borrower.getEmail());
  }
}
