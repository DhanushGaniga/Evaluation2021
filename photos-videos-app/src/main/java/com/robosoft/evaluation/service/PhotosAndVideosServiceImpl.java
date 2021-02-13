package com.robosoft.evaluation.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.robosoft.evaluation.dao.PhotoAndVideosDao;
import com.robosoft.evaluation.dto.response.GenericServerResponse;
import com.robosoft.evaluation.exception.UploadFailedException;


@Service
public class PhotosAndVideosServiceImpl implements PhotosAndVideosService{
	
	@Autowired
	private PhotoAndVideosDao photoAndVideosDao;
	
	@Autowired
	private CommonServiceImpl commonServiceImpl;

	@Override
	public ResponseEntity<GenericServerResponse> saveImage(MultipartFile imageFile, String category) {
		String folderName = "\\Photos\\";
		String path = saveFile(folderName, imageFile);
		photoAndVideosDao.saveFile(category, path, imageFile.getOriginalFilename(), 1);
		
		return commonServiceImpl.generateSuccessResponse(null);
	}

	@Override
	public ResponseEntity<GenericServerResponse> saveVideo(MultipartFile videoFile, String category) {
		String folderName = "\\Videos\\";
		String path = saveFile(folderName, videoFile);
		photoAndVideosDao.saveFile(category, path, videoFile.getOriginalFilename(), 2);
		
		return commonServiceImpl.generateSuccessResponse(null);
	}
	
	private String saveFile(String folderName, MultipartFile file) {
		try {
			byte[] bytes = file.getBytes();
			Path path = Paths.get(folderName + file.getOriginalFilename());
			System.out.println(path.toAbsolutePath());
			Files.write(path, bytes);
			return path.toAbsolutePath().toString();
		}catch (Exception e) {
			e.printStackTrace();
			throw new UploadFailedException();
		}
	}

}
