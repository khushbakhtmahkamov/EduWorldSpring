package com.example.eduworldspring.service;

import com.example.eduworldspring.dto.certificate.CertificateCreateDto;
import com.example.eduworldspring.dto.certificate.CertificateDto;
import com.example.eduworldspring.model.Certificate;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

@Service
public class CertificateServiceImpl implements CertificateService {
    private final List<Certificate> certificates = new ArrayList<>();

    @Override
    public List<CertificateDto> getAllCertificates() {
        List<CertificateDto> result = new ArrayList<>();
        for (Certificate cert : certificates) {
            result.add(convertToDto(cert));
        }
        return result;
    }

    @Override
    public CertificateDto getCertificateById(Long id) {
        for (Certificate cert : certificates) {
            if (cert.getCertificateId().equals(id)) {
                return convertToDto(cert);
            }
        }
        return null;
    }

    @Override
    public CertificateDto createCertificate(CertificateCreateDto dto) {
        Certificate certificate = Certificate.fromCreateDto(dto);
        certificate.setCertificateId(generateUniqueId());
        certificates.add(certificate);
        return convertToDto(certificate);
    }

    @Override
    public CertificateDto updateCertificate(Long id, CertificateCreateDto dto) {
        for (Certificate cert : certificates) {
            if (cert.getCertificateId().equals(id)) {
                cert.setSubjectId(dto.getSubjectId());
                cert.setUserId(dto.getUserId());
                cert.setTitle(dto.getTitle());
                cert.setDescription(dto.getDescription());
                cert.setIsAccess(dto.getIsAccess());
                cert.setIssueAt(dto.getIssueAt());
                cert.setProgressPercentage(dto.getProgressPercentage());
                return convertToDto(cert);
            }
        }
        return null;
    }

    @Override
    public void deleteCertificate(Long id) {
        certificates.removeIf(cert -> cert.getCertificateId().equals(id));
    }

    private CertificateDto convertToDto(Certificate certificate) {
        if (certificate == null) {
            return null;
        }

        CertificateDto dto = new CertificateDto();
        dto.setCertificateId(certificate.getCertificateId());
        dto.setSubjectId(certificate.getSubjectId());
        dto.setUserId(certificate.getUserId());
        dto.setTitle(certificate.getTitle());
        dto.setDescription(certificate.getDescription());
        dto.setIsAccess(certificate.getIsAccess());
        dto.setIssueAt(certificate.getIssueAt());
        dto.setProgressPercentage(certificate.getProgressPercentage());
        return dto;
    }

    private Long generateUniqueId() {
        long newId;
        do {
            newId = ThreadLocalRandom.current().nextLong(1, Long.MAX_VALUE);
        } while (idExists(newId));
        return newId;
    }

    private boolean idExists(Long id) {
        for (Certificate cert : certificates) {
            if (cert.getCertificateId().equals(id)) {
                return true;
            }
        }
        return false;
    }
}