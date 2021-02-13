package com.robosoft.evaluation.service;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletContext;

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


/**
 * The Class PhotosAndVideosServiceImpl.
 */
@Service

/** The Constant log. */
@Log4j2
public class PhotosAndVideosServiceImpl implements PhotosAndVideosService{
	
	/** The photo and videos dao. */
	@Autowired
	private PhotoAndVideosDao photoAndVideosDao;
	
	/** The common service impl. */
	@Autowired
	private CommonServiceImpl commonServiceImpl;
	
	/** The contect. */
	@Autowired
	private ServletContext contect;

	/**
	 * Save image.
	 *
	 * @param imageFile the image file
	 * @param category the category
	 * @param id the id
	 * @return the response entity
	 */
	@Override
	public ResponseEntity<GenericServerResponse> saveImage(MultipartFile imageFile, String category, String id) {
		String path = saveFile(AppConstants.IMAGE_PATH, imageFile);
		photoAndVideosDao.saveImage(category, path, imageFile.getOriginalFilename(), id);
		
		return commonServiceImpl.generateSuccessResponse(null);
	}

	/**
	 * Save video.
	 *
	 * @param videoFile the video file
	 * @param category the category
	 * @param id the id
	 * @return the response entity
	 */
	@Override
	public ResponseEntity<GenericServerResponse> saveVideo(MultipartFile videoFile, String category, String id) {
		String path = saveFile(AppConstants.VIDEO_PATH, videoFile);
		photoAndVideosDao.saveVideo(category, path, videoFile.getOriginalFilename(), id);
		
		return commonServiceImpl.generateSuccessResponse(null);
	}
	
	/**
	 * Save file.
	 *
	 * @param folderName the folder name
	 * @param file the file
	 * @return the string
	 */
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


	/**
	 * Gets the photos.
	 *
	 * @param id the id
	 * @param pageNum the page num
	 * @return the photos
	 */
	@Override
	public ResponseEntity<GenericServerResponse> getPhotos(String id, int pageNum){
		ReturnValues returnValue = new ReturnValues();
		List<FileReturnValue> files = new ArrayList<FileReturnValue>();
		
		Pageable paging = PageRequest.of(pageNum-1, 20);
		Page<UploadedFileModel> entity = photoAndVideosDao.getFiles(1, paging);
		List<UploadedFileModel> uploadedFiles =  null;
		if(entity.hasContent()) {
			uploadedFiles = entity.getContent();
			for(UploadedFileModel model : uploadedFiles) {
				FileReturnValue data = new FileReturnValue();
				data.setFilePath(model.getFilePath());
				data.setFileOwner(model.getUploadedBy() == null?"":model.getUploadedBy().getName());
				data.setOwnerProfilePath(model.getUploadedBy() == null?"":model.getUploadedBy().getProfileUrl());
				data.setFileType("image/jpg");
				data.setFileId(model.getId());
				files.add(data);
			}
		}
		returnValue.setFiles(files);
		return commonServiceImpl.generateSuccessResponse(returnValue);
	}
	
	/**
	 * Gets the videos.
	 *
	 * @param id the id
	 * @param pageNum the page num
	 * @return the videos
	 */
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
				data.setFileOwner(model.getUploadedBy() == null?"":model.getUploadedBy().getName());
				data.setOwnerProfilePath(model.getUploadedBy() == null?"":model.getUploadedBy().getProfileUrl());
				data.setFileType("video/mp4");
				data.setFileId(model.getId());
				files.add(data);
			}
		}
		returnValue.setFiles(files);
		return commonServiceImpl.generateSuccessResponse(returnValue);
	}

	/**
	 * Gets the trending photos.
	 *
	 * @return the trending photos
	 */
	@Override
	public ResponseEntity<GenericServerResponse> getTrendingPhotos() {
		FileReturnValue returnData = new FileReturnValue();
		UploadedFileModel entity = photoAndVideosDao.getTrendingPhotos();
		if(entity == null) {
			commonServiceImpl.generateSuccessResponse(returnData);
		}
		
		returnData.setFilePath(entity.getFilePath());
		returnData.setFileOwner(entity.getUploadedBy() == null?"":entity.getUploadedBy().getName());
		returnData.setOwnerProfilePath(entity.getUploadedBy() == null?"":entity.getUploadedBy().getProfileUrl());
		
		if(entity.getFileType() == 1) {
			returnData.setFileType("image/jpg");
		}
		else {
			returnData.setFileType("video/mp4");
		}
		returnData.setFileId(entity.getId());
		
		return commonServiceImpl.generateSuccessResponse(returnData);
	}
	

}
