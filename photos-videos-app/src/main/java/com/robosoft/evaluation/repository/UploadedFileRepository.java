package com.robosoft.evaluation.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.robosoft.evaluation.model.UploadedFileModel;


/**
 * The Interface UploadedFileRepository.
 */
@Repository
public interface UploadedFileRepository extends JpaRepository<UploadedFileModel, Integer>, PagingAndSortingRepository<UploadedFileModel, Integer>{
	
	/**
	 * Find by file type.
	 *
	 * @param type the type
	 * @param paging the paging
	 * @return the page
	 */
	Page<UploadedFileModel> findByFileType(Integer type, Pageable paging);

	


	/**
	 * Gets the trending photos.
	 *
	 * @return the trending photos
	 */
	@Query(value = "SELECT * FROM tbl_uploaded_file where fld_file_type = '1' ORDER BY RAND() LIMIT 1", nativeQuery = true)
	UploadedFileModel getTrendingPhotos();
}
