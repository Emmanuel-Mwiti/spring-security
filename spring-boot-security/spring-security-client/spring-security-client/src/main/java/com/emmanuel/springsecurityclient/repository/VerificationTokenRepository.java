package com.emmanuel.springsecurityclient.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emmanuel.springsecurityclient.entity.VerificationToken;

public interface VerificationTokenRepository extends JpaRepository<VerificationToken, Long> {
    
}
