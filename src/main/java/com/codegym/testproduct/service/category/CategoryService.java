package com.codegym.testproduct.service.category;

import com.codegym.testproduct.model.Category;
import com.codegym.testproduct.model.Product;
import com.codegym.testproduct.repository.ICategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CategoryService implements ICategoryService{
    @Autowired
    ICategoryRepository categoryRepository;

    @Override
    public Iterable<Category> findAll() {
        return categoryRepository.findAll();
    }

    @Override
    public Optional<Category> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public Category save(Category category) {
        return null;
    }

    @Override
    public void remove(Long id) {

    }

    @Override
    public Iterable<Category> findByName(String name) {
        return null;
    }

    @Override
    public Iterable<Category> sortByPrice() {
        return null;
    }

    @Override
    public Iterable<Product> getTop4() {
        return null;
    }

    @Override
    public Iterable<Product> findByCategory_name(String name) {
        return null;
    }

    @Override
    public Iterable<Product> findByPriceBetween(double from, double to) {
        return null;
    }
}
