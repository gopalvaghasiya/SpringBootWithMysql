package com.SpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.SpringBoot.model.Subject;
import com.SpringBoot.repository.SubjectRepository;

public class SubjectService {

	@Autowired
	private SubjectRepository subjectRepository;
	
	public List<Subject> getListOfSubject(){
		return subjectRepository.findAll();
		
	}
}
