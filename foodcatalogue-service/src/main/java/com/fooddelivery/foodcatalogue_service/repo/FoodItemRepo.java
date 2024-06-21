package com.fooddelivery.foodcatalogue_service.repo;

import com.fooddelivery.foodcatalogue_service.entity.FoodItem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodItemRepo extends JpaRepository<FoodItem,Long> {
}
