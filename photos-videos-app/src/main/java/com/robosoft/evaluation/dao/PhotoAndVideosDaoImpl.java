package com.robosoft.evaluation.dao;

import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Component;

import com.robosoft.evaluation.constants.AppConstants;
import com.robosoft.evaluation.constants.ErrorCodes;
import com.robosoft.evaluation.exception.DboperationFailedException;
import com.robosoft.evaluation.model.UploadedFileModel;
import com.robosoft.evaluation.model.UserDetailModel;
import com.robosoft.evaluation.repository.UploadedFileRepository;
import com.robosoft.evaluation.repository.UserDetailRepository;

@Component
public class PhotoAndVideosDaoImpl implements PhotoAndVideosDao{
	
	@Autowired
	private UploadedFileRepository uploadedFileRepository;
	
	@Autowired
	private UserDetailRepository userDetailRepository;

	@Override
	public UploadedFileModel saveImage(String category, String path, String fileName, String id) {
		try {
			UserDetailModel userDetail = userDetailRepository.findByEmailId(id);
			UploadedFileModel uploadedeFile = UploadedFileModel.builder().fileName(fileName)
					.filePath(path).fileType(1).category(category)
					.uploadedBy(userDetail)
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
			UserDetailModel userDetail = userDetailRepository.findByEmailId(id);
			UploadedFileModel uploadedeFile = UploadedFileModel.builder().fileName(fileName)
					.filePath(path).fileType(2).category(category)
					.uploadedBy(userDetail)
					.createdTime(new Date()).build();
			return uploadedFileRepository.save(uploadedeFile);
		}catch (Exception e) {
			e.printStackTrace();
			throw new DboperationFailedException(AppConstants.DB_OPERATION_FAILED, ErrorCodes.UPLOAD_FAILED_MESSAGE);
		}
	}

	@Override
	public Page<UploadedFileModel> getFiles(Integer type, Pageable paging) {
		try {
			return uploadedFileRepository.findByFileType(type, paging);
		}catch (Exception e) {
			e.printStackTrace();
			throw new DboperationFailedException(AppConstants.DB_OPERATION_FAILED, ErrorCodes.FETCH_DATA_FAILED_MESSAGE);
		}
	}

}
