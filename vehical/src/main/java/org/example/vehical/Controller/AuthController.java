package org.example.vehical.Controller;

import org.example.vehical.Service.UserService;
import org.example.vehical.dto.AuthTokenDTO;
import org.example.vehical.dto.UserLoginDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/auth/login")
public class AuthController {
    @Autowired
    UserService userService;

    @PostMapping("/verify")
    public AuthTokenDTO verify(@RequestBody UserLoginDTO userLoginDTO) {
        return userService.verifyUser(userLoginDTO);
    }

}
