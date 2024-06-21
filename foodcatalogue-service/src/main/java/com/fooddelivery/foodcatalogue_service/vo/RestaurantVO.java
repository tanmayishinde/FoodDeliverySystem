package com.fooddelivery.foodcatalogue_service.vo;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RestaurantVO {
    private Long Id;
    private String Name;
    private String Address;
    private String City;
    private String RestaurantDescription;
}
