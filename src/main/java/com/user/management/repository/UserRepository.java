package com.user.management.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.user.management.entity.UserEntity;

public interface UserRepository extends JpaRepository<UserEntity, Long> {

}
