package org.example.vehical.Service;

import org.example.vehical.dto.CompanyDTO;
import java.util.List;

public interface CompanyService {

    void save(CompanyDTO companyDTO);

    List<CompanyDTO> getAll();

    CompanyDTO getById(int id);

    void update(CompanyDTO companyDTO);

    void delete(int id);
}
