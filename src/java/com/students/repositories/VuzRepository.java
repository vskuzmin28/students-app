package com.students.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.students.models.Vuz;

@Repository
public interface VuzRepository extends JpaRepository<Vuz, Long> {

}
