package com.robosoft.evaluation.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;

import javax.servlet.ServletContext;

import org.apache.commons.io.FilenameUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.robosoft.evaluation.constants.AppConstants;
import com.robosoft.evaluation.dao.PhotoAndVideosDao;
import com.robosoft.evaluation.dto.response.FileReturnValue;
import com.robosoft.evaluation.dto.response.GenericServerResponse;
import com.robosoft.evaluation.dto.response.ReturnValues;
import com.robosoft.evaluation.exception.UploadFailedException;
import com.robosoft.evaluation.model.UploadedFileModel;

import lombok.extern.log4j.Log4j2;


@Service
@Log4j2
public class PhotosAndVideosServiceImpl implements PhotosAndVideosService{
	
	@Autowired
	private PhotoAndVideosDao photoAndVideosDao;
	
	@Autowired
	private CommonServiceImpl commonServiceImpl;
	
	@Autowired
	private ServletContext contect;

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

//	@Override
//	public ResponseEntity<GenericServerResponse> getPhotos(String id) {
//		ReturnValues returnValue = new ReturnValues();
//		List<FileReturnValue> files = new ArrayList<FileReturnValue>();
//		
//		List<UploadedFileModel> entity = photoAndVideosDao.getFiles(1);
//		
//		for(UploadedFileModel model : entity) {
//			File file = new File(model.getFilePath());
//			if(file != null) {
//				String encodedBase64 = null;
//				try {
//					FileReturnValue data = new FileReturnValue();
//					String extension = FilenameUtils.getExtension(file.getName());
//					FileInputStream fileInputStream = new FileInputStream(file);
//					byte[] bytes = new byte[(int) file.length()];
//					fileInputStream.read(bytes);
//					encodedBase64 = Base64.getEncoder().encodeToString(bytes);
//					data.setFile("data:image/" +extension +";base64," +encodedBase64);	
//					
//					fileInputStream.close();
//					files.add(data);
//				}catch (Exception e) {
//					e.printStackTrace();
//				}
//			}
//		}
//		returnValue.setFiles(files);
//		return commonServiceImpl.generateSuccessResponse(returnValue);
//		
//	}

	@Override
	public ResponseEntity<GenericServerResponse> getPhotos(String id, int pageNum){
		ReturnValues returnValue = new ReturnValues();
		List<FileReturnValue> files = new ArrayList<FileReturnValue>();
		
		Pageable paging = PageRequest.of(pageNum, 20);
		Page<UploadedFileModel> entity = photoAndVideosDao.getFiles(1, paging);
		List<UploadedFileModel> uploadedFiles =  null;
		if(entity.hasContent()) {
			uploadedFiles = entity.getContent();
			for(UploadedFileModel model : uploadedFiles) {
				FileReturnValue data = new FileReturnValue();
				data.setFilePath(model.getFilePath());
				data.setFileOwner(model.getUploadedBy().getName());
				data.setOwnerProfilePath(model.getUploadedBy().getProfileUrl());
				
				files.add(data);
			}
		}
		returnValue.setFiles(files);
		return commonServiceImpl.generateSuccessResponse(returnValue);
	}
	
	@Override
	public ResponseEntity<GenericServerResponse> getVideos(String id, int pageNum) {
		ReturnValues returnValue = new ReturnValues();
		List<FileReturnValue> files = new ArrayList<FileReturnValue>();
		
		Pageable paging = PageRequest.of(pageNum, 20);
		Page<UploadedFileModel> entity = photoAndVideosDao.getFiles(1, paging);
		List<UploadedFileModel> uploadedFiles =  null;
		if(entity.hasContent()) {
			uploadedFiles = entity.getContent();
			for(UploadedFileModel model : entity) {
				FileReturnValue data = new FileReturnValue();
				data.setFilePath(model.getFilePath());
				data.setFileOwner(model.getUploadedBy().getName());
				data.setOwnerProfilePath(model.getUploadedBy().getProfileUrl());
				
				files.add(data);
			}
		}
		returnValue.setFiles(files);
		return commonServiceImpl.generateSuccessResponse(returnValue);
	}
	

}
