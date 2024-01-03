package org.advertise.response;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

public class ResponseHandler {
	
  public static ResponseEntity<Object> responseBuilder(String message, HttpStatus status,Object responseObject){
	  Map<String,Object> response=new HashMap();
	  response.put("message",message);
	  response.put("status", status);
	  response.put("responseObject", responseObject);
	  
	  
	return new ResponseEntity<>(response,status);
	  
		  
  }
}
