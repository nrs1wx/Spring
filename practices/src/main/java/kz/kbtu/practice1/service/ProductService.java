package kz.kbtu.practice1.service;

import kz.kbtu.practice1.entity.Product;
import kz.kbtu.practice1.repository.ProductRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class ProductService {

    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Page<Product> getAll(Pageable pageable) {
        return repository.findAll(pageable);
    }

    public Page<Product> getByCategory(String category, Pageable pageable) {
        return repository.findByCategory(category, pageable);
    }

    public Page<Product> search(String name, Pageable pageable) {
        return repository.findByNameContainingIgnoreCase(name, pageable);
    }
}