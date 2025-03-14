package org.example.vehical.Service;

import org.example.vehical.dto.ItemDTO;

import java.util.List;

public interface ItemService {
    ItemDTO save(ItemDTO itemDTO);
    List<ItemDTO> getAll();
    ItemDTO getById(int id);
    ItemDTO update(int id, ItemDTO itemDTO);
    void delete(int id);
    List<ItemDTO> getItemsByUserId(int userId);
}
