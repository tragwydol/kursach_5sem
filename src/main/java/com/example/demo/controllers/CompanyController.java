package com.example.demo.controllers;

import com.example.demo.entities.Company;
import com.example.demo.services.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/companies")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    @GetMapping
    public String listCompanies(Model model) {
        List<Company> companies = companyService.findAll();
        model.addAttribute("companies", companies);
        return "companies"; // имя HTML-шаблона для списка компаний
    }

    @GetMapping("/new")
    public String showCreateForm(Model model) {
        model.addAttribute("company", new Company());
        return "company-form"; // имя HTML-шаблона для создания компании
    }

    @PostMapping
    public String createCompany(@ModelAttribute Company company) {
        companyService.saveCompany(company);
        return "redirect:/companies";
    }

    @GetMapping("/{id}/edit")
    public String showEditForm(@PathVariable Integer id, Model model) {
        Company company = companyService.findById(id);
        model.addAttribute("company", company);
        return "company-form"; // имя HTML-шаблона для редактирования компании
    }

    @PostMapping("/{id}")
    public String updateCompany(@PathVariable Integer id, @ModelAttribute Company company) {
        company.setId(id); // устанавливаем ID для обновления
        companyService.saveCompany(company);
        return "redirect:/companies";
    }

    @PostMapping("/{id}/delete")
    public String deleteCompany(@PathVariable Integer id) {
        companyService.deleteCompany(id);
        return "redirect:/companies";
    }

    @GetMapping("/{id}")
    public String viewCompany(@PathVariable Integer id, Model model) {
        Company company = companyService.findById(id);
        model.addAttribute("company", company);
        return "company-detail"; // имя HTML-шаблона для просмотра компании
    }
}
