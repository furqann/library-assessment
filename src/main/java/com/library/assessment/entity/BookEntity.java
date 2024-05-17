package com.library.assessment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotBlank;
import java.util.Objects;

@Entity
@Table(name = "books")
public class BookEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @NotBlank(message = "title cannot be empty")
  @Column(name = "title")
  private String title;

  @NotBlank(message = "author cannot be empty")
  @Column(name = "author")
  private String author;

  @NotBlank(message = "isbn cannot be empty")
  @Column(name = "isbn")
  private String isbn;

  /**
   * Context: if borrower_id column is null, that means book can be borrowed.
   */
  @ManyToOne(fetch = FetchType.LAZY)
  @JoinColumn(name = "borrower_id")
  private BorrowerEntity borrower;

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getTitle() {
    return title;
  }

  public void setTitle(String title) {
    this.title = title;
  }

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public String getIsbn() {
    return isbn;
  }

  public void setIsbn(String isbn) {
    this.isbn = isbn;
  }

  public BorrowerEntity getBorrower() {
    return borrower;
  }

  public void setBorrower(BorrowerEntity borrower) {
    this.borrower = borrower;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) {
      return true;
    }
    if (!(o instanceof BookEntity book)) {
      return false;
    }
    return Objects.equals(title, book.title) && Objects.equals(author, book.author)
        && Objects.equals(isbn, book.isbn);
  }

  @Override
  public int hashCode() {
    return Objects.hash(title, author, isbn);
  }
}
