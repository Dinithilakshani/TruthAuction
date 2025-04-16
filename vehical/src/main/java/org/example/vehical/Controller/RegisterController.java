package org.example.vehical.Controller;

import org.example.vehical.Service.UserService;
import org.example.vehical.dto.UserDTO;
import org.example.vehical.util.ResponseUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/register")
@CrossOrigin(origins = "*")
public class RegisterController {
    @Autowired
    UserService userService;

    @PostMapping("/user")
    public ResponseEntity<ResponseUtil> registerUser(@RequestBody UserDTO userDTO) {
        try {
            userService.save(userDTO);
            return ResponseEntity.status(HttpStatus.CREATED).body(new ResponseUtil(201, "User registered successfully", null));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new ResponseUtil(500, e.getMessage(), null));
        }

    }

}
