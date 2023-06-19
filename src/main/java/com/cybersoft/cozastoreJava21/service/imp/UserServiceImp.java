package com.cybersoft.cozastoreJava21.service.imp;


import com.cybersoft.cozastoreJava21.payload.request.SignupRequest;

public interface UserServiceImp {
    boolean addUser(SignupRequest request);
}
