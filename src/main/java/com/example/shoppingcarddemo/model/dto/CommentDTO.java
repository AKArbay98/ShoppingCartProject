package com.example.shoppingcarddemo.model.dto;


import lombok.*;


@Getter
@Setter
@Data
public class CommentDTO {

    private String content;
    private ProductDTO product;

    public CommentDTO(String content, ProductDTO product) {
        this.content = content;
        this.product = product;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public ProductDTO getProduct() {
        return product;
    }

    public void setProduct(ProductDTO product) {
        this.product = product;
    }
}
