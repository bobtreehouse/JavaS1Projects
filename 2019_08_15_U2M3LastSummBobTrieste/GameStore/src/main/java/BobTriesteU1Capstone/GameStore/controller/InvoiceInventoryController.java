package BobTriesteU1Capstone.GameStore.controller;

import BobTriesteU1Capstone.GameStore.exception.NotFoundException;

import BobTriesteU1Capstone.GameStore.service.InvoiceInventoryService;
import BobTriesteU1Capstone.GameStore.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;



import javax.validation.Valid;

//public class InvoiceInventoryController {


    @RestController
    @RequestMapping("/invoice")//This mapping at class level allows to set the base path for the Customer API
    public class InvoiceInventoryController {

        @Autowired
        InvoiceInventoryService invoiceInventoryservice;

        @PostMapping//Another way to set the Rest API Post mapping
        @ResponseStatus(HttpStatus.CREATED)
        public InvoiceViewModel addInvoice(@RequestBody @Valid InvoiceViewModel invoice) {
            return invoiceInventoryservice.saveInvoice(invoice);
        }

        @GetMapping("/{id}")//Another way to set the Rest API Get mapping
        @ResponseStatus(HttpStatus.OK)
        public InvoiceViewModel getInvoice(@PathVariable("id") int invoiceId) {
            InvoiceViewModel invoiceViewModel = invoiceInventoryservice.getInvoice(invoiceId);
            if (invoiceViewModel == null)
                throw new NotFoundException("Invoice could not be retrieved for id " + invoiceId);
            return invoiceViewModel;
        }

        @GetMapping("/{ConsoleId}")//Another way to set the Rest API Get mapping
        @ResponseStatus(HttpStatus.OK)
        public InvoiceViewModel getInvoicesByConsoleId(@PathVariable("ConsoleId") int consoleId) {
            InvoiceViewModel invoiceViewModel = invoiceInventoryservice.getInvoice(consoleId);
            if (invoiceViewModel == null)
                throw new NotFoundException("Invoice could not be retrieved for id " + consoleId);
            return invoiceViewModel;
        }

        @DeleteMapping("/{id}")//Another way to set the Rest API Delete mapping
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void deleteInvoice(@PathVariable("id") int id) {
            invoiceInventoryservice.removeInvoice(id);
        }

        @PutMapping("/{id}")//Another way to set the Rest API Put mapping
        @ResponseStatus(HttpStatus.NO_CONTENT)
        public void updateInvoice(@PathVariable("id") int id, @RequestBody @Valid InvoiceViewModel invoiceViewModel) {
            if (invoiceViewModel.getInvoiceId() == 0)
                invoiceViewModel.setInvoiceId(id);
            if (id != invoiceViewModel.getInvoiceId()) {
                throw new IllegalArgumentException("Invoice ID on path must match the ID in the Invoice object");
            }
            invoiceInventoryservice.updateInvoice(invoiceViewModel);
        }

    }

