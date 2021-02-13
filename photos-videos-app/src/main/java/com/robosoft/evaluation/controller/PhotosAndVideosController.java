package com.robosoft.evaluation.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.robosoft.evaluation.dto.response.GenericServerResponse;
import com.robosoft.evaluation.service.PhotosAndVideosServiceImpl;

import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequestMapping("/api/v1")
public class PhotosAndVideosController {
	
	@Autowired
	private PhotosAndVideosServiceImpl photosAndVideosService;
	
	@PostMapping(value = "/uploadImage")
	public ResponseEntity<GenericServerResponse> uploadImage(@RequestParam MultipartFile imageFile){	
		return photosAndVideosService.saveImage(imageFile);	
	}

}
