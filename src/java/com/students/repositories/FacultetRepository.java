package com.students.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.students.models.Facultet;

@Repository
public interface FacultetRepository extends JpaRepository<Facultet, Long> {

}
