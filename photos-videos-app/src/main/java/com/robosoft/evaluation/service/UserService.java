package com.robosoft.evaluation.service;

import org.springframework.http.ResponseEntity;

import com.robosoft.evaluation.dto.request.LoginData;
import com.robosoft.evaluation.dto.request.RegistrationDto;
import com.robosoft.evaluation.dto.response.GenericServerResponse;

/**
 * The Interface UserService.
 */
public interface UserService {
	
	/**
	 * Adds the user.
	 *
	 * @param user the user
	 * @return the response entity
	 */
	ResponseEntity<GenericServerResponse> addUser(RegistrationDto user);
	
	/**
	 * Login.
	 *
	 * @param user the user
	 * @return the response entity
	 */
	ResponseEntity<GenericServerResponse> login(LoginData user);
	
	/**
	 * Adds the to favourite.
	 *
	 * @param userId the user id
	 * @param videoOrImageId the video or image id
	 * @return the response entity
	 */
	ResponseEntity<GenericServerResponse> addToFavourite(String userId, int videoOrImageId);
	
	/**
	 * Removes the favourite.
	 *
	 * @param userId the user id
	 * @param videoOrImageId the video or image id
	 * @return the response entity
	 */
	ResponseEntity<GenericServerResponse> removeFavourite(String userId, int videoOrImageId);
	
	/**
	 * Gets the to favourite.
	 *
	 * @param userId the user id
	 * @return the to favourite
	 */
	ResponseEntity<GenericServerResponse> getToFavourite(String userId);
}
