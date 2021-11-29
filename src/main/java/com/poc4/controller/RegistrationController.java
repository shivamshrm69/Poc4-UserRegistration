package com.poc4.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.poc4.entity.User;
import com.poc4.feign.FeignClientRequests;
import com.poc4.response.ReturnResponse;
import com.poc4.service.UserService;

@RestController
@RequestMapping("/registration")
public class RegistrationController {
	@Autowired
	UserService userService;

	@Autowired
	FeignClientRequests feignClient;

	@PostMapping("/addUser")
	public ReturnResponse addUser(@RequestBody User user) {
		ReturnResponse response = new ReturnResponse();
		try {

			User result = userService.addUser(user);
			if (result == null) {
				response.setSuccess(false);
				response.getResult().put("error", "something went wrong");
				return response;
			}
			feignClient.addAddress(user.getAddress());
			response.setSuccess(true);
			response.getResult().put("success", "data saved successfully");
			return response;
		} catch (Exception e) {
			response.setSuccess(false);
			response.getResult().put("error", "something went wrong");
			return response;
		}
	}

}
