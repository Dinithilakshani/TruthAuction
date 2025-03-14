package org.example.vehical.Service.impl;

import org.example.vehical.Repo.SaleRepository;
import org.example.vehical.Service.SaleService;
import org.example.vehical.dto.SaleDTO;
import org.example.vehical.enitity.Sale;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleImpl implements SaleService {

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public void save(SaleDTO saleDTO) {
        if (saleRepository.existsById(saleDTO.getId())) {
            throw new RuntimeException("Sale already exists");
        }
        saleRepository.save(modelMapper.map(saleDTO, Sale.class));
    }

    @Override
    public List<SaleDTO> getAll() {
        return modelMapper.map(saleRepository.findAll(), new TypeToken<List<SaleDTO>>() {}.getType());
    }

    @Override
    public SaleDTO getById(int id) {
        Optional<Sale> optionalSale = saleRepository.findById(id);
        if (optionalSale.isPresent()) {
            return modelMapper.map(optionalSale.get(), SaleDTO.class);
        }
        throw new RuntimeException("Sale not found");
    }

    @Override
    public void update(SaleDTO saleDTO) {
        if (saleRepository.existsById(saleDTO.getId())) {
            saleRepository.save(modelMapper.map(saleDTO, Sale.class));
        } else {
            throw new RuntimeException("Sale does not exist");
        }
    }

    @Override
    public void delete(int id) {
        if (!saleRepository.existsById(id)) {
            throw new RuntimeException("Sale with ID " + id + " does not exist.");
        }
        saleRepository.deleteById(id);
    }
}
