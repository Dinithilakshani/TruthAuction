package org.example.vehical.Service.impl;

import org.example.vehical.Repo.CompanyTypeRepo;
import org.example.vehical.Service.CompanyTypeService;
import org.example.vehical.dto.CompanyTypeDTO;
import org.example.vehical.enitity.CompanyType;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CompanyTypeImpl implements CompanyTypeService {
    @Autowired
    private CompanyTypeRepo companyTypeRepo;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void save(CompanyTypeDTO companyTypeDTO) {
        if(companyTypeRepo.existsById(companyTypeDTO.getId())){
            throw new RuntimeException("companyType already exists");
        }
        companyTypeRepo.save(modelMapper.map(companyTypeDTO, CompanyType.class));
    }

    @Override
    public List<CompanyTypeDTO> getAll() {

        return modelMapper.map(companyTypeRepo.findAll(), new TypeToken<List<CompanyTypeDTO>>(){}.getType());
    }

    @Override
    public CompanyTypeDTO getById(int id) {
        Optional<CompanyType> optionalCustomer = companyTypeRepo.findById(id);
        if (optionalCustomer.isPresent()) {
            return modelMapper.map(optionalCustomer.get(), CompanyTypeDTO.class);
        }
        throw new RuntimeException("companyType not found");
    }

    @Override
    public void update(CompanyTypeDTO companyTypeDTO) {
//
        if (companyTypeRepo.existsById(companyTypeDTO.getId())) {
            companyTypeRepo.save(modelMapper.map(companyTypeDTO, CompanyType.class));
//            return true;
        }
        throw new RuntimeException("companyType does not exist");
    }

    @Override
    public void delete(int id) {
        if (!companyTypeRepo.existsById(id)) {
            throw new RuntimeException("companyType with ID " + id + " does not exist.");
        }
        companyTypeRepo.deleteById(id);
    }
}


