package com.example.eduworldspring.mapper;

import com.example.eduworldspring.dto.certificate.CertificateCreateUpdateDto;
import com.example.eduworldspring.model.Certificate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CertificateMapper {
    @Mapping(target = "issuedAt", expression = "java(java.time.LocalDateTime.now())")
    Certificate toCertificate(CertificateCreateUpdateDto certificateCreateUpdateDto, Long id);

    @Mapping(target = "id", source = "id")
    Certificate toCertificateForUpdate(CertificateCreateUpdateDto certificateCreateUpdateDto, Long id);
}