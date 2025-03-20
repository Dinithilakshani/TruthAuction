package org.example.vehical.Service.impl;

import org.example.vehical.Repo.ItemRepository;
import org.example.vehical.Repo.UserRepository;
import org.example.vehical.Service.ItemService;
import org.example.vehical.enitity.Item;
import org.example.vehical.enitity.Sale;
import org.example.vehical.enitity.User;
import org.example.vehical.dto.ItemDTO;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ItemImpl implements ItemService {
    @Autowired
    private ItemRepository itemRepository;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;


    @Override
    public ItemDTO save(ItemDTO itemDTO) {
        try {
            Optional<Item> optionalItem = itemRepository.findById(itemDTO.getId());
            if (optionalItem.isPresent()) {
                throw new RuntimeException("Item already exists");
            }

            Optional<User> optionalUser = userRepository.findById(itemDTO.getUser_id());
            if (optionalUser.isEmpty()) {
                throw new RuntimeException("User not found");
            }

            Item item = modelMapper.map(itemDTO, Item.class);
            item.setUser(optionalUser.get());
            itemRepository.save(item);

            return modelMapper.map(item, ItemDTO.class);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Error saving item", e); // Throw an exception to propagate the error
        }
    }




    @Override
    public List<ItemDTO> getAll() {
        List<Item> items = itemRepository.findAll();
        return modelMapper.map(items, new TypeToken<List<ItemDTO>>(){}.getType());
    }

    @Override
    public ItemDTO getById(int id) {
        Optional<Item> item = itemRepository.findById(id);
        if (item.isPresent()) {
            return modelMapper.map(item.get(), ItemDTO.class);
        }
        throw new RuntimeException("Item not found");
    }

    @Override
    public ItemDTO update(int id, ItemDTO itemDTO) {
        if (!itemRepository.existsById(id)) {
            throw new RuntimeException("Item does not exist");
        }

        User user = userRepository.findById(itemDTO.getUser_id())
                .orElseThrow(() -> new RuntimeException("User not found"));

        Item item = modelMapper.map(itemDTO, Item.class);
        item.setId(id);
        item.setUser(user);
        itemRepository.save(item);
        return itemDTO;
    }

    @Override
    public void delete(int id) {
        if (!itemRepository.existsById(id)) {
            throw new RuntimeException("Item does not exist");
        }
        itemRepository.deleteById(id);
    }

    @Override
    public List<ItemDTO> getItemsByUserId(int userId) {
        List<Item> items = itemRepository.findByUserId(userId);
        return items.stream()
                .map(item -> modelMapper.map(item, ItemDTO.class))
                .collect(Collectors.toList());
    }
}
