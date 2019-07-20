package com.treehouse.springconfigactuator.controller;


        import org.springframework.beans.factory.annotation.Value;
        import org.springframework.cloud.context.config.annotation.RefreshScope;
        import org.springframework.web.bind.annotation.RequestMapping;
        import org.springframework.web.bind.annotation.RequestMethod;
        import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope


public class HelloCloudServiceCOntroller {

    //get method in controller fetching official greetings value

    @Value("${officialGreeting}")
    private String officialGreeting;

    @RequestMapping(value = "/hello", method = RequestMethod.GET)
    public String helloCloud() {

        return officialGreeting;

    }
}
