package com.robosoft.evaluation.dao;

import java.util.Optional;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.robosoft.evaluation.model.UploadedFileModel;
import com.robosoft.evaluation.model.UserDetailModel;
import com.robosoft.evaluation.model.UserFavouriteModel;

public interface PhotoAndVideosDao {
	
	UploadedFileModel saveImage(String category, String path, String fileName, String id);
	
	UploadedFileModel saveVideo(String category, String path, String fileName, String id);
	
	Page<UploadedFileModel> getFiles(Integer type, Pageable paging);
	
	UserDetailModel findUserByEmail(String emailID);
	
	UserDetailModel save(UserDetailModel entity);
	
	Optional<UploadedFileModel> getFile(Integer id);
	
	UserFavouriteModel addFavourite(UploadedFileModel files, UserDetailModel userData);
	
	UserFavouriteModel getFavourite(String userId, int videoOrImageId);
	
	UserFavouriteModel removeFavourite(UserFavouriteModel entiry);

}
