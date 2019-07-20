package com.treehouse.bobtriesterandomquoteservice.RandomQuoteService;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.*;
import java.util.Random;

@RestController
@RefreshScope


public class RandomQuoteService {

    //get method in controller fetching official greetings value

    @Value("${quote}")
    private String quote;



    @RequestMapping(value = "/quote", method = RequestMethod.GET)
    public String randomQuote() {

        //perhaps the below code goes into the gitHub file itself and we just call the
        //method quote
        return quote;
}
