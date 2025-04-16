package org.example.vehical.Controller;

import org.example.vehical.Service.UserService;
import org.example.vehical.dto.UserDTO;
import org.example.vehical.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@CrossOrigin(origins = "*")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/addUser")
    public ResponseEntity<ResponseUtil> saveUser(@RequestBody UserDTO userDTO) {
        userService.save(userDTO);
        return ResponseEntity.ok(new ResponseUtil(200, "User saved successfully", null));
    }

    @GetMapping("/getById/{id}")
    public ResponseEntity<ResponseUtil> getUserById(@PathVariable int id) {
        UserDTO userDTO = userService.getById(id);
        return ResponseEntity.ok(new ResponseUtil(200, "Success", userDTO));
    }

    @GetMapping("/getall")
    public ResponseEntity<ResponseUtil> getAllUser() {
        List<UserDTO> userDTOList = userService.getAll();
        return ResponseEntity.ok(new ResponseUtil(200, "Success", userDTOList));
    }

    @DeleteMapping("/deleteUser/{id}")
    public ResponseEntity<ResponseUtil> deleteUser(@PathVariable int id) {
        userService.delete(id);
        return ResponseEntity.ok(new ResponseUtil(200, "User deleted successfully", null));
    }

    @PutMapping("/updateUser/{id}")
    public ResponseEntity<ResponseUtil> updateUser(@PathVariable int id, @RequestBody UserDTO userDTO) {
        userDTO.setId(id); // Ensure the DTO carries the ID
        UserDTO updatedUser = userService.update(userDTO);
        return ResponseEntity.ok(new ResponseUtil(200, "User updated successfully", updatedUser));
    }
}
