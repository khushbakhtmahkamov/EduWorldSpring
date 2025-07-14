package com.example.eduworldspring.service;

import com.example.eduworldspring.dto.certificate.CertificateCreateUpdateDto;
import com.example.eduworldspring.dto.certificate.CertificateDto;
import java.util.List;

public interface CertificateService {
    CertificateDto createCertificate(CertificateCreateUpdateDto dto);
    CertificateDto getCertificateById(Long id);
    List<CertificateDto> getAllCertificates();
    CertificateDto updateCertificate(Long id, CertificateCreateUpdateDto dto);
    void deleteCertificate(Long id);
}