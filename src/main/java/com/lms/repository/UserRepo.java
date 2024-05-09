package com.lms.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.lms.model.User;

@Repository
@Transactional
public interface UserRepo extends JpaRepository<User, Integer>{

}
