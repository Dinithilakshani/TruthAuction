package org.example.vehical.Service;

import org.example.vehical.dto.SaleDTO;
import org.modelmapper.TypeToken;

import java.util.List;
import java.util.Optional;

public interface SaleService {
    public void save(SaleDTO saleDTO) ;
    public List<SaleDTO> getAll() ;
    public SaleDTO getById(int id);
    public void update(SaleDTO saleDTO) ;
    public void delete(int id) ;





}
