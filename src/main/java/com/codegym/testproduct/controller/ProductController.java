package com.codegym.testproduct.controller;

import com.codegym.testproduct.model.Product;
import com.codegym.testproduct.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.util.List;
import java.util.Optional;
@RestController
@CrossOrigin("*")
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private IProductService productService;

    @GetMapping
    public ResponseEntity<Iterable<Product>> findAllProduct() {
        List<Product> products = (List<Product>) productService.findAll();
        if (products.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Product> findProductById(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(productOptional.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Product> saveProduct(@RequestParam("file") MultipartFile file, Product product) {
        String fileName = file.getOriginalFilename();
        product.setImg(fileName);
        try {
            file.transferTo(new File("D:\\Module3\\CSS\\untitled1\\Image\\" + fileName));
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.ok(productService.save(product));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Product> updateProduct(@PathVariable Long id, @RequestParam("file") MultipartFile file, Product product) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        product.setId(productOptional.get().getId());
        if (product.getImg()!=null){
            String fileName = file.getOriginalFilename();
            product.setImg(fileName);
            try {
                file.transferTo(new File("D:\\Module3\\CSS\\untitled1\\Image\\" + fileName));
            } catch (Exception e) {
                return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
            }
        }else product.setImg(productOptional.get().getImg());
        return new ResponseEntity<>(productService.save(product), HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Product> deleteProduct(@PathVariable Long id) {
        Optional<Product> productOptional = productService.findById(id);
        if (!productOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        productService.remove(id);
        return new ResponseEntity<>(productOptional.get(), HttpStatus.NO_CONTENT);
    }
    @GetMapping("/search")
    public ResponseEntity<Iterable<Product>> findAllByNameContainingProduct(@RequestParam String name) {
        Iterable<Product> products = productService.findByName(name);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }

    @GetMapping("/order-by-price")
    public ResponseEntity<Iterable<Product>> findAllByOrderByPrice() {
        Iterable<Product> products = productService.sortByPrice();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @GetMapping("/top4")
    public ResponseEntity<Iterable<Product>> getTop4() {
        Iterable<Product> products = productService.getTop4();
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @GetMapping("/findByCategory_name")
    public ResponseEntity<Iterable<Product>> findByCategory_name(@RequestParam String name){
        Iterable<Product> products = productService.findByCategory_name(name);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
    @GetMapping("/price-between")
    public ResponseEntity<Iterable<Product>> findByPriceBetween(@RequestParam double from,@RequestParam double to){
        Iterable<Product> products = productService.findByPriceBetween(from,to);
        return new ResponseEntity<>(products, HttpStatus.OK);
    }
}
