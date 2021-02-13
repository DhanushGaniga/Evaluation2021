package com.robosoft.evaluation.dao;

import java.util.List;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.robosoft.evaluation.model.UploadedFileModel;

public interface PhotoAndVideosDao {
	
	UploadedFileModel saveImage(String category, String path, String fileName, String id);
	
	UploadedFileModel saveVideo(String category, String path, String fileName, String id);
	
	Page<UploadedFileModel> getFiles(Integer type, Pageable paging);

}
