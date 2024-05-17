package com.library.assessment.model;

import java.util.List;

public record ErrorMessage(int httpStatus, List<String> message) {

}
