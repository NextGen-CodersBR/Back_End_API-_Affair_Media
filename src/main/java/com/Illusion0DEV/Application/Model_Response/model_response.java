package com.Illusion0DEV.Application.Model_Response;

public class model_response {

    public model_response(model_response model){
        Success = model.Success;
        Error = model.Error;
        Message = model.Message;
    }

    public Boolean Success;
    public Boolean Error;
    public String Message;

    //CONSTRUCTOR
    public model_response(){}

    //GETTERS

    public Boolean get_success() {
        return Success;
    }
    public Boolean get_error() {
        return Error;
    }
    public String get_message() {
        return Message;
    }

    //SETTERS
    public void set_success(Boolean success) {
        Success = success;
    }
    public void set_error(Boolean error) {
        Error = error;
    }
    public void set_message(String message) {
        Message = message;
    }
}
