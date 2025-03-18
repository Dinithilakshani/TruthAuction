package org.example.vehical.Service.impl;

import org.example.vehical.Repo.ItemRepository;
import org.example.vehical.Repo.SaleItemRepo;
import org.example.vehical.Repo.SaleRepository;
import org.example.vehical.Repo.UserRepository;
import org.example.vehical.dto.CompanyTypeDTO;
import org.example.vehical.dto.SaleDTO;
import org.example.vehical.dto.SaleItemDTO;
import org.example.vehical.enitity.*;

import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

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

@Override
        public SaleItem saveSaleItem(SaleItemDTO saleItemDTO) {
            // Map SaleItemDTO to SaleItem entity
            SaleItem saleItem = modelMapper.map(saleItemDTO, SaleItem.class);

            // Fetch the User by userId from DTO
            User user = userRepository.findById(saleItemDTO.getUser_id())
                    .orElseThrow(() -> new RuntimeException("User not found"));

            // Fetch the Sale by saleId from DTO
            Sale sale = saleRepository.findById(saleItemDTO.getSale_id())
                    .orElseThrow(() -> new RuntimeException("Sale not found"));

            // Fetch the Item by itemId from DTO
            Item item = itemRepository.findById(saleItemDTO.getItem_id())
                    .orElseThrow(() -> new RuntimeException("Item not found"));

            // Set the fetched entities to the SaleItem entity
            saleItem.setUser(user);
            saleItem.setSale(sale);
            saleItem.setItem(item);

            // Save the SaleItem to the database
            return saleItemRepository.save(saleItem);
        }

        @Override
    public List<SaleItemDTO> getAll() {
        return modelMapper.map(saleRepository.findAll(), new TypeToken<List<SaleItemDTO>>() {}.getType());
    }
    @Override
    public void update(SaleItemDTO saleItemDTO) {
//
        if (saleItemRepository.existsById(saleItemDTO.getId())) {
            saleItemRepository.save(modelMapper.map(saleItemDTO, SaleItem.class));
//            return true;
        }
        throw new RuntimeException("companyType does not exist");
    }

    @Override
    public void delete(int id) {
        if (!saleItemRepository.existsById(id)) {
            throw new RuntimeException("companyType with ID " + id + " does not exist.");
        }
        saleItemRepository.deleteById(id);
    }
}
