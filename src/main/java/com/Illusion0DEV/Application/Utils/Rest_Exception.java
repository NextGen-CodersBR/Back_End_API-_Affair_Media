package com.Illusion0DEV.Application.Utils;

import com.Illusion0DEV.Application.Model_Response.model_response;
import org.springframework.dao.DataAccessException;
import org.springframework.orm.jpa.JpaSystemException;

public class Rest_Exception extends RuntimeException {

  private String name;
  private final Exception inner_exception;

  // CONSTRUCTOR
  public Rest_Exception(String message) {
    super(message);
    this.name = message;
    this.inner_exception = null;
  }

  // CONSTRUCTOR
  public Rest_Exception(String name, Exception inner_exception) {
    super(inner_exception);
    this.name = name;
    this.inner_exception = inner_exception;
  }

  public model_response tratarErro() {
    model_response model = new model_response();

    if (inner_exception instanceof JpaSystemException || inner_exception instanceof DataAccessException) {
      Throwable cause = inner_exception.getCause();

      if (cause != null && cause.getMessage().toLowerCase().contains("constraint")) {
        model.set_message(String.format("%s is bound and cannot be removed or changed", name));
      } else if (cause != null && cause.getMessage().toLowerCase().contains("duplicate key")) {
        model.set_message(String.format("%s already exists", name));
      }
      model.set_success(false);
      model.set_error(false);
    } else {
      model.set_message(inner_exception != null && inner_exception.getMessage() != null ? inner_exception.getMessage() : "Unknown error");
      model.set_success(false);
      model.set_error(true);
    }

    return model;
  }

  // GETTER
  public String get_name() {
    return name;
  }

  // SETTER
  public void set_name(String name) {
    this.name = name;
  }
}
