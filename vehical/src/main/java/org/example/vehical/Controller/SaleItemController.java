package org.example.vehical.Controller;


import org.example.vehical.Service.impl.SaleItemService;
import org.example.vehical.dto.SaleDTO;
import org.example.vehical.dto.SaleItemDTO;
import org.example.vehical.enitity.SaleItem;
import org.example.vehical.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/sale-items")
public class SaleItemController {

    @Autowired
    private SaleItemService saleItemService;

    @PostMapping("/save")
    public SaleItem saveSaleItem(@RequestBody SaleItemDTO saleItemDTO) {
        return saleItemService.saveSaleItem(saleItemDTO);
    }

    @GetMapping("/getAll")
    public ResponseEntity<ResponseUtil> getAllCompanies() {
        List<SaleItemDTO> companyDTOList = saleItemService.getAll();
        return ResponseEntity.ok(new ResponseUtil(200, "Success", companyDTOList));
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseUtil> updateCompany(@RequestBody SaleItemDTO saleItemDTO) {
        saleItemService.update(saleItemDTO);
        return ResponseEntity.ok(new ResponseUtil(200, "Company updated successfully", null));
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<ResponseUtil> deleteCompany(@PathVariable int id) {
        saleItemService.delete(id);
        return ResponseEntity.ok(new ResponseUtil(200, "Company deleted successfully", null));
    }
}
