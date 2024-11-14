// Файл: src/main/java/com/example/demo/services/CompanyService.java
package com.example.demo.services;

import com.example.demo.entities.Company;
import com.example.demo.repositories.CompanyRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyService {
    private final CompanyRepository companyRepository;

    public void saveCompany(Company company) {
        companyRepository.save(company);
    }

    // Метод для получения всех компаний
    public List<Company> findAll() {
        return companyRepository.findAll();
    }

    // Метод для поиска компании по ID
    public Company findById(Integer id) {
        Optional<Company> optionalCompany = companyRepository.findById(id);
        return optionalCompany.orElse(null); // Вернет null, если компания не найдена
    }
    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public List<Company> getAllCompanies() {
        return companyRepository.findAll();
    }

    public Optional<Company> getCompanyById(Integer id) {
        return companyRepository.findById(id);
    }

    public Company createCompany(Company company) {
        return companyRepository.save(company);
    }

    public Company updateCompany(Integer id, Company updatedCompany) {
        updatedCompany.setId(id);
        return companyRepository.save(updatedCompany);
    }

    public void deleteCompany(Integer id) {
        companyRepository.deleteById(id);
    }
}
