package com.example.eduworldspring.model;

import com.example.eduworldspring.dto.certificate.CertificateCreateDto;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDateTime;

@Getter
@Setter
public class Certificate {
    private Long certificateId;
    private Long subjectId;
    private Long userId;
    private String title;
    private String description;
    private Boolean isAccess;
    private LocalDateTime issueAt;
    private Integer progressPercentage;

    public Certificate() {}

    public Certificate(Long certificateId, Long subjectId, Long userId, String title,
                       String description, Boolean isAccess, LocalDateTime issueAt,
                       Integer progressPercentage) {
        this.certificateId = certificateId;
        this.subjectId = subjectId;
        this.userId = userId;
        this.title = title;
        this.description = description;
        this.isAccess = isAccess;
        this.issueAt = issueAt;
        this.progressPercentage = progressPercentage;
    }

    public static Certificate fromCreateDto(CertificateCreateDto dto) {
        return new Certificate(
                null,
                dto.getSubjectId(),
                dto.getUserId(),
                dto.getTitle(),
                dto.getDescription(),
                dto.getIsAccess(),
                dto.getIssueAt(),
                dto.getProgressPercentage()
        );
    }
}