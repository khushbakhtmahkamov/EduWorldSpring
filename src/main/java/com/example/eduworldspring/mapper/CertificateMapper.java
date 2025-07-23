package com.example.eduworldspring.mapper;

import com.example.eduworldspring.dto.certificate.CertificateCreateUpdateDto;
import com.example.eduworldspring.dto.certificate.CertificateDto;
import com.example.eduworldspring.model.Certificate;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface CertificateMapper {

    @Mapping(target = "issuedAt", expression = "java(java.time.LocalDateTime.now())")
    @Mapping(target = "id", ignore = true)
    Certificate toEntity(CertificateCreateUpdateDto dto);

    @Mapping(target = "issuedAt", ignore = true)
    void updateEntity(CertificateCreateUpdateDto dto, @MappingTarget Certificate entity);

    CertificateDto toDto(Certificate entity);
}