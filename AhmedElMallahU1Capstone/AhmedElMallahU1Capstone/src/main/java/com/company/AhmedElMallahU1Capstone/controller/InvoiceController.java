package com.company.AhmedElMallahU1Capstone.controller;

import com.company.AhmedElMallahU1Capstone.service.ServiceLayer;
import com.company.AhmedElMallahU1Capstone.viewmodel.GameViewModel;
import com.company.AhmedElMallahU1Capstone.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/invoice")
public class InvoiceController {

    @Autowired
    ServiceLayer serviceLayer;

    @PostMapping
    @ResponseStatus(value = HttpStatus.CREATED)
    InvoiceViewModel addInvoice(@RequestBody @Valid InvoiceViewModel invoiceViewModel){
        return serviceLayer.saveInvoice(invoiceViewModel);
    }
}
