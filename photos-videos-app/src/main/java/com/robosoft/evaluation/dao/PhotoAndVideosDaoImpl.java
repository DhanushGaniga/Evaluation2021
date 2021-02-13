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
	public UploadedFileModel saveFile(String category, String path, String fileName, Integer type) {
		try {
			UploadedFileModel uploadedeFile = UploadedFileModel.builder().fileName(fileName)
					.filePath(path).fileType(type).category(category)
					.createdTime(new Date()).build();
			return uploadedFileRepository.save(uploadedeFile);
		}catch (Exception e) {
			e.printStackTrace();
			throw new DboperationFailedException(AppConstants.DB_OPERATION_FAILED, ErrorCodes.UPLOAD_FAILED_MESSAGE);
		}
		
	}

}
