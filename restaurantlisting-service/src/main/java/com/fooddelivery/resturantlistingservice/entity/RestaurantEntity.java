package com.fooddelivery.resturantlistingservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@Table(name = "Restaurant")
public class RestaurantEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name ="Restaurant_Id")
    private Long Id;

    @Column(name = "RestaurantName")
    private String Name;
    @Column(name = "RestaurantAddress")
    private String Address;
    @Column(name = "RestaurantCity")
    private String City;
    private String RestaurantDescription;

}
