package com.utility.app;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

import com.utility.app.schema.UserDetailsRequest;
import com.utility.app.schema.UserDetailsResponse;

@SpringBootApplication
public class UtilityApplication {

	public static void main(String[] args) {
		SpringApplication.run(UtilityApplication.class, args);
	}
	
	@Bean
	CommandLineRunner lookup(SOAPConnector soapConnector) {
		return args -> {
			String name = "Deepak";//Default Name
			if(args.length>0){
				name = args[0];
			}
			
			UserDetailsRequest userRequest = new UserDetailsRequest();
			userRequest.setName(name);
			
			UserDetailsResponse userResponse = (UserDetailsResponse) soapConnector.callWebService("http://localhost:8080/service/user-details", userRequest);
			
			
			System.out.println("Got Response As below ========= : ");
			System.out.println("Name : "+userResponse.getUser().getName());
			System.out.println("MobileNumber : "+userResponse.getUser().getMobilenumber());
			System.out.println("Address : "+userResponse.getUser().getAddress());
		};
	}

}
