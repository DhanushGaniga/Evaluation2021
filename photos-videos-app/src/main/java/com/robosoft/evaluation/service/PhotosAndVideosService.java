package com.robosoft.evaluation.service;

import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.robosoft.evaluation.dto.response.GenericServerResponse;

public interface PhotosAndVideosService {
	
	ResponseEntity<GenericServerResponse> saveImage(MultipartFile imageFile);

}
