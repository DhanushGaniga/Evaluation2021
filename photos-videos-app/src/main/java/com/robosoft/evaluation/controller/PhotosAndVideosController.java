package com.robosoft.evaluation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.robosoft.evaluation.dto.request.LoginData;
import com.robosoft.evaluation.dto.request.RegistrationDto;
import com.robosoft.evaluation.dto.response.GenericServerResponse;
import com.robosoft.evaluation.dto.response.ReturnValues;
import com.robosoft.evaluation.service.PhotosAndVideosServiceImpl;
import com.robosoft.evaluation.service.UserService;

import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;

/**
 * The Class PhotosAndVideosController.
 */
@RestController

/** The Constant log. */
@Log4j2
@RequestMapping("/api/v1")
public class PhotosAndVideosController {
	
	/** The photos and videos service. */
	@Autowired
	private PhotosAndVideosServiceImpl photosAndVideosService;
	
	/** The user service. */
	@Autowired
	private UserService userService;
	
	/**
	 * Upload image.
	 *
	 * @param imageFile the image file
	 * @param category the category
	 * @param id the id
	 * @return the response entity
	 */
	@ApiOperation(value = "Upload image api", response = GenericServerResponse.class)
	@PostMapping(value = "/uploadImage")
	public ResponseEntity<GenericServerResponse> uploadImage(@RequestBody MultipartFile imageFile, @RequestParam String category,  @RequestParam String id){	
		return photosAndVideosService.saveImage(imageFile, category, id);	
	}
	
	
	/**
	 * Upload video.
	 *
	 * @param videoFile the video file
	 * @param category the category
	 * @param id the id
	 * @return the response entity
	 */
	@ApiOperation(value = "Upload video api", response = GenericServerResponse.class)
	@PostMapping(value = "/uploadVideo")
	public ResponseEntity<GenericServerResponse> uploadVideo(@RequestBody MultipartFile videoFile, @RequestParam String category,  @RequestParam String id){	
		return photosAndVideosService.saveVideo(videoFile, category, id);	
	}
	
	/**
	 * Gets the photos.
	 *
	 * @param id the id
	 * @param pageNum the page num
	 * @return the photos
	 */
	@ApiOperation(value = "get Photos api", response = ReturnValues.class)
	@GetMapping(value = "/getPhotos")
	public ResponseEntity<GenericServerResponse> getPhotos(@RequestParam String id, @RequestParam int pageNum){	
		return photosAndVideosService.getPhotos(id, pageNum);	
	}
	
	/**
	 * Gets the videos.
	 *
	 * @param id the id
	 * @param pageNum the page num
	 * @return the videos
	 */
	@ApiOperation(value = "get video api", response = ReturnValues.class)
	@GetMapping(value = "/getVideos")
	public ResponseEntity<GenericServerResponse> getVideos(@RequestParam String id,  @RequestParam int pageNum){	
		return photosAndVideosService.getVideos( id, pageNum);	
	}
	
	/**
	 * Adds the user.
	 *
	 * @param userData the user data
	 * @return the response entity
	 */
	@ApiOperation(value = "user sign up api", response = GenericServerResponse.class)
	@PostMapping(value="/signup")
	public ResponseEntity<GenericServerResponse> addUser(@RequestBody RegistrationDto userData)
	{
		return userService.addUser(userData);
	}

	/**
	 * Login.
	 *
	 * @param loginData the login data
	 * @return the response entity
	 */
	@ApiOperation(value = "user sign up api", response = GenericServerResponse.class)
	@PostMapping(value="/login")
	public ResponseEntity<GenericServerResponse> login(@RequestBody LoginData loginData)
	{
		return userService.login(loginData);
	}
	
	/**
	 * Adds the favourite.
	 *
	 * @param videoImageId the video image id
	 * @param userId the user id
	 * @return the response entity
	 */
	@ApiOperation(value = "add favourite api", response = GenericServerResponse.class)
	@PostMapping(value="/addfavourites")
	public ResponseEntity<GenericServerResponse> addFavourite( @RequestParam int videoImageId, @RequestParam String userId)
	{
		return userService.addToFavourite(userId, videoImageId);
	}

	/**
	 * Removes the favourite.
	 *
	 * @param videoImageId the video image id
	 * @param userId the user id
	 * @return the response entity
	 */
	@ApiOperation(value = "remove favourite api", response = GenericServerResponse.class)
	@PostMapping(value="/removefavourites")
	public ResponseEntity<GenericServerResponse> removeFavourite( @RequestParam int videoImageId, @RequestParam String userId)
	{
		return userService.removeFavourite(userId, videoImageId);
	}
	
	/**
	 * Gets the favourite.
	 *
	 * @param userId the user id
	 * @return the favourite
	 */
	@ApiOperation(value = "get favourite api", response = ReturnValues.class)
	@PostMapping(value="/getfavourites")
	public ResponseEntity<GenericServerResponse> getFavourite(@RequestParam String userId)
	{
		return userService.getToFavourite(userId);
	}
	
	
	/**
	 * Gets the trending videos.
	 *
	 * @return the trending videos
	 */
	@ApiOperation(value = "get trending videos api", response = GenericServerResponse.class)
	@PostMapping(value="/getTrendingVideos")
	public ResponseEntity<GenericServerResponse> getTrendingVideos()
	{
		return photosAndVideosService.getTrendingPhotos();
	}
	
}
