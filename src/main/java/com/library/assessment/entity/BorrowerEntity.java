package com.library.assessment.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "borrowers")
public class BorrowerEntity {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private long id;

  @NotBlank(message = "name cannot be empty")
  @Column(name = "name")
  private String name;

  //Email can be made unique to prevent duplication of borrowers
  @NotBlank(message = "email cannot be empty")
  @Email(message = "email address is not valid")
  @Column(name = "email")
  private String email;

  @OneToMany(fetch = FetchType.LAZY, mappedBy = "borrower")
  private List<BookEntity> books = new ArrayList<>();

  public long getId() {
    return id;
  }

  public void setId(long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public List<BookEntity> getBooks() {
    return books;
  }

  public void addBook(BookEntity book) {
    book.setBorrower(this);
    this.books.add(book);
  }

  public void removeBook(BookEntity book) {
    book.setBorrower(null);
    this.books.removeIf( b -> b.getId() == book.getId());
  }
}
