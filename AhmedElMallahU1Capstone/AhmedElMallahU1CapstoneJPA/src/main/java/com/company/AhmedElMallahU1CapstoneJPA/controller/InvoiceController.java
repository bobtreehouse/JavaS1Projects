package com.company.AhmedElMallahU1CapstoneJPA.controller;

import com.company.AhmedElMallahU1CapstoneJPA.service.ServiceLayer;
import com.company.AhmedElMallahU1CapstoneJPA.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

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
