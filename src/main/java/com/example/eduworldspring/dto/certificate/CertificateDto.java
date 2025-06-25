package com.example.eduworldspring.dto.certificate;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CertificateDto {
    private Long certificateId;
    private Long subjectId;
    private Long userId;
    private String title;
    private String description;
    private Boolean isAccess;
    private LocalDateTime issueAt;
    private Integer progressPercentage;
}