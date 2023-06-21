package com.cybersoft.cozastoreJava21.Repository;

import com.cybersoft.cozastoreJava21.Entity.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Integer> {
    List<ProductEntity> findByCategoryId (int idCategory);

}
