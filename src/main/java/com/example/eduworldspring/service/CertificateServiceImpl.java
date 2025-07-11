package com.example.eduworldspring.service;

import com.example.eduworldspring.dto.certificate.CertificateCreateUpdateDto;
import com.example.eduworldspring.dto.certificate.CertificateDto;
import com.example.eduworldspring.exceptions.BusinessExceptionCode;
import com.example.eduworldspring.exceptions.BusinessRuntimeException;
import com.example.eduworldspring.mapper.CertificateMapper;
import com.example.eduworldspring.model.Certificate;
import com.example.eduworldspring.repository.CertificateRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
@Transactional
public class CertificateServiceImpl implements CertificateService {

    private final CertificateMapper mapper;
    private final CertificateRepository certificateRepository;

    @Override
    public CertificateDto createCertificate(CertificateCreateUpdateDto dto) {
        Certificate certificate = mapper.toEntity(dto);
        Certificate savedCertificate = certificateRepository.save(certificate);
        return mapper.toDto(savedCertificate);
    }

    @Override
    public CertificateDto getCertificateById(Long id) {
        Certificate certificate = certificateRepository.findById(id)
                .orElseThrow(() -> new BusinessRuntimeException(BusinessExceptionCode.NOT_FOUND, "Certificate with id " + id + " not found")); // Добавлена закрывающая скобка
        return mapper.toDto(certificate);
    }

    @Override
    @Transactional(readOnly = true)
    public List<CertificateDto> getAllCertificates() {
        return certificateRepository.findAll().stream()
                .map(mapper::toDto)
                .collect(Collectors.toList());
    }

    @Override
    public CertificateDto updateCertificate(Long id, CertificateCreateUpdateDto dto) {
        Certificate certificate = certificateRepository.findById(id)
                .orElseThrow(() -> new BusinessRuntimeException(BusinessExceptionCode.NOT_FOUND, "Certificate with id " + id + " not found")); // Добавлена закрывающая скобка

        mapper.updateEntity(dto, certificate);
        Certificate updatedCertificate = certificateRepository.save(certificate);
        return mapper.toDto(updatedCertificate);
    }

    @Override
    public void deleteCertificate(Long id) {
        if (!certificateRepository.existsById(id)) {
            throw new BusinessRuntimeException(BusinessExceptionCode.NOT_FOUND, "Certificate with id " + id + " not found"); // Исправлено сообщение об ошибке
        }
        certificateRepository.deleteById(id);
    }
}