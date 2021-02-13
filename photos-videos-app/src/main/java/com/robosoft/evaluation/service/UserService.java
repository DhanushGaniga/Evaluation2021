package com.robosoft.evaluation.service;

import org.springframework.http.ResponseEntity;

import com.robosoft.evaluation.dto.request.LoginData;
import com.robosoft.evaluation.dto.request.RegistrationDto;
import com.robosoft.evaluation.dto.response.GenericServerResponse;


public interface UserService {
	ResponseEntity<GenericServerResponse> addUser(RegistrationDto user);
	ResponseEntity<GenericServerResponse> login(LoginData user);
	ResponseEntity<GenericServerResponse> addToFavourite(String userId, int videoOrImageId);
	ResponseEntity<GenericServerResponse> removeFavourite(String userId, int videoOrImageId);
}
