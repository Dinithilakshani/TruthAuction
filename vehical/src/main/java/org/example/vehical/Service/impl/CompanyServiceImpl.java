package org.example.vehical.Service.impl;

import org.example.vehical.Repo.CompanyRepo;
import org.example.vehical.Repo.CompanyTypeRepo;
import org.example.vehical.Service.CompanyService;
import org.example.vehical.dto.CompanyDTO;
import org.example.vehical.enitity.Company;
import org.example.vehical.enitity.CompanyType;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyRepo companyRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    private CompanyTypeRepo companyTypeRepo;

    @Override
    public void save(CompanyDTO companyDTO) {

        if(companyRepo.existsById(companyDTO.getC_id())){
            throw new RuntimeException("companyType already exists");
        }
        companyRepo.save(modelMapper.map(companyDTO, Company.class));
//
    }


        @Override
    public List<CompanyDTO> getAll() {
        List<Company> companies = companyRepo.findAll();
        return modelMapper.map(companies, new TypeToken<List<CompanyDTO>>(){}.getType());
    }

    @Override
    public CompanyDTO getById(int id) {
        Optional<Company> company = companyRepo.findById(id);
        if (company.isPresent()) {
            return modelMapper.map(company.get(), CompanyDTO.class);
        }
        throw new RuntimeException("Company not found");
    }

    @Override
    public void update(CompanyDTO companyDTO) {
        if (!companyRepo.existsById(companyDTO.getC_id())) {
            throw new RuntimeException("Company does not exist");
        }
        Company company = modelMapper.map(companyDTO, Company.class);
        companyRepo.save(company);
    }

    @Override
    public void delete(int id) {
        if (!companyRepo.existsById(id)) {
            throw new RuntimeException("Company does not exist");
        }
        companyRepo.deleteById(id);
    }
}
