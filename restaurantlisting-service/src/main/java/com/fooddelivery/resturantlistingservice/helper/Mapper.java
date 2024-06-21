package com.fooddelivery.resturantlistingservice.helper;

import com.fooddelivery.resturantlistingservice.entity.RestaurantEntity;
import com.fooddelivery.resturantlistingservice.vo.RestaurantRequestVO;
import com.fooddelivery.resturantlistingservice.vo.RestaurantResponseVO;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;

@Component
public class Mapper {
    public  RestaurantEntity ResurantVOToEntity(RestaurantRequestVO resturantVO){
        RestaurantEntity entity=new RestaurantEntity();
        entity.setName(resturantVO.getName());
        entity.setCity(resturantVO.getCity());
        entity.setAddress(resturantVO.getAddress());
        entity.setRestaurantDescription(resturantVO.getRestaurantDescription());
        return entity;
    }
    public List<RestaurantResponseVO> ListEntityToListVO(List<RestaurantEntity> entityList){
        List<RestaurantResponseVO> voConvert = new ArrayList<>();
        for(RestaurantEntity entity:entityList){
            RestaurantResponseVO vo =  Mapper.ResurantEntityToVO(entity);
           voConvert.add(vo);
        }
        return  voConvert;
    }
    public  static RestaurantResponseVO ResurantEntityToVO(RestaurantEntity entity){
        RestaurantResponseVO vo=new RestaurantResponseVO();
        vo.setId(entity.getId());
        vo.setName(entity.getName());
        vo.setCity(entity.getCity());
        vo.setAddress(entity.getAddress());
        vo.setRestaurantDescription(entity.getRestaurantDescription());
        return vo;
    }
}
