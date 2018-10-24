package com.SpringBoot.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.SpringBoot.model.Subject;

public interface SubjectRepository extends JpaRepository<Subject, Integer> {

}
