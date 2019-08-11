package com.company.AhmedElMallahU1Capstone.dao;

import com.company.AhmedElMallahU1Capstone.dto.TShirt;

import java.util.List;

public interface TShirtDao {
    //CRUD Methods
    TShirt addTShirt(TShirt tShirt);
    TShirt getTShirt(int id);
    List<TShirt> getAllTShirts();
    TShirt updateTShirt(TShirt tShirt);
    void deleteTShirt(int id);

    //Custom Methods
    List<TShirt> getTShirtByColor(String color);
    List<TShirt> getTShirtBySize(String size);
}
