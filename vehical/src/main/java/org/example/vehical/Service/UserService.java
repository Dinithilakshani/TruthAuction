package org.example.vehical.Service;

import org.example.vehical.dto.AuthTokenDTO;
import org.example.vehical.dto.UserDTO;
import org.example.vehical.dto.UserLoginDTO;

import java.util.List;

public interface UserService {
    public void save(UserDTO userDTO);
    public UserDTO getById(int id);

    public List<UserDTO> getAll();

    public UserDTO update(UserDTO userDTO);
    public void delete(int id) ;

    AuthTokenDTO verifyUser(UserLoginDTO userLoginDTO);
}
