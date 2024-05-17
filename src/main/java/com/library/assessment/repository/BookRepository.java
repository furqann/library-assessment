package com.library.assessment.repository;

import com.library.assessment.entity.BookEntity;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

  List<BookEntity> findAllByIsbn(String isbn);
}
