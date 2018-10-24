package com.SpringBoot.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.SpringBoot.model.Subject;
import com.SpringBoot.repository.SubjectRepository;

@RestController
@RequestMapping("/api")
public class SubjectController {

	@Autowired
	private SubjectRepository subjectRepository;
	
	@RequestMapping("/gopal")
	public String welcome() {
		return "welcome to gopal LW";
	}
	
	@GetMapping("/subject")
	public List<Subject> listOfSubjects(){
		return subjectRepository.findAll();
	}
	
	@PostMapping("/subject")
	public Subject addSubject(@Valid @RequestBody Subject subject) {
		return subjectRepository.save(subject);
	}
	
	@PutMapping("/subject/{id}")
	public Subject updateSubject(@Valid @RequestBody Subject subject, @PathVariable int id) {
		Subject subject1 = subjectRepository.getOne(id);
		subject1.setTitle(subject.getTitle());
		subject1.setDescription(subject.getDescription());

        return subjectRepository.save(subject1);
	}
	
	@DeleteMapping("/subject/{id}")
	public List<Subject> deleteSubject(@PathVariable("id") int userId) {
		subjectRepository.deleteById(userId);
        return subjectRepository.findAll();
	}
	
	@GetMapping("/subject/{id}")
	public Optional<Subject> findByIdSubject(@PathVariable("id") int userId) {
        return subjectRepository.findById(userId);
	}
}
