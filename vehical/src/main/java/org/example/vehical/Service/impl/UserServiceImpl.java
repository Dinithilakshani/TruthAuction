package org.example.vehical.Service.impl;

import org.example.vehical.Repo.UserRepository;
import org.example.vehical.Service.UserService;
import org.example.vehical.dto.UserDTO;
import org.example.vehical.enitity.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ModelMapper modelMapper;


        public void save(UserDTO userDTO) {
            UserDTO userDTO1 = new UserDTO();
            int id = userDTO1.getId();
            if(userRepository.existsById(userDTO.getId())){
                throw new RuntimeException("companyType already exists");
            }
            userRepository.save(modelMapper.map(userDTO, User.class));
        }

    public UserDTO getById(int id) {
        Optional<User> optionalCustomer = userRepository.findById(id);
        if (optionalCustomer.isPresent()) {
            return modelMapper.map(optionalCustomer.get(), UserDTO.class);
        }
        throw new RuntimeException("companyType not found");
    }
    @Override
    public List<UserDTO> getAll() {
        List<User> users = userRepository.findAll();
        return modelMapper.map(users, new TypeToken<List<UserDTO>>(){}.getType());
    }
    @Override
    public UserDTO update(UserDTO userDTO) {
        if (!userRepository.existsById(userDTO.getId())) {
            throw new RuntimeException("Company does not exist");
        }
        User user = modelMapper.map(userDTO, User.class);
        userRepository.save(user);
        return userDTO;
    }

    @Override
    public void delete(int id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("Item does not exist");
        }
        userRepository.deleteById(id);
    }

}
