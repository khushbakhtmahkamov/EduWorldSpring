package com.example.eduworldspring.controller;

import com.example.eduworldspring.dto.certificate.CertificateCreateDto;
import com.example.eduworldspring.dto.certificate.CertificateDto;
import com.example.eduworldspring.service.CertificateService;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/certificates")
public class CertificateController {
    private final CertificateService certificateService;

    public CertificateController(CertificateService certificateService) {
        this.certificateService = certificateService;
    }

    @GetMapping
    public List<CertificateDto> getAllCertificates() {
        return certificateService.getAllCertificates();
    }

    @GetMapping("/{id}")
    public CertificateDto getCertificateById(@PathVariable Long id) {
        return certificateService.getCertificateById(id);
    }

    @PostMapping
    public CertificateDto createCertificate(@RequestBody CertificateCreateDto dto) {
        return certificateService.createCertificate(dto);
    }

    @PutMapping("/{id}")
    public CertificateDto updateCertificate(@PathVariable Long id, @RequestBody CertificateCreateDto dto) {
        return certificateService.updateCertificate(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteCertificate(@PathVariable Long id) {
        certificateService.deleteCertificate(id);
    }
}