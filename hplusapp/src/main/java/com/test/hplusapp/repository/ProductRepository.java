package com.test.hplusapp.repository;

import com.test.hplusapp.Entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Integer> {

    // this query is in form of JPQL.
    @Query("SELECT p FROM Product p WHERE p.name like %:productName%")
    List<Product> productsByName(@Param("productName") String productName);

}
