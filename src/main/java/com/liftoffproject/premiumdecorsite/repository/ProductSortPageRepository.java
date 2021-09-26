package com.liftoffproject.premiumdecorsite.repository;

import com.liftoffproject.premiumdecorsite.model.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface ProductSortPageRepository extends PagingAndSortingRepository<Product, Long> {
    Page<Product> findAll(Pageable pageable);
}