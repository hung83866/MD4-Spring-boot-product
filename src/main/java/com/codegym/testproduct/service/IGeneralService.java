package com.codegym.testproduct.service;

import com.codegym.testproduct.model.Product;

import java.util.Optional;

public interface IGeneralService<T> {
    Iterable<T> findAll();

    Optional<T> findById(Long id);

    T save(T t);

    void remove(Long id);

    Iterable<T> findByName(String name);

    Iterable<T> sortByPrice();

    Iterable<Product> getTop4();

    Iterable<Product> findByCategory_name(String name);

    Iterable<Product> findByPriceBetween(double from,double to);
}
