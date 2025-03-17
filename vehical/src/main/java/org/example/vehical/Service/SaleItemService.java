package org.example.vehical.Service;

import org.example.vehical.dto.SaleItemDTO;
import org.example.vehical.enitity.SaleItem;

import java.util.List;

public interface SaleItemService  {
    public SaleItem saveSaleItem(SaleItemDTO saleItemDTO);
    public List<SaleItemDTO> getAll() ;
    public void update(SaleItemDTO saleItemDTO);
    public void delete(int id) ;





    }
