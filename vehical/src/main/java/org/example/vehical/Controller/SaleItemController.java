package org.example.vehical.Controller;


import org.example.vehical.Service.impl.SaleItemService;
import org.example.vehical.dto.SaleItemDTO;
import org.example.vehical.enitity.SaleItem;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
    @RequestMapping("/sale-items")
    public class SaleItemController {

        @Autowired
        private SaleItemService saleItemService;

        @PostMapping("/save")
        public SaleItem saveSaleItem(@RequestBody SaleItemDTO saleItemDTO) {
            return saleItemService.saveSaleItem(saleItemDTO);
        }
    }


