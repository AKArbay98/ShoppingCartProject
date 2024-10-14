package com.example.shoppingcarddemo.model.entity.comment;

import com.example.shoppingcarddemo.model.entity.baseentityaudit.BaseEntityAudit;
import com.example.shoppingcarddemo.model.entity.product.Product;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name="comment")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Comment extends BaseEntityAudit {

    @Column(name="content", length=50, nullable=false, unique=false)
    private String content;

    @ManyToOne
    @JoinColumn(name="product_id", nullable=false)
    private Product product;

    public Comment(String content, Product product) {
        this.content = content;
        this.product = product;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }
}
