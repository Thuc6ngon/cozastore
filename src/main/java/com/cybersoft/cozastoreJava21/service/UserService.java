package com.cybersoft.cozastoreJava21.Service;

import com.cybersoft.cozastoreJava21.Entity.UserEntity;
import com.cybersoft.cozastoreJava21.Exception.CustomException;
import com.cybersoft.cozastoreJava21.payload.request.SignupRequest;
import com.cybersoft.cozastoreJava21.Repository.UserRepository;
import com.cybersoft.cozastoreJava21.Service.IMP.UserServiceImp;
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
    public boolean addUser(SignupRequest request) {
        boolean isSuccess = false;
        try{
//            throw new RuntimeException();
            UserEntity user = new UserEntity();
            user.setUsername(request.getUsername());
            user.setPassword(passwordEncoder.encode(request.getPassword()));
            user.setEmail(request.getEmail());

            userRepository.save(user);
            isSuccess = true;
        }catch (Exception e){
            throw new CustomException("loi"+e.getMessage());
        }


        return isSuccess;
    }
}
