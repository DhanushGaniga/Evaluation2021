package com.robosoft.evaluation.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.robosoft.evaluation.model.UploadedFileModel;


@Repository
public interface UploadedFileRepository extends JpaRepository<UploadedFileModel, Integer>, PagingAndSortingRepository<UploadedFileModel, Integer>{
	
	Page<UploadedFileModel> findByFileType(Integer type, Pageable paging);

}
