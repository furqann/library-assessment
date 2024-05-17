package com.library.assessment.service;

import com.library.assessment.dto.BorrowerDto;
import com.library.assessment.entity.BorrowerEntity;
import com.library.assessment.mapper.MapperUtils;
import com.library.assessment.repository.BorrowerRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class BorrowerServiceImpl implements BorrowerService {

  private final BorrowerRepository repository;

  public BorrowerServiceImpl(final BorrowerRepository repository) {
    this.repository = repository;
  }


  @Transactional
  @Override
  public BorrowerDto registerBorrower(final BorrowerEntity borrower) {
    return MapperUtils.toBorrowerDto(repository.save(borrower));
  }
}
