package com.cg.Student.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


	@ResponseStatus(HttpStatus.NOT_FOUND)
public class StudentnotfoundException extends RuntimeException {

  public StudentnotfoundException(String exception) {
    super(exception);
  }
}
