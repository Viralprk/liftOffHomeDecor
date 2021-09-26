package com.liftoffproject.premiumdecorsite.service;

import com.liftoffproject.premiumdecorsite.model.Product;
import com.liftoffproject.premiumdecorsite.repository.ProductRepository;
import com.liftoffproject.premiumdecorsite.repository.ProductSortPageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class ProductServiceImpl implements ProductService
{

    @Autowired
    private ProductRepository ProductRepository;

    @Autowired
    private ProductSortPageRepository ProductSortPageRepository;

    @Override
    public void deleteProductById(long id) {
        this.ProductRepository.deleteById(id);
    }

    @Override
    public Page<Product> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ?
                Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        Pageable pageable = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.ProductSortPageRepository.findAll(pageable);
    }

    @Override
    public List<Product> getAllProducts() {
        return ProductRepository.findAll();
    }

    @Override
    public void saveProduct(Product Product) {
        this.ProductRepository.save(Product);
    }

    @Override
    public Product getProductById(long id) {
        Optional<Product> optional = ProductRepository.findById(id);
        Product Product = null;
        if (optional.isPresent()) {
            Product = optional.get();
        } else {
            throw new RuntimeException(" Product not found for id :: " + id);
        }
        return Product;
    }


}