package org.example.vehical.Service.impl;

import org.example.vehical.Repo.CompanyRepo;
import org.example.vehical.Repo.CompanyTypeRepo;
import org.example.vehical.Repo.UserRepository;
import org.example.vehical.Service.UserService;
import org.example.vehical.dto.UserDTO;
import org.example.vehical.enitity.Company;
import org.example.vehical.enitity.CompanyType;
import org.example.vehical.enitity.Sale;
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
    private CompanyRepo companyRepo;

    @Autowired
    private ModelMapper modelMapper;

@Override
        public void save(UserDTO userDTO) {


    try {
        Optional<User> optionalUser = userRepository.findById(userDTO.getId());
        if (optionalUser.isPresent()) {
            throw new RuntimeException("user already exists");
        }

        Optional<Company> optionalCompanyType = companyRepo.findById(userDTO.getCompany_id());
        if (optionalCompanyType.isEmpty()) throw new RuntimeException("USer not found");

        User user = modelMapper.map(userDTO, User.class);
        user.setCompany(optionalCompanyType.get());
        userRepository.save(user);
    } catch (Exception e) {
        e.printStackTrace();
    }
}

@Override
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
