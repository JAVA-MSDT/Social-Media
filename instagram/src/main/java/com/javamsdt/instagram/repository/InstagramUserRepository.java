package com.javamsdt.instagram.repository;

import com.javamsdt.instagram.model.InstagramUser;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface InstagramUserRepository extends JpaRepository<InstagramUser, Long> {
}
