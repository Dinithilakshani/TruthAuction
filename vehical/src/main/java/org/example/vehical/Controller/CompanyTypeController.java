package org.example.vehical.Controller;

import jakarta.persistence.GeneratedValue;
import org.example.vehical.Service.CompanyTypeService;
import org.example.vehical.Service.impl.CompanyTypeImpl;
import org.example.vehical.dto.CompanyTypeDTO;
import org.example.vehical.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/companytype")
@CrossOrigin("*")
public class CompanyTypeController {
    @Autowired
    private CompanyTypeService companyTypeService;  // FIXED: Use interface instead of implementation

    @PostMapping(path = "/save")
    public ResponseUtil saveCompanyType(@RequestBody CompanyTypeDTO companyTypeDTO) {
        companyTypeService.save(companyTypeDTO);
        return new ResponseUtil(200, "Company Type is saved", null);
    }

    @GetMapping(path = "/getAll")
    public ResponseUtil getAllCompanyTypes() {
        return new ResponseUtil(200, "Success", companyTypeService.getAll());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseUtil> getCompanyTypeById(@PathVariable int id) {
        CompanyTypeDTO companyTypeDTO = companyTypeService.getById(id);
        return ResponseEntity.ok(new ResponseUtil(200, "Success", companyTypeDTO));
    }

    @PutMapping(path = "/update")
    public ResponseUtil updateCompanyType(@RequestBody CompanyTypeDTO companyTypeDTO) {
        companyTypeService.update(companyTypeDTO);
        return new ResponseUtil(200, "Company Type Updated Successfully", null);
    }

    @DeleteMapping(path = "/delete/{id}")
    public ResponseUtil deleteCompanyType(@PathVariable int id) {
        companyTypeService.delete(id);
        return new ResponseUtil(200, "Company Type deleted", null);
    }
}
