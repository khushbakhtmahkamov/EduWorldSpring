package com.example.eduworldspring.repository;

import com.example.eduworldspring.model.Certificate;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CertificateRepository extends JpaRepository<Certificate, Long> {
}