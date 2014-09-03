package org.zulvani.smht.controller;

import org.springframework.http.HttpStatus;
import org.springframework.transaction.CannotCreateTransactionException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.servlet.ModelAndView;
import org.zulvani.smht.util.JsonError;

public class BasicController {

  @ExceptionHandler(CannotCreateTransactionException.class)
  @ResponseStatus(HttpStatus.SERVICE_UNAVAILABLE)
  public ModelAndView handleExceptions(CannotCreateTransactionException ex) {
    return new JsonError(ex.getMessage()).asModelAndView();
  }

  @ExceptionHandler(Exception.class)
  @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
  public ModelAndView handleAllExceptions(Exception ex) {
    return new JsonError(ex.getMessage()).asModelAndView();
  }
}
