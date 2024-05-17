package com.library.assessment.repository;

import com.library.assessment.entity.BookEntity;
import com.library.assessment.entity.BorrowerEntity;
import java.util.List;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BookRepository extends JpaRepository<BookEntity, Long> {

  List<BookEntity> findAllByIsbn(String isbn);
  Optional<BookEntity> findByIdAndBorrowerNull(Long id);
  Optional<BookEntity> findByIdAndBorrower_Id(Long id, Long borrowerId);
}
