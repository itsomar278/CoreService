package com.CoreService.QP.CoreService.repository;

import com.CoreService.QP.CoreService.model.CategoryEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CategoryRepository extends JpaRepository< CategoryEntity,Integer> {
}
