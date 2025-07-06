package com.example.eduworldspring.controller;

import com.example.eduworldspring.dto.certificate.CertificateCreateUpdateDto;
import com.example.eduworldspring.model.Certificate;
import com.example.eduworldspring.service.CertificateService;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/certificates")
public class CertificateController {
    private final CertificateService certificateService;

    public CertificateController(CertificateService certificateService) {
        this.certificateService = certificateService;
    }

    @GetMapping
    public ArrayList<Certificate> getCertificates() {
        return certificateService.getCertificates();
    }

    @GetMapping("/{id}")
    public Certificate getCertificateById(@PathVariable Long id) {
        return certificateService.getCertificate(id);
    }

    @PostMapping
    public Certificate addCertificate(@RequestBody CertificateCreateUpdateDto certificateCreateUpdateDto) {
        return certificateService.createCertificate(certificateCreateUpdateDto);
    }

    @PutMapping("/{id}")
    public Boolean updateCertificate(@RequestBody CertificateCreateUpdateDto certificateCreateUpdateDto,
                                     @PathVariable Long id) {
        return certificateService.updateCertificate(id, certificateCreateUpdateDto);
    }

    @DeleteMapping("/{id}")
    public Boolean deleteCertificate(@PathVariable Long id) {
        return certificateService.deleteCertificate(id);
    }
}