package com.smartchoice.product.repository;

import com.smartchoice.product.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findByNameContainsIgnoreCase(String productName);
    @Query("SELECT p FROM Product p JOIN FETCH p.contents WHERE p.id = (:id)")
    Optional<Product> loadDetailsById(@Param("id") Long id);
}
