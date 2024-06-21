package com.fooddelivery.resturantlistingservice.impl;

import com.fooddelivery.resturantlistingservice.entity.RestaurantEntity;
import com.fooddelivery.resturantlistingservice.exception.ResourceNotFoundException;
import com.fooddelivery.resturantlistingservice.helper.Mapper;
import com.fooddelivery.resturantlistingservice.repo.RestaurantRepo;
import com.fooddelivery.resturantlistingservice.service.ResturantService;
import com.fooddelivery.resturantlistingservice.util.ValidationUtil;
import com.fooddelivery.resturantlistingservice.vo.GenericResponse;
import com.fooddelivery.resturantlistingservice.vo.RestaurantRequestVO;
import com.fooddelivery.resturantlistingservice.vo.RestaurantResponseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RestaurantServiceImpl implements ResturantService {
    private final RestaurantRepo repo;
    private final Mapper mapper;
    @Autowired
    public RestaurantServiceImpl(RestaurantRepo repo, Mapper mapper){
        this.repo = repo;
        this.mapper = mapper;
    }

    @Override
    public GenericResponse addRestaurant(RestaurantRequestVO restaurantRequestVO) {
        GenericResponse response=new GenericResponse();
        boolean isValid = ValidationUtil.validateRequest(restaurantRequestVO);

        if(isValid) {
            RestaurantEntity entity = mapper.ResurantVOToEntity(restaurantRequestVO);
            repo.save(entity);
            response.setStatusCode(200);
            response.setStatusMessage("Restaurant Added Successfully!");
            return response;
        }
        response.setStatusCode(400);
        response.setStatusMessage("Please check your request!" +
                "Unable to create Restaurant");
        return response;

    }
@Override
    public List<RestaurantResponseVO> display(){
        Optional<List<RestaurantEntity>> entityList = Optional.ofNullable(repo.findAll());
            List<RestaurantResponseVO> list =  mapper.ListEntityToListVO(entityList.get());
            return list;

//    return entityList.stream()
//            .map((restaurantEntity) -> Mapper.ResurantEntityToVO((RestaurantEntity) restaurantEntity))
//            .collect(Collectors.toList());

    }

    @Override
    public ResponseEntity<RestaurantResponseVO> fetchRestaurantById(Long Id) {
        RestaurantEntity entity = repo.findById(Id).orElseThrow(
                ()->new ResourceNotFoundException("Restaurant" ,"Id", Id)
        );
        return ResponseEntity.ok(Mapper.ResurantEntityToVO(entity));

    }

    @Override
    public GenericResponse deleteRestaurantById(Long id) {
        GenericResponse response=new GenericResponse();
        RestaurantEntity entity = repo.findById(id).orElseThrow(
                ()->new ResourceNotFoundException("Restaurant" ,"Id", id)
        );
        repo.deleteById(id);
        response.setStatusCode(200);
        response.setStatusMessage("Restaurant deleted Successfully!");
        return response;
    }
}
