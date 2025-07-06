package com.example.eduworldspring.service;

import com.example.eduworldspring.dto.certificate.CertificateCreateUpdateDto;
import com.example.eduworldspring.exceptions.BusinessExceptionCode;
import com.example.eduworldspring.exceptions.BusinessRuntimeException;
import com.example.eduworldspring.mapper.CertificateMapper;
import com.example.eduworldspring.model.Certificate;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.concurrent.ThreadLocalRandom;

@Service
@RequiredArgsConstructor
public class CertificateServiceImpl implements CertificateService {

    private final CertificateMapper certificateMapper;
    @Getter
    private ArrayList<Certificate> certificates = new ArrayList<>();

    @Override
    public ArrayList<Certificate> getCertificates() {
        return certificates;
    }

    @Override
    public Certificate getCertificate(Long id) {
        if (id == null) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "Id cannot be null");
        }

        return certificates.stream()
                .filter(cert -> cert.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new BusinessRuntimeException(
                        BusinessExceptionCode.NOT_FOUND,
                        "Certificate with id " + id + " not found"));
    }

    @Override
    public Certificate createCertificate(CertificateCreateUpdateDto certificateCreateUpdateDto) {
        Certificate certificate = certificateMapper.toCertificate(
                certificateCreateUpdateDto,
                ThreadLocalRandom.current().nextLong(1, 1000));
        certificates.add(certificate);
        return certificate;
    }

    @Override
    public Boolean updateCertificate(Long id, CertificateCreateUpdateDto certificateCreateUpdateDto) {
        if (id == null) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "Id cannot be null");
        }
        if (certificateCreateUpdateDto == null) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST,
                    "CertificateCreateUpdateDto cannot be null");
        }

        Certificate updatedCertificate = certificateMapper.toCertificateForUpdate(certificateCreateUpdateDto, id);

        for (int i = 0; i < certificates.size(); i++) {
            if (certificates.get(i).getId().equals(updatedCertificate.getId())) {
                certificates.set(i, updatedCertificate);
                return true;
            }
        }
        throw new BusinessRuntimeException(BusinessExceptionCode.NOT_FOUND, "Certificate not found");
    }

    @Override
    public Boolean deleteCertificate(Long id) {
        if (id == null) {
            throw new BusinessRuntimeException(BusinessExceptionCode.BAD_REQUEST, "Id cannot be null");
        }

        return certificates.removeIf(cert -> cert.getId().equals(id));
    }
}