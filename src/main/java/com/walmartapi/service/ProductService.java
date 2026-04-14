package com.walmartapi.service;

import com.walmartapi.entity.ProductEntity;
import com.walmartapi.exception.NotFound;
import com.walmartapi.mapper.CustomObjectManager;
import com.walmartapi.model.Product;
import com.walmartapi.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository productRepository;
    private final CustomObjectManager<ProductEntity, Product> productMapper;

    public ProductService(ProductRepository productRepository, CustomObjectManager<ProductEntity, Product> productMapper) {
        this.productRepository = productRepository;
        this.productMapper = productMapper;
    }

    public Product saveProduct(Product product) {
        ProductEntity newProduct = productMapper.mapToEntity(product);
        ProductEntity savedEntity = productRepository.save(newProduct);
        return productMapper.mapToDto(savedEntity);
    }

    public Product getProductById(Long id) {
        Optional<ProductEntity> product = productRepository.findById(id);
        if (product.isEmpty()){
            throw new NotFound("Product not found :c");
        }
        return productMapper.mapToDto(product.get());
    }

    public Product updateProduct(Long id, Product product) {
        Optional<ProductEntity> currentProduct = productRepository.findById(id);

        //Lanzamos errorsito uff
        if (currentProduct.isEmpty()) { throw new NotFound("Product not found :c"); }

        //Asignamos la nueva info
        ProductEntity updatedProduct = productMapper.mapToEntity(product);
        updatedProduct.setId(id);
        ProductEntity updatedEntity = productRepository.save(updatedProduct);

        return productMapper.mapToDto(updatedEntity);
    }

    public void deleteProduct(Long id) {
        //Lanzamos errorsito uff
        if (!productRepository.existsById(id)) { throw new NotFound("Product not found :c"); }
        productRepository.deleteById(id); //adios mundo cruel
    }
}