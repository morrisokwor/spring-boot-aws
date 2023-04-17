package com.example.springbootaws.db.repository;

import com.example.springbootaws.db.entities.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author Morris.Okworo on 11/04/2023
 */

public interface UserRepository extends JpaRepository<UserEntity, Long> {
}
