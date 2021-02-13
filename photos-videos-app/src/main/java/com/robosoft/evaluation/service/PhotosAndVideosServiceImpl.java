package com.robosoft.evaluation.service;

import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.robosoft.evaluation.dto.response.GenericServerResponse;
import com.robosoft.evaluation.exception.UploadFailedException;


@Service
public class PhotosAndVideosServiceImpl implements PhotosAndVideosService{

	@Override
	public ResponseEntity<GenericServerResponse> saveImage(MultipartFile imageFile) {
		String folder = "\\Photos\\";
		try {
			byte[] bytes = imageFile.getBytes();
			Path path = Paths.get(folder + imageFile.getOriginalFilename());
			System.out.println(path.toAbsolutePath());
			Files.write(path, bytes);
			return null;
		}catch (Exception e) {
			e.printStackTrace();
			throw new UploadFailedException();
		}
		
	}

}
