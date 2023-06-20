package com.cybersoft.cozastoreJava21.Service.IMP;


import com.cybersoft.cozastoreJava21.payload.request.SignupRequest;

public interface UserServiceImp {
    boolean addUser(SignupRequest request);
}
