package com.example.shoppingcarddemo.model.dto;

import com.example.shoppingcarddemo.model.entity.rating.Rating;
import lombok.*;

import java.math.BigDecimal;
import java.util.List;


@Getter
@Setter
@Data
public class ProductDTO {

    private String name;
    private String description;
    private BigDecimal price;
    private Integer quantity;
    private List<CommentDTO> commentList;
    private CartDTO cart;
    private OrderDTO order;
    private Rating rating;

    public ProductDTO(String name, String description, BigDecimal price, Integer quantity, List<CommentDTO> commentList, CartDTO cart, OrderDTO order, Rating rating) {
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

    public CommentDTO getCommentList() {
        return (CommentDTO) commentList;
    }

    public void setCommentList(List<CommentDTO> commentList) {
        this.commentList = commentList;
    }

    public CartDTO getCart() {
        return cart;
    }

    public void setCart(CartDTO cart) {
        this.cart = cart;
    }

    public OrderDTO getOrder() {
        return order;
    }

    public void setOrder(OrderDTO order) {
        this.order = order;
    }

    public Rating getRating() {
        return rating;
    }

    public void setRating(Rating rating) {
        this.rating = rating;
    }
}
