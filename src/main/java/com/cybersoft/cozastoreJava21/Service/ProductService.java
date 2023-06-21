package com.cybersoft.cozastoreJava21.Service;

import com.cybersoft.cozastoreJava21.Entity.ProductEntity;
import com.cybersoft.cozastoreJava21.Repository.ProductRepository;
import com.cybersoft.cozastoreJava21.Service.IMP.ProductServiceImp;
import com.cybersoft.cozastoreJava21.payload.response.ProductResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class ProductService implements ProductServiceImp {
@Autowired
private ProductRepository productRepository;
    @Override
    public List<ProductResponse> getProductByCategoryID(int id) {
        List<ProductEntity>list=productRepository.findByCategoryId(id);
        List<ProductResponse> listResponse=new ArrayList<>();
        for (ProductEntity data: list){
            ProductResponse productResponse=new ProductResponse();
            productResponse.setId(data.getId());
            productResponse.setName(data.getName());
            productResponse.setPrice(data.getPrice());
            productResponse.setImage(data.getImage());
            listResponse.add(productResponse);
        }
            return listResponse;
    }
}
