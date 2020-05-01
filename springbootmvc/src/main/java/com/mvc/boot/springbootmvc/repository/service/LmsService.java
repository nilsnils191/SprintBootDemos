package com.mvc.boot.springbootmvc.repository.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.mvc.boot.springbootmvc.models.LMS_TBL;
import com.mvc.boot.springbootmvc.repository.LMS_TBL_REPOSITORY;

@Service
public class LmsService {

	@Autowired
	private LMS_TBL_REPOSITORY lmsTblRepository;
	
	
	public List<LMS_TBL> getAllBooks() {
		List<LMS_TBL> listOfTables = new ArrayList<>();
		Iterable<LMS_TBL> itrBooks =  lmsTblRepository.findAll();
		itrBooks.forEach(e -> listOfTables.add(e));
		return listOfTables;
	}
}
