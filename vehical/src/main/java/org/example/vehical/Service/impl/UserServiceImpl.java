package org.example.vehical.Service.impl;

import org.example.vehical.Repo.CompanyRepo;
import org.example.vehical.Repo.UserRepository;
import org.example.vehical.Service.JWTService;
import org.example.vehical.Service.UserService;
import org.example.vehical.dto.AuthTokenDTO;
import org.example.vehical.dto.UserDTO;
import org.example.vehical.dto.UserLoginDTO;
import org.example.vehical.enitity.Company;
import org.example.vehical.enitity.User;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CompanyRepo companyRepo;

    @Autowired
    AuthenticationManager authenticationManager;

    @Autowired
    private ModelMapper modelMapper;

    @Autowired
    JWTService jwtService;

    @Override
    public void save(UserDTO userDTO) {
        if (userRepository.existsById(userDTO.getId())) {
            throw new RuntimeException("User already exists");
        }

        Optional<Company> optionalCompany = companyRepo.findById(userDTO.getCompany_id());
        if (optionalCompany.isEmpty()) {
            throw new RuntimeException("Company not found");
        }

        User user = modelMapper.map(userDTO, User.class);
        user.setCompany(optionalCompany.get());
        userRepository.save(user);
    }

    @Override
    public UserDTO getById(int id) {
        Optional<User> optionalUser = userRepository.findById(id);
        if (optionalUser.isPresent()) {
            return modelMapper.map(optionalUser.get(), UserDTO.class);
        }
        throw new RuntimeException("User not found with id: " + id);
    }

    @Override
    public List<UserDTO> getAll() {
        List<User> users = userRepository.findAll();
        return modelMapper.map(users, new TypeToken<List<UserDTO>>() {}.getType());
    }

    @Override
    public UserDTO update(UserDTO userDTO) {
        if (!userRepository.existsById(userDTO.getId())) {
            throw new RuntimeException("User does not exist");
        }

        Optional<Company> optionalCompany = companyRepo.findById(userDTO.getCompany_id());
        if (optionalCompany.isEmpty()) {
            throw new RuntimeException("Company not found");
        }

        User user = modelMapper.map(userDTO, User.class);
        user.setCompany(optionalCompany.get());

        userRepository.save(user);
        return modelMapper.map(user, UserDTO.class);
    }

    @Override
    public void delete(int id) {
        if (!userRepository.existsById(id)) {
            throw new RuntimeException("User does not exist");
        }
        userRepository.deleteById(id);
    }

    @Transactional
    @Override
    public AuthTokenDTO verifyUser(UserLoginDTO userLoginDTO) {
        Optional<User> optionalUser =userRepository.findByUsername(userLoginDTO.getUsername());
        AuthTokenDTO authTokenDTO = new AuthTokenDTO();
        if (optionalUser.isPresent()) {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(userLoginDTO.getUsername(),userLoginDTO.getPassword()));
            if (authentication.isAuthenticated()){

                authTokenDTO.setAuthenticated(true);
                authTokenDTO.setToken(jwtService.generateToken(userLoginDTO.getUsername()));
                authTokenDTO.setMessage("Success");
                return authTokenDTO;
            }
            authTokenDTO.setAuthenticated(false);
            authTokenDTO.setMessage("Fail");
            return authTokenDTO;
        }
        authTokenDTO.setAuthenticated(false);
        authTokenDTO.setMessage("Patient not found");
        return authTokenDTO;
    }

    @Override
    public UserDTO findByEmail(String email) {

        Optional<User> user = userRepository.findByEmail(email);
        if (user == null) {
            throw new UsernameNotFoundException("User not found with email: " + email);
        }
        return modelMapper.map(user, UserDTO.class);
    }
}
