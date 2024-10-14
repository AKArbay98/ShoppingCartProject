package com.example.shoppingcarddemo.service.abstractservice;

import com.example.shoppingcarddemo.model.dto.ProductDTO;

import java.util.List;

public interface ProductService {

    void deleteProductById(Long id);
    List<ProductDTO> fetchAllProduct();
    ProductDTO getProductById(Long id);
    void createProduct(ProductDTO productDTO);
    void updateProduct(Long id, ProductDTO productDTO);
}
