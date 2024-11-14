package com.example.demo.controllers;

import com.example.demo.entities.Certificate;
import com.example.demo.services.CertificateService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/certificates")
public class CertificateController {

    @Autowired
    private CertificateService certificateService;

    @GetMapping
    public String listCertificates(Model model) {
        List<Certificate> certificates = certificateService.findAll();
        model.addAttribute("certificates", certificates);
        return "certificates"; // имя HTML-шаблона для списка сертификатов
    }

    @PostMapping
    public String createCertificate(@ModelAttribute Certificate certificate) {
        certificateService.saveCertificate(certificate);
        return "redirect:/certificates";
    }

    @PostMapping("/{id}/delete")
    public String deleteCertificate(@PathVariable Integer id) {
        certificateService.deleteCertificate(id);
        return "redirect:/certificates";
    }

    @GetMapping("/{id}")
    public String viewCertificate(@PathVariable Integer id, Model model) {
        Certificate certificate = certificateService.findById(id);
        model.addAttribute("certificate", certificate);
        return "certificate-detail"; // имя HTML-шаблона для просмотра сертификата
    }
}
