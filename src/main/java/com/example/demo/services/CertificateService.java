// Файл: src/main/java/com/example/demo/services/CertificateService.java
package com.example.demo.services;

import com.example.demo.entities.Certificate;
import com.example.demo.repositories.CertificateRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CertificateService {
    private final CertificateRepository certificateRepository;

    public void saveCertificate(Certificate certificate) {
        certificateRepository.save(certificate);
    }

    // Метод для получения всех сертификатов
    public List<Certificate> findAll() {
        return certificateRepository.findAll();
    }

    // Метод для поиска сертификата по ID
    public Certificate findById(Integer id) {
        Optional<Certificate> optionalCertificate = certificateRepository.findById(id);
        return optionalCertificate.orElse(null); // Вернет null, если сертификат не найден
    }
    public CertificateService(CertificateRepository certificateRepository) {
        this.certificateRepository = certificateRepository;
    }

    public List<Certificate> getAllCertificates() {
        return certificateRepository.findAll();
    }

    public Optional<Certificate> getCertificateById(Integer id) {
        return certificateRepository.findById(id);
    }

    public Certificate createCertificate(Certificate certificate) {
        return certificateRepository.save(certificate);
    }

    public Certificate updateCertificate(Integer id, Certificate updatedCertificate) {
        updatedCertificate.setId(id);
        return certificateRepository.save(updatedCertificate);
    }

    public void deleteCertificate(Integer id) {
        certificateRepository.deleteById(id);
    }
}
