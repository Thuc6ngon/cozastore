package com.cybersoft.cozastoreJava21.Service;

import com.cybersoft.cozastoreJava21.Entity.UserEntity;
import com.cybersoft.cozastoreJava21.Repository.UserRepository;
import com.cybersoft.cozastoreJava21.Service.IMP.UserServiceImp;
import com.cybersoft.cozastoreJava21.payload.request.SignUpRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserServiceImp {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private PasswordEncoder passwordEncoder;
    @Override
    public boolean addUser(SignUpRequest request) {
        boolean isSuccess = false;

        try {
            UserEntity user = new UserEntity();
            user.setUsername(request.getUsername());
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            user.setEmail(request.getEmail());

            userRepository.save(user);
            isSuccess =true;

        } catch (Exception e) {

        }
        return isSuccess;

    }
}
