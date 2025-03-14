package org.example.vehical.Service;

import org.example.vehical.dto.UserDTO;
import org.example.vehical.enitity.User;

public interface UserService {
    public void save(UserDTO userDTO);
    public UserDTO getById(int id);
}
