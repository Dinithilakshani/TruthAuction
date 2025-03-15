package org.example.vehical.Service.impl;

import org.example.vehical.Repo.ItemRepository;
import org.example.vehical.Repo.SaleItemRepo;
import org.example.vehical.Repo.SaleRepository;
import org.example.vehical.Repo.UserRepository;
import org.example.vehical.dto.SaleItemDTO;
import org.example.vehical.enitity.SaleItem;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SaleItemService implements org.example.vehical.Service.SaleItemService {

    @Autowired
    private SaleItemRepo saleItemRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private ModelMapper modelMapper;

    public SaleItem saveSaleItem(SaleItemDTO saleItemDTO) {
        SaleItem saleItem = modelMapper.map(saleItemDTO, SaleItem.class);

        // Fetch related entities
        saleItem.setUser(userRepository.findById(saleItemDTO.getId())
                .orElseThrow(() -> new RuntimeException("User not found")));
        saleItem.setSale(saleRepository.findById(saleItemDTO.getId())
                .orElseThrow(() -> new RuntimeException("Sale not found")));
        saleItem.setItem(itemRepository.findById(saleItemDTO.getId())
                .orElseThrow(() -> new RuntimeException("Item not found")));

        return saleItemRepository.save(saleItem);
    }
}
