package org.example.vehical.Controller;

import jakarta.persistence.GeneratedValue;
import org.example.vehical.Service.CompanyService;
import org.example.vehical.Service.impl.CompanyServiceImpl;
import org.example.vehical.dto.CompanyDTO;
import org.example.vehical.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/company")
@CrossOrigin("*")
public class CompanyController {
@GeneratedValue
    @Autowired
    private CompanyService companyService;

    @PostMapping("/save")
    public ResponseEntity<ResponseUtil> saveCompany(@RequestBody CompanyDTO companyDTO) {
        companyService.save(companyDTO);
        return ResponseEntity.ok(new ResponseUtil(200, "Company saved successfully", null));
    }

    @GetMapping("/getAll")
    public ResponseEntity<ResponseUtil> getAllCompanies() {
        List<CompanyDTO> companyDTOList = companyService.getAll();
        return ResponseEntity.ok(new ResponseUtil(200, "Success", companyDTOList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseUtil> getCompanyById(@PathVariable int id) {
        CompanyDTO companyDTO = companyService.getById(id);
        return ResponseEntity.ok(new ResponseUtil(200, "Success", companyDTO));
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseUtil> updateCompany(@RequestBody CompanyDTO companyDTO) {
        companyService.update(companyDTO);
        return ResponseEntity.ok(new ResponseUtil(200, "Company updated successfully", null));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseUtil> deleteCompany(@PathVariable int id) {
        companyService.delete(id);
        return ResponseEntity.ok(new ResponseUtil(200, "Company deleted successfully", null));
    }
}
