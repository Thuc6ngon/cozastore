package com.cybersoft.cozastoreJava21.Service;

import com.cybersoft.cozastoreJava21.Entity.CategoryEntity;
import com.cybersoft.cozastoreJava21.Repository.CategoryRepository;
import com.cybersoft.cozastoreJava21.Service.IMP.CategoryServiceImp;
import com.cybersoft.cozastoreJava21.payload.response.CategoryRespone;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
@Service
public class CategoryService implements CategoryServiceImp {

    @Autowired
    private CategoryRepository categoryRepository;
    @Override
    public List<CategoryRespone> getAllCategory() {
        List<CategoryEntity> list =categoryRepository.findAll();
        List<CategoryRespone>responselist=new ArrayList<>();
        for(CategoryEntity data: list){
        CategoryRespone categoryRespone=new CategoryRespone();
        categoryRespone.setId(data.getId());
         categoryRespone.setName(data.getName());
         responselist.add(categoryRespone);
        }
        return responselist;
    }
}
