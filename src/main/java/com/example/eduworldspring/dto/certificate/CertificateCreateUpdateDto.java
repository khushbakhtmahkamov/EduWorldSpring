package com.example.eduworldspring.dto.certificate;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class CertificateCreateUpdateDto {
    private Long subjectId;
    private Long userId;
    private String title;
    private String description;
    private Boolean isAccess;
    private Integer progressPercentage;
}