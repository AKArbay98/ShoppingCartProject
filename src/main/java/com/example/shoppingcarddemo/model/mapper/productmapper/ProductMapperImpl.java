package com.example.shoppingcarddemo.model.mapper.productmapper;

import com.example.shoppingcarddemo.model.dto.ProductDTO;
import com.example.shoppingcarddemo.model.entity.product.Product;

public class ProductMapperImpl {

    private final ProductMapper productMapper;

    public ProductMapperImpl(ProductMapper productMapper) {
        this.productMapper = productMapper;
    }

    public ProductDTO convertProductToProductDto(Product product){
        return productMapper.productToProductDTO(product);
    }

    public Product convertProductDtoToProduct(ProductDTO productDTO){
        return productMapper.productDtoToProduct(productDTO);
    }
}
