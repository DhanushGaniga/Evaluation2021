package com.robosoft.evaluation.service;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.robosoft.evaluation.constants.AppConstants;
import com.robosoft.evaluation.dao.PhotoAndVideosDao;
import com.robosoft.evaluation.dto.response.GenericServerResponse;
import com.robosoft.evaluation.exception.UploadFailedException;

import lombok.extern.log4j.Log4j2;


@Service
@Log4j2
public class PhotosAndVideosServiceImpl implements PhotosAndVideosService{
	
	@Autowired
	private PhotoAndVideosDao photoAndVideosDao;
	
	@Autowired
	private CommonServiceImpl commonServiceImpl;

	@Override
	public ResponseEntity<GenericServerResponse> saveImage(MultipartFile imageFile, String category, String id) {
		String path = saveFile(AppConstants.IMAGE_PATH, imageFile);
		photoAndVideosDao.saveImage(category, path, imageFile.getOriginalFilename(), id);
		
		return commonServiceImpl.generateSuccessResponse(null);
	}

	@Override
	public ResponseEntity<GenericServerResponse> saveVideo(MultipartFile videoFile, String category, String id) {
		String path = saveFile(AppConstants.VIDEO_PATH, videoFile);
		photoAndVideosDao.saveVideo(category, path, videoFile.getOriginalFilename(), id);
		
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

	@Override
	public ResponseEntity<GenericServerResponse> getPhotos(String id) {
		try {
            byte[] content = Files.readAllBytes(Paths.get("E:\\Photos\\download.jpg"));
            System.out.println(new String(content));

           return null;
        } catch (IOException e) {
            e.printStackTrace();
        }
		 return null;
	}

	@Override
	public ResponseEntity<GenericServerResponse> getVideos(String id) {
		return null;
	}
	

}
