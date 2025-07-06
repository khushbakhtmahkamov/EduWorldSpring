package com.example.eduworldspring.service;

import com.example.eduworldspring.dto.certificate.CertificateCreateUpdateDto;
import com.example.eduworldspring.model.Certificate;

import java.util.ArrayList;

public interface CertificateService {
    ArrayList<Certificate> getCertificates();
    Certificate getCertificate(Long id);
    Certificate createCertificate(CertificateCreateUpdateDto certificateCreateUpdateDto);
    Boolean updateCertificate(Long id, CertificateCreateUpdateDto certificateCreateUpdateDto);
    Boolean deleteCertificate(Long id);
}