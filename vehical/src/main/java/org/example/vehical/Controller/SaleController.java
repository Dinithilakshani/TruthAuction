package org.example.vehical.Controller;

import jakarta.persistence.GeneratedValue;
import org.example.vehical.Service.CompanyService;
import org.example.vehical.Service.SaleService;
import org.example.vehical.dto.CompanyDTO;
import org.example.vehical.dto.SaleDTO;
import org.example.vehical.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@RestController
@RequestMapping("api/v1/Sale")
@CrossOrigin("*")
public class SaleController {


    @Autowired
    private SaleService saleService;

    @PostMapping("/save")
    public ResponseEntity<ResponseUtil> saveSale(@RequestBody SaleDTO saleDTO) {
        System.out.println(saleDTO);
        saleService.save(saleDTO);
        return ResponseEntity.ok(new ResponseUtil(200, "Company saved successfully", null));
    }

    @GetMapping("/getAll")
    public ResponseEntity<ResponseUtil> getAllSale() {
        List<SaleDTO> companyDTOList = saleService.getAll();
        return ResponseEntity.ok(new ResponseUtil(200, "Success", companyDTOList));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseUtil> getSaleById(@PathVariable int id) {
        SaleDTO saleDTO = saleService.getById(id);
        return ResponseEntity.ok(new ResponseUtil(200, "Success", saleDTO));
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseUtil> updateSale(@RequestBody SaleDTO saleDTO) {
        saleService.update(saleDTO);
        return ResponseEntity.ok(new ResponseUtil(200, "Company updated successfully", null));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseUtil> deleteSale(@PathVariable int id) {
        saleService.delete(id);
        return ResponseEntity.ok(new ResponseUtil(200, "Company deleted successfully", null));
    }
}


