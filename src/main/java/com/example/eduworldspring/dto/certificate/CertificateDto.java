package com.example.eduworldspring.dto.certificate;

import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class CertificateDto {
    private Long id;
    private Long subjectId;
    private Long userId;
    private String title;
    private String description;
    private Boolean isAccess;
    private LocalDateTime issuedAt;
    private Integer progressPercentage;
}