package org.example.vehical.Service.impl;

import org.example.vehical.Repo.UserRepository;
import org.example.vehical.Service.UserService;
import org.example.vehical.dto.CompanyTypeDTO;
import org.example.vehical.dto.UserDTO;
import org.example.vehical.enitity.CompanyType;
import org.example.vehical.enitity.User;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
