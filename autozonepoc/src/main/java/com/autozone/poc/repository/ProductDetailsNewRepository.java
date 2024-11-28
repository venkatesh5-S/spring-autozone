package com.autozone.poc.repository;

import com.autozone.poc.entity.ProductDetailsNew;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductDetailsNewRepository extends JpaRepository<ProductDetailsNew,Integer> {
}
