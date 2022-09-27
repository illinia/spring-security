package com.springsecurity.study.repository;

import com.springsecurity.study.entity.Otp;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OtpRepository extends JpaRepository<Otp, String> {
}
