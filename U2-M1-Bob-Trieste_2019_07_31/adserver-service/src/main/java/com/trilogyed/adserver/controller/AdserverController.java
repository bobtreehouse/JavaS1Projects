package com.trilogyed.adserver.controller;


import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RefreshScope
public class AdserverController {

    // something to hold our ads
    private List<String> adList = new ArrayList<>();
    // so we can randomly return a greeting
    private Random rnd = new Random();

    //private Random rnd = new Random();
    public AdserverController() {

        // some ads
        adList.add("Home Equity Loans @ 3.87% APR");
        adList.add("Click HERE to qualify for a new car loan!");
        adList.add("Super Sale on summer clothes!");
        adList.add("Summer Show Blowout!!! 30% to 50% off!!!!");
        adList.add("Get a new phone NOW!");
        adList.add("Alaskan Cruises for as low as $700!");
        adList.add("BOGO large 2 topping pizzas!");
        adList.add("Free installation with the purchase of 100 square feet of carpet!");

    }


    @RequestMapping(value = "/ad", method = RequestMethod.GET)
    public String getAd() {
        int whichAnswer = rnd.nextInt(8);
        return adList.get(whichAnswer);
    }

}
