package com.robosoft.evaluation.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.robosoft.evaluation.dto.response.GenericServerResponse;


/**
 * The Interface PhotosAndVideosService.
 */
public interface PhotosAndVideosService {
	
	/**
	 * Save image.
	 *
	 * @param imageFile the image file
	 * @param category the category
	 * @param id the id
	 * @return the response entity
	 */
	ResponseEntity<GenericServerResponse> saveImage(MultipartFile imageFile, String category, String id);
	
	/**
	 * Save video.
	 *
	 * @param imageFile the image file
	 * @param category the category
	 * @param id the id
	 * @return the response entity
	 */
	ResponseEntity<GenericServerResponse> saveVideo(MultipartFile imageFile, String category, String id);
	
	/**
	 * Gets the photos.
	 *
	 * @param id the id
	 * @param pageNum the page num
	 * @return the photos
	 */
	ResponseEntity<GenericServerResponse> getPhotos(String id, int pageNum);
	
	/**
	 * Gets the videos.
	 *
	 * @param id the id
	 * @param pageNum the page num
	 * @return the videos
	 */
	ResponseEntity<GenericServerResponse> getVideos(String id, int pageNum);

}
