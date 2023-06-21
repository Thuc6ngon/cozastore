package com.cybersoft.cozastoreJava21.Exception;

import com.cybersoft.cozastoreJava21.payload.response.BaseResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalCustomException {
    // nơi đăng kí các exception sẽ kích hoạt code bên trong hàm
    @ExceptionHandler(Filenotfoundexception.class)
    public ResponseEntity<?>handleUserNotFound(Exception e){
        BaseResponse response=new BaseResponse();
        response.setStatusCode(500);
        response.setData(e.getMessage());
    return new ResponseEntity<>(response, HttpStatus.OK);
    }
    @ExceptionHandler(CustomException.class)
    public ResponseEntity<?> handleCustomException(CustomException e){
        BaseResponse response=new BaseResponse();
        response.setStatusCode(500);
        response.setData(e.getMessage());
        return new ResponseEntity<>(response, HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
