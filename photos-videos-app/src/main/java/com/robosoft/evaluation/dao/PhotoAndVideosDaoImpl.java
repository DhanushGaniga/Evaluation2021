package com.robosoft.evaluation.dao;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.robosoft.evaluation.constants.AppConstants;
import com.robosoft.evaluation.constants.ErrorCodes;
import com.robosoft.evaluation.exception.DboperationFailedException;
import com.robosoft.evaluation.model.UploadedFileModel;
import com.robosoft.evaluation.repository.UploadedFileRepository;

@Component
public class PhotoAndVideosDaoImpl implements PhotoAndVideosDao{
	
	@Autowired
	private UploadedFileRepository uploadedFileRepository;

	@Override
	public UploadedFileModel saveImage(String category, String path, String fileName, String id) {
		try {
			UploadedFileModel uploadedeFile = UploadedFileModel.builder().fileName(fileName)
					.filePath(path).fileType(1).category(category)
					.uploadedBy(id)
					.createdTime(new Date()).build();
			return uploadedFileRepository.save(uploadedeFile);
		}catch (Exception e) {
			e.printStackTrace();
			throw new DboperationFailedException(AppConstants.DB_OPERATION_FAILED, ErrorCodes.UPLOAD_FAILED_MESSAGE);
		}
		
	}

	@Override
	public UploadedFileModel saveVideo(String category, String path, String fileName, String id) {
		try {
			UploadedFileModel uploadedeFile = UploadedFileModel.builder().fileName(fileName)
					.filePath(path).fileType(2).category(category)
					.uploadedBy(id)
					.createdTime(new Date()).build();
			return uploadedFileRepository.save(uploadedeFile);
		}catch (Exception e) {
			e.printStackTrace();
			throw new DboperationFailedException(AppConstants.DB_OPERATION_FAILED, ErrorCodes.UPLOAD_FAILED_MESSAGE);
		}
	}

}
