package com.students.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.students.models.Kafedra;

@Repository
public interface KafedraRepository extends JpaRepository<Kafedra, Long> {

}
