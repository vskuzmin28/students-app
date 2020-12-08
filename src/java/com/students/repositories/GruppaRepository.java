package com.students.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.students.models.Gruppa;

@Repository
public interface GruppaRepository extends JpaRepository<Gruppa, Long> {

}
