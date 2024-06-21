package com.fooddelivery.foodcatalogue_service.entity;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class FoodItem {
    @jakarta.persistence.Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long Id;
    private String ItemName;
    private String ItemDescription;
    private boolean isVeg;
    private Number price;
    @Column(nullable = false)
    private Integer restaurantId;
    @Column(nullable = false,columnDefinition = "INT DEFAULT 0")
    private Integer quantity;
}
