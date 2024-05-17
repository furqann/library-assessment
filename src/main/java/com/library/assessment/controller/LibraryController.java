package com.library.assessment.controller;

import com.library.assessment.dto.BookDto;
import com.library.assessment.dto.BorrowerDto;
import com.library.assessment.entity.BookEntity;
import com.library.assessment.entity.BorrowerEntity;
import com.library.assessment.model.SuccessMessage;
import com.library.assessment.service.BookService;
import com.library.assessment.service.BorrowerService;
import java.net.URI;
import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/library")
public class LibraryController {

  private final BookService bookService;
  private final BorrowerService borrowerService;

  public LibraryController(final BookService bookService, BorrowerService borrowerService) {
    this.bookService = bookService;
    this.borrowerService = borrowerService;
  }

  @GetMapping("/books/all")
  public ResponseEntity<List<BookDto>> getAllBooks() {
    return ResponseEntity.ok(bookService.getAllBooks());
  }

  @PostMapping("/books/register")
  public ResponseEntity<BookDto> registerBook(@RequestBody BookEntity book) {
    BookDto savedBook = bookService.register(book);
    return ResponseEntity.created(URI.create("api/v1/library/books/register/" + savedBook.id())).body(savedBook);
  }

  @PostMapping("/borrower/register")
  public ResponseEntity<BorrowerDto> registerBorrower(@RequestBody BorrowerEntity borrower) {
    BorrowerDto registeredBorrower = borrowerService.registerBorrower(borrower);
    return ResponseEntity.created(URI.create("api/v1/library/borrower/register/" + registeredBorrower.id()))
        .body(registeredBorrower);
  }

  @PostMapping("/borrow/books/{bookId}/borrowers/{borrowerId}")
  public ResponseEntity<SuccessMessage> borrowBook(@PathVariable Long bookId, @PathVariable Long borrowerId){
    borrowerService.borrowBook(bookId, borrowerId);
    return ResponseEntity.ok(new SuccessMessage("Successfully borrowed a book"));
  }

  @PostMapping("/return/books/{bookId}/borrowers/{borrowerId}")
  public ResponseEntity<SuccessMessage> returnBook(@PathVariable Long bookId, @PathVariable Long borrowerId){
    borrowerService.returnBook(bookId, borrowerId);
    return ResponseEntity.ok(new SuccessMessage("Book is successfully returned"));
  }
}
