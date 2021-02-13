package com.robosoft.evaluation.dao;

import com.robosoft.evaluation.model.UploadedFileModel;

public interface PhotoAndVideosDao {
	UploadedFileModel saveFile(String category, String path, String fileName, Integer type);

}
