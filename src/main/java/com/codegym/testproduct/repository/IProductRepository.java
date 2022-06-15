package com.codegym.testproduct.repository;

import com.codegym.testproduct.model.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IProductRepository extends PagingAndSortingRepository<Product, Long> {
    Iterable<Product> findAllByNameContaining(String name);

    Iterable<Product> findAllByOrderByPrice();

    @Query(value = "select * from product order by id desc LIMIT 4", nativeQuery = true)
    Iterable<Product> getTop4();

    Iterable<Product> findByCategory_Name(String name);

    Iterable<Product> findByPriceBetween(double from,double to);

}
