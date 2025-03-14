package org.example.vehical.Service;

import org.example.vehical.Repo.CompanyTypeRepo;
import org.example.vehical.dto.CompanyTypeDTO;
import org.example.vehical.enitity.CompanyType;
import org.modelmapper.TypeToken;

import java.util.List;
import java.util.Optional;

public interface CompanyTypeService {
    void save(CompanyTypeDTO companyTypeDTO) ;
    List<CompanyTypeDTO> getAll();
    CompanyTypeDTO getById(int id) ;
    void update(CompanyTypeDTO companyTypeDTO);
    void delete(int id);
}


