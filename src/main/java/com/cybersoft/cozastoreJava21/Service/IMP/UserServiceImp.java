package com.cybersoft.cozastoreJava21.Service.IMP;

import com.cybersoft.cozastoreJava21.payload.request.SignUpRequest;

public interface UserServiceImp {
    boolean addUser(SignUpRequest request);
}
