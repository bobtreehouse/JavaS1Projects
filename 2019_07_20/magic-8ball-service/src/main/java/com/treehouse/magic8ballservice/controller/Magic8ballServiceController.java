package com.treehouse.magic8ballservice.controller;

import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
@RestController
@RefreshScope
public class Magic8ballServiceController {

    // something to hold our greetings
    private List<String> answerList = new ArrayList<>();
    // so we can randomly return a greeting
    private Random rndGenerator = new Random();

    public Magic8ballServiceController() {

        // some greetings
        answerList.add("No!");
        answerList.add("Yes!!!");
        answerList.add("Looking cloudy!");
        answerList.add("Not sure");
        answerList.add("Absolutely!!!!!!");
        answerList.add("Ask again!");
        answerList.add("Ummm");
        answerList.add("Not a chance!!!!!!");
        answerList.add("You will perish ! ");
        answerList.add("Be VERY afraid ! ");
        answerList.add("Ask again!");
        answerList.add("Ummmm NOOOOO");
        answerList.add("BUH _BYE !!!!!!");
    }

    @RequestMapping(value = "/eightballanswer", method = RequestMethod.GET)
    public String getRandomAnswer() {

        // select and return a random greeting
        int whichAnswer = rndGenerator.nextInt(13);
        return answerList.get(whichAnswer);
    }
}
