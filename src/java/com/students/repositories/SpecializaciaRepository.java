package com.students.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.students.models.Specializacia;

@Repository
public interface SpecializaciaRepository extends JpaRepository<Specializacia, Long> {

}
