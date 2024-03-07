package com.example.Repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.stereotype.Repository;

import com.example.Entity.User;

@EnableJpaRepositories
@Repository
public interface userRepo extends JpaRepository<User, Integer> {

	
}
