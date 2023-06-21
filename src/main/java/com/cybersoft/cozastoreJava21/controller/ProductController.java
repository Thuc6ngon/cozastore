package com.cybersoft.cozastoreJava21.controller;

import com.cybersoft.cozastoreJava21.Service.IMP.ProductServiceImp;
import com.cybersoft.cozastoreJava21.Service.ProductService;
import com.cybersoft.cozastoreJava21.payload.response.BaseResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductServiceImp productServiceImp;

    @GetMapping("/category/{id}")
    public ResponseEntity<?>getProductByCategory(@PathVariable int id){
        BaseResponse response=new BaseResponse();
        response.setStatusCode(200);
        response.setData(productServiceImp.getProductByCategoryID(id));

    return new ResponseEntity<>(response , HttpStatus.OK);
    }
}
