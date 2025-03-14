package org.example.vehical.Controller;

import org.example.vehical.Service.ItemService;
import org.example.vehical.dto.ItemDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    @GetMapping("/getall")
    public List<ItemDTO> getAllItems() {
        return itemService.getAll();
    }

    @GetMapping("/user/{userId}")
    public List<ItemDTO> getItemsByUserId(@PathVariable int userId) {
        return itemService.getItemsByUserId(userId);
    }

    @PostMapping("/save")
    public ItemDTO saveItem(@RequestBody ItemDTO itemDTO) {
        return itemService.save(itemDTO);
    }

    @PutMapping("/update")
    public ItemDTO updateItem(@PathVariable int id, @RequestBody ItemDTO itemDTO) {
        return itemService.update(id, itemDTO);
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable int id) {
        itemService.delete(id);
    }
}
