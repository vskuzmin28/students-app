package com.students.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.students.models.User;

public interface UserRepository extends JpaRepository<User, String> {
}
