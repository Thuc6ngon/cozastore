package com.cybersoft.cozastoreJava21.Repository;

import com.cybersoft.cozastoreJava21.Entity.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository<CategoryEntity,Integer> {
}
