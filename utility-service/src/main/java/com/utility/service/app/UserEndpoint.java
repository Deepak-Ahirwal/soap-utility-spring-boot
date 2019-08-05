package com.utility.service.app;

import org.example.userdetails.UserDetailsRequest;
import org.example.userdetails.UserDetailsResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
@Endpoint
public class UserEndpoint {
	private static final String NAMESPACE_URI = "http://www.example.org/userdetails/";
	
	
	private UserRepository repository;

	@Autowired
	public UserEndpoint(UserRepository repository) {
		this.repository = repository;
	}

	@PayloadRoot(namespace = NAMESPACE_URI, localPart = "UserDetailsRequest")
	@ResponsePayload
	public UserDetailsResponse getStudent(@RequestPayload UserDetailsRequest request) {
		UserDetailsResponse response = new UserDetailsResponse();
		response.setUser(repository.findUser(request.getName()));
		
		/*
		StudentDetailsResponse response = new StudentDetailsResponse();
		response.setStudent(StudentRepository.findStudent(request.getName()));*/
		
		
		

		return response;
	}
	

}
