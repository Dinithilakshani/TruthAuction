package org.example.vehical.Service;

import org.example.vehical.dto.UserDTO;

import java.util.List;

public interface UserService {
    public void save(UserDTO userDTO);
    public UserDTO getById(int id);

    public List<UserDTO> getAll();

    public UserDTO update(UserDTO userDTO);
    public void delete(int id) ;
}
