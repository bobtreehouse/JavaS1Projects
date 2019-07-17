package BobTriesteU1Capstone.GameStore.service;

import BobTriesteU1Capstone.GameStore.dao.*;
import BobTriesteU1Capstone.GameStore.model.*;
import BobTriesteU1Capstone.GameStore.viewmodel.*;

import java.util.ArrayList;
import java.util.List;
import BobTriesteU1Capstone.GameStore.dao.TshirtDao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class TshirtService {

    ConsoleDao consoleDao;
    GameDao gameDao;
    InvoiceDao invoiceDao;
    TshirtDao tshirtDao;

    @Autowired
    public InvoiceInventoryService(ConsoleDao consoleDao, GameDao gameDao, InvoiceDao invoiceDao, ProcessingFeeDao processingFeeDao,
                                   SalesTaxRateDao salesTaxRateDao, TshirtDao tshirtDao) {
        this.consoleDao = consoleDao;
        this.gameDao = gameDao;
        this.invoiceDao = invoiceDao;

    }

    public TshirtViewModel updateTshirt(TshirtViewModel tshirtViewModel) {
        Tshirt tshirt = new Tshirt();
        tshirt.setSize(tshirtViewModel.getSize());
        tshirt.setColor(tshirtViewModel.getColor());
        tshirt.setDescription(tshirtViewModel.getDescription());
        tshirt.setPrice(tshirtViewModel.getPrice());
        tshirt.setPrice(tshirtViewModel.getPrice());
        tshirt.setQuantity(tshirtViewModel.getQuantity());
        tshirt =  tshirtDao.addTshirt(tshirt);

        tshirtViewModel.setTshirtId(tshirt.getTshirtId());
        return tshirtViewModel;
    }

    private InvoiceViewModel buildTshirtViewModel(Invoice invoice) {

        Tshirt tshirt = new Tshirt();
        tshirtViewModel.setId(invoice.getId());
        TshirtViewModel.setReturnDate(invoice.getReturnDate());
        TshirtViewModel.setOrderDate(invoice.getOrderDate());
        TshirtViewModel.setPickupDate(invoice.getPickupDate());
        TshirtViewModel.setLateFee(invoice.getLateFee());

        Console Console = ConsoleDao.getConsole(invoice.getConsoleId());
        invoiceViewModel.setConsoleId(Console.getId());

        List<Invoice> Invoices = InvoiceDao.getInvoicesByInvoice(invoice.getId());
        invoiceViewModel.setInvoices(Invoices);
        return TshirtViewModel;
    }


    public TshirtViewModel saveTshirt(TshirtViewModel tshirtViewModel) {
        Tshirt tshirt = new Tshirt();
        tshirt.setSize(tshirtViewModel.getSize());
        tshirt.setColor(tshirtViewModel.getColor());
        tshirt.setDescription(tshirtViewModel.getDescription());
        tshirt.setPrice(tshirtViewModel.getPrice());
        tshirt.setPrice(tshirtViewModel.getPrice());
        tshirt.setQuantity(tshirtViewModel.getQuantity());
        tshirt =  tshirtDao.addTshirt(tshirt);

        tshirtViewModel.setTshirtId(tshirt.getTshirtId());
        return tshirtViewModel;
    }

}
