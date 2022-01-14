package com.project.hotelmanagementsystem.Service;

import com.project.hotelmanagementsystem.Entity.Restaurant;
import com.project.hotelmanagementsystem.Repository.AddDishesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AddDishesServiceImpl implements AddDishesService{
    @Autowired
    private AddDishesRepository addDishesRepository;

    public List<Restaurant> displayDishes(){
        return addDishesRepository.displayDishes();
    }

    public void addDishes(String d1, String d2, String d3){
        addDishesRepository.addDishes(d1,d2,d3);
    }

    public void updateDishes(String d1, String d2, String d3, String no) {
        addDishesRepository.updateDishes(d1, d2, d3, no);
    }

    public void deleteDishes(String no) {
        addDishesRepository.deleteDishes(no);
    }
}
