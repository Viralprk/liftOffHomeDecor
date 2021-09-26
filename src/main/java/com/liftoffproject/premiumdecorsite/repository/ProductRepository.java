package com.liftoffproject.premiumdecorsite.repository;


import com.liftoffproject.premiumdecorsite.model.Product;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends CrudRepository<Product, Long> {
    List<Product> findAll();

}
