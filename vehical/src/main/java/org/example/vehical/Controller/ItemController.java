package org.example.vehical.Controller;

import org.example.vehical.Service.ItemService;
import org.example.vehical.dto.ItemDTO;
import org.example.vehical.dto.SaleDTO;
import org.example.vehical.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
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
    public ResponseEntity<ResponseUtil> saveItem(@RequestBody ItemDTO itemDTO) {
        System.out.println(itemDTO);
        itemService.save(itemDTO);
        return ResponseEntity.ok(new ResponseUtil(200, "Company saved successfully", null));
    }

    @PutMapping("/update/{id}")
    public ItemDTO updateItem(@PathVariable int id, @RequestBody ItemDTO itemDTO) {

        return itemService.update(id, itemDTO)   ;
    }

    @DeleteMapping("/{id}")
    public void deleteItem(@PathVariable int id) {
        itemService.delete(id);
    }
}
