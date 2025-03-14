package org.example.vehical.Controller;

import org.example.vehical.Service.UserService;
import org.example.vehical.dto.UserDTO;
import org.example.vehical.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1/users")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/save")
        public ResponseEntity<ResponseUtil> saveUser(@RequestBody UserDTO userDTO) {
            userService.save(userDTO);
            return ResponseEntity.ok(new ResponseUtil(200, "Company saved successfully", null));
        }


    @GetMapping("/{id}")
    public ResponseEntity<ResponseUtil> getUserById(@PathVariable int id) {
        UserDTO userDTO = userService.getById(id);
        return ResponseEntity.ok(new ResponseUtil(200, "Success", userDTO));
    }
    }

