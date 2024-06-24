package com.intake21.customapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;


@ResponseStatus(HttpStatus.NOT_FOUND)
public class NotFoundException extends RuntimeException{

    public NotFoundException(String message){
        super(message);
    }

//    public ResponseEntity<ApiSecondResponse> getResponse(){
//        List<String> details = new ArrayList<>();
//        details.add(super.getMessage());
//        ErrorResponse errorResponse = new ErrorResponse().setMessage("Failed to get a resource").setDetails(details);
//        Response<ErrorResponse> response = new Response<>();
//        response.setType(ResponseType.RESOURCE_NOT_FOUND);
//        response.setPayload(errorResponse);
//        return  ResponseEntity.ok(ApiSecondResponse.fail(this.getMessage()));
//    }
}