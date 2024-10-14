package com.example.shoppingcarddemo.model.mapper.productmapper;


import com.example.shoppingcarddemo.model.dto.ProductDTO;
import com.example.shoppingcarddemo.model.entity.product.Product;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ProductMapper {

    ProductMapper INSTANCE = Mappers.getMapper(ProductMapper.class);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "commentList", target = "commentList")
    @Mapping(source = "cart", target = "cart")
    @Mapping(source = "order", target = "order")
    @Mapping(source = "rating", target = "rating")
    ProductDTO productToProductDTO(Product product);

    @Mapping(source = "name", target = "name")
    @Mapping(source = "description", target = "description")
    @Mapping(source = "price", target = "price")
    @Mapping(source = "quantity", target = "quantity")
    @Mapping(source = "commentList", target = "commentList")
    @Mapping(source = "cart", target = "cart")
    @Mapping(source = "order", target = "order")
    @Mapping(source = "rating", target = "rating")
    Product productDtoToProduct(ProductDTO productDTO);
}
