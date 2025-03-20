package org.example.vehical.Controller;

import org.example.vehical.Service.UserService;
import org.example.vehical.dto.SaleDTO;
import org.example.vehical.dto.UserDTO;
import org.example.vehical.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/users")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
    public ResponseEntity<ResponseUtil> saveUser(@RequestBody UserDTO userDTO) {
        userService.save(userDTO);
        return ResponseEntity.ok(new ResponseUtil(200, "User saved successfully", null)); // Fixed message
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseUtil> getUserById(@PathVariable int id) {
        UserDTO userDTO = userService.getById(id);
        return ResponseEntity.ok(new ResponseUtil(200, "Success", userDTO));
    }

    @GetMapping("/getall")
    public ResponseEntity<ResponseUtil> getAllUser() {
        List<UserDTO> companyDTOList = userService.getAll();
        return ResponseEntity.ok(new ResponseUtil(200, "Success", companyDTOList));
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<ResponseUtil> deleteUser(@PathVariable int id) {
        userService.delete(id);
        return ResponseEntity.ok(new ResponseUtil(200, "User deleted successfully", null));
    }

    @PutMapping("/update")
    public ResponseEntity<ResponseUtil> updateUser(@PathVariable int id, @RequestBody UserDTO userDTO) {
        UserDTO updatedUser = userService.update( userDTO);
        return ResponseEntity.ok(new ResponseUtil(200, "User updated successfully", updatedUser));
    }

}
