package com.robosoft.evaluation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.robosoft.evaluation.model.UploadedFileModel;


@Repository
public interface UploadedFileRepository extends JpaRepository<UploadedFileModel, Integer>{

}
