package com.batch.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.batch.demo.entity.Person;

public interface PersonRepository extends JpaRepository<Person, Long> {

}
