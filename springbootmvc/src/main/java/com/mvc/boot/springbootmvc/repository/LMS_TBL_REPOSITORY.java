package com.mvc.boot.springbootmvc.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.mvc.boot.springbootmvc.models.LMS_TBL;

@Repository
public interface LMS_TBL_REPOSITORY extends CrudRepository<LMS_TBL, Long> {

	
}
