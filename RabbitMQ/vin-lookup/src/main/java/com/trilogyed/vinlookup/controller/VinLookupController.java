package com.trilogyed.vinlookup.controller;

import com.trilogyed.vinlookup.ServiceLayer.VinLookupService;
import com.trilogyed.vinlookup.ViewModel.VinLookupView;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RefreshScope
public class VinLookupController {

    @Autowired
    VinLookupService vinservice;


    @RequestMapping (value = "/vehicle/{vin}", method = RequestMethod.GET)
    @ResponseStatus(HttpStatus.OK)
    public VinLookupView lookUpVehicle(@PathVariable("vin") String vin) {

        VinLookupView vinlook = vinservice.findVehicleByVin(vin);

        if (vinlook == null)
            throw new IllegalArgumentException("vehicle could not be retrieved for id " + vin);
        return vinlook;
    }
}



/*
we replace the random generated code data above from what we were originally given below


//    private String[] types = {"Motorcycle", "Truck", "Automobile", "Other"};
//    private String[] makes = {"Honda", "Suzuki", "Subaru", "Ford", "Cheverolet"};
//    private String[] models = {"Africa Twin", "F-150", "Outback", "Malibu", "DL650", "CBR100RR"};
//    private String[] colors = {"Red", "Blue", "White", "Black", "Grey", "Tan", "Silver", "Orange"};
//    private String[] years = {"1999", "2000", "2001", "2002", "2003", "2004", "2005", "2006", "2007", "2008", "2009", "2010"};
//
//    Random rndGen = new Random();
*/