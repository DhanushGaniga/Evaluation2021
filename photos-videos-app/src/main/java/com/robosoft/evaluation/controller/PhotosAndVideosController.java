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

import com.robosoft.evaluation.dto.response.GenericServerResponse;
import com.robosoft.evaluation.service.PhotosAndVideosServiceImpl;

import io.swagger.annotations.ApiOperation;
import lombok.extern.log4j.Log4j2;

@RestController
@Log4j2
@RequestMapping("/api/v1")
public class PhotosAndVideosController {
	
	@Autowired
	private PhotosAndVideosServiceImpl photosAndVideosService;
	
	@ApiOperation(value = "Upload image api", response = GenericServerResponse.class)
	@PostMapping(value = "/uploadImage")
	public ResponseEntity<GenericServerResponse> uploadImage(@RequestBody MultipartFile imageFile, @RequestParam String category,  @RequestParam String id){	
		return photosAndVideosService.saveImage(imageFile, category, id);	
	}
	
	
	@ApiOperation(value = "Upload video api", response = GenericServerResponse.class)
	@PostMapping(value = "/uploadVideo")
	public ResponseEntity<GenericServerResponse> uploadVideo(@RequestBody MultipartFile videoFile, @RequestParam String category,  @RequestParam String id){	
		return photosAndVideosService.saveVideo(videoFile, category, id);	
	}
	
	@ApiOperation(value = "get Photos api", response = GenericServerResponse.class)
	@GetMapping(value = "/getPhotos")
	public ResponseEntity<GenericServerResponse> getPhotos(@RequestParam String id){	
		return photosAndVideosService.getPhotos(id);	
	}
	
	@ApiOperation(value = "get video api", response = GenericServerResponse.class)
	@GetMapping(value = "/getPhotos")
	public ResponseEntity<GenericServerResponse> getVideos(@RequestParam String id){	
		return photosAndVideosService.getVideos( id);	
	}

}
