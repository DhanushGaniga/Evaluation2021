package com.robosoft.evaluation.dao;

import com.robosoft.evaluation.model.UploadedFileModel;

public interface PhotoAndVideosDao {
	
	UploadedFileModel saveImage(String category, String path, String fileName, String id);
	
	UploadedFileModel saveVideo(String category, String path, String fileName, String id);

}
