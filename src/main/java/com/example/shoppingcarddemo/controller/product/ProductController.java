package com.example.shoppingcarddemo.controller.product;


import com.example.shoppingcarddemo.model.dto.ProductDTO;
import com.example.shoppingcarddemo.service.abstractservice.ProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/products")
    public ResponseEntity<List<ProductDTO>> getAllProduct(){
        List<ProductDTO> products = productService.fetchAllProduct();
        return ResponseEntity.ok(products);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<ProductDTO> getProduct(@PathVariable Long id){
        ProductDTO productById = productService.getProductById(id);
        return ResponseEntity.ok(productById);
    }

    @PostMapping("/product")
    @ResponseStatus(HttpStatus.CREATED)
    public void createProduct(@RequestBody ProductDTO productDTO){
        productService.createProduct(productDTO);
    }

    @PutMapping("/product/{id}")
    public void updateProduct(@PathVariable("id") Long id, @RequestBody ProductDTO productDTO){
        productService.updateProduct(id, productDTO);
    }

    @DeleteMapping("/product/{id}")
    public void deleteProduct(@PathVariable Long id){
        productService.deleteProductById(id);
    }

}
