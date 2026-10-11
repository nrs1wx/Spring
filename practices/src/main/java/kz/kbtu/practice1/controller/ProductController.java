package kz.kbtu.practice1.controller;

import kz.kbtu.practice1.entity.Product;
import kz.kbtu.practice1.service.ProductService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @GetMapping
    public Page<Product> getAll(Pageable pageable) {
        return service.getAll(pageable);
    }

    @GetMapping("/category/{category}")
    public Page<Product> byCategory(@PathVariable String category, Pageable pageable) {
        return service.getByCategory(category, pageable);
    }

    @GetMapping("/search")
    public Page<Product> search(@RequestParam String name, Pageable pageable) {
        return service.search(name, pageable);
    }
}