package com.walmartapi.mapper.impl;

import com.walmartapi.entity.ProductEntity;
import com.walmartapi.mapper.CustomObjectManager;
import com.walmartapi.model.Product;
import org.springframework.stereotype.Component;

@Component
public class ProductMapper implements CustomObjectManager<ProductEntity, Product> {
    @Override
    public ProductEntity mapToEntity(Product dto) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setDescription(dto.getDescription());
        productEntity.setName(dto.getName());
        productEntity.setPrice(dto.getPrice());
        return productEntity;
    }

    @Override
    public Product mapToDto(ProductEntity entity) {
        return null;
    }
}
