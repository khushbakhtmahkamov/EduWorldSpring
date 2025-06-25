package com.example.eduworldspring.dto.certificate;

import lombok.*;
import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class CertificateCreateDto {
    private Long subjectId;
    private Long userId;
    private String title;
    private String description;
    private Boolean isAccess;
    private LocalDateTime issueAt;
    private Integer progressPercentage;
}