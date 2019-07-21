package com.treehouse.magic8ballservice;



import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

@RestController
@RefreshScope
public class Magic8ballService {
    //get method in controller fetching official greetings value

//    @Value("${quote}")

    String[] answer = {"No",
            "Looking cloudy!",
            "Absolutely!!!!!!",
            "Ask again!",
            "Not a chance!!!!!!",

    };


    Random random = new Random();


    @RequestMapping(value = "/eightballanswer", method = RequestMethod.GET)
    public String randomAnswer() {

        return answer[random.nextInt(answer.length-1)];

    }
}
