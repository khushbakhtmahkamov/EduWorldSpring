package com.example.eduworldspring.service;

import com.example.eduworldspring.dto.certificate.CertificateCreateDto;
import com.example.eduworldspring.dto.certificate.CertificateDto;
import java.util.List;

public interface CertificateService {
    List<CertificateDto> getAllCertificates();
    CertificateDto getCertificateById(Long id);
    CertificateDto createCertificate(CertificateCreateDto dto);
    CertificateDto updateCertificate(Long id, CertificateCreateDto dto);
    void deleteCertificate(Long id);
}