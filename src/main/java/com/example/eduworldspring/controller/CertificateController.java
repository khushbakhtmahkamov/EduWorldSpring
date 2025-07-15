package com.example.eduworldspring.controller;

import com.example.eduworldspring.dto.certificate.CertificateCreateUpdateDto;
import com.example.eduworldspring.dto.certificate.CertificateDto;
import com.example.eduworldspring.service.CertificateService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/certificates")
@RequiredArgsConstructor
public class CertificateController {

    private final CertificateService certificateService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public CertificateDto createCertificate(@RequestBody CertificateCreateUpdateDto dto) {
        return certificateService.createCertificate(dto);
    }

    @GetMapping("/{id}")
    public CertificateDto getCertificate(@PathVariable Long id) {
        return certificateService.getCertificateById(id);
    }

    @GetMapping
    public List<CertificateDto> getAllCertificates() {
        return certificateService.getAllCertificates();
    }

    @PutMapping("/{id}")
    public CertificateDto updateCertificate(
            @PathVariable Long id,
            @RequestBody CertificateCreateUpdateDto dto) {
        return certificateService.updateCertificate(id, dto);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteCertificate(@PathVariable Long id) {
        certificateService.deleteCertificate(id);
    }
}