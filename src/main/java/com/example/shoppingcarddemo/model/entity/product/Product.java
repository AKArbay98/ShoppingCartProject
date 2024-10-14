package com.example.shoppingcarddemo.model.entity.product;

import com.example.shoppingcarddemo.model.entity.baseentityaudit.BaseEntityAudit;
import com.example.shoppingcarddemo.model.entity.cart.Cart;
import com.example.shoppingcarddemo.model.entity.comment.Comment;
import com.example.shoppingcarddemo.model.entity.order.Order;
import com.example.shoppingcarddemo.model.entity.rating.Rating;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name="product")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Product extends BaseEntityAudit {

    @Column(name="name", length=50, nullable=false, unique=false)
    private String name;

    @Column(name="description", length=50, nullable=true, unique=false)
    private String description;

    @Column(name="price", length=50, nullable=false, unique=false)
    private BigDecimal price;

    @Column(name="quantity", length=50, nullable=false, unique=false)
    private Integer quantity;

    @OneToMany(mappedBy = "comment")
    private List<Comment> commentList;

    @ManyToOne
    @JoinColumn(name="cart_id", nullable=false)
    private Cart cart;

    @ManyToOne
    @JoinColumn(name="order_id", nullable=false)
    private Order order;

    @Enumerated(EnumType.STRING)
    @Column(name = "rating", length = 20, nullable = false)
    private Rating rating;

    @Column(name="is_inStock")
    public boolean isInStock() {
        return quantity != null && quantity > 0;
    }

    public Product(String name, String description, BigDecimal price, Integer quantity, List<Comment> commentList, Cart cart, Order order, Rating rating) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.quantity = quantity;
        this.commentList = commentList;
        this.cart = cart;
        this.order = order;
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public List<Comment> getCommentList() {
        return commentList;
    }

    public void setCommentList(List<Comment> commentList) {
        this.commentList = commentList;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
}
