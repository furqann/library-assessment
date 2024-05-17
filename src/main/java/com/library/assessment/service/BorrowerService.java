package com.library.assessment.service;

import com.library.assessment.dto.BorrowerDto;
import com.library.assessment.entity.BorrowerEntity;

public interface BorrowerService {

  BorrowerDto registerBorrower(BorrowerEntity borrower);
}
