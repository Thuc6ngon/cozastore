package com.cybersoft.cozastoreJava21.Service.IMP;

import com.cybersoft.cozastoreJava21.payload.response.ProductResponse;

import java.util.List;

public interface ProductServiceImp  {
    List<ProductResponse> getProductByCategoryID(int id);
}
