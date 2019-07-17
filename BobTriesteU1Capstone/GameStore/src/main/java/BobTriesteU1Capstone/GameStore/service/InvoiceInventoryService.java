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
public class InvoiceInventoryService {

    ConsoleDao consoleDao;
    GameDao gameDao;
    InvoiceDao invoiceDao;
    ProcessingFeeDao processingFeeDao;
    SalesTaxRateDao salesTaxRateDao;
    TshirtDao tshirtDao;


    @Autowired
    public InvoiceInventoryService(ConsoleDao consoleDao, GameDao gameDao, InvoiceDao invoiceDao, ProcessingFeeDao processingFeeDao,
                                   SalesTaxRateDao salesTaxRateDao, TshirtDao tshirtDao) {
        this.consoleDao = consoleDao;
        this.gameDao = gameDao;
        this.invoiceDao = invoiceDao;
        this.processingFeeDao = processingFeeDao;
        this.salesTaxRateDao = salesTaxRateDao;
    }



    public void removeItem(int id)
    {
        itemDao.deleteItem(id);
    }

    public void updateItem(GameViewModel itemViewModel)
    {
        Item item = new Item();
        item.setId(itemViewModel.getId());
        item.setName(itemViewModel.getName());
        item.setDescription(itemViewModel.getDescription());
        item.setDailyRate(itemViewModel.getDailyRate());
        itemDao.updateItem(item);
    }

    @Transactional
    public InvoiceViewModel saveInvoice(InvoiceViewModel invoiceViewModel) {

        Invoice invoice = new Invoice();
        invoice.setName(invoiceViewModel.getName());
        invoice.setStreet(invoiceViewModel.getStreet());
        invoice.setCity(invoiceViewModel.getCity());
        invoice.setState(invoiceViewModel.getState());
        invoice.setZipcode(invoiceViewModel.getZipcode());
        invoice.setItemId(invoiceViewModel.getItemId());
        invoice.setItemType(invoiceViewModel.getItemType());
        invoice.setUnitPrice(invoiceViewModel.getUnitPrice());
        invoice.setQuantity(invoiceViewModel.getQuantity());
        invoice.setSubtotal(invoiceViewModel.getSubtotal());
        invoice.setProcessiongFee(invoiceViewModel.getProcessiongFee());
        invoice.setTax(invoiceViewModel.getTax());
        invoice.setTotal(invoiceViewModel.getTotal());
        invoice.setInvoiceId(invoiceViewModel.getInvoiceId());

        invoice = invoiceDao.addInvoice(invoice);



        List<Invoice> Invoices = invoiceViewModel.invoices();
        Invoices.stream().forEach(Invoice -> {
            Invoice.setInvoiceId(invoiceViewModel.getInvoiceId());
            InvoiceDao.addInvoice(Invoice);
        });

        Invoices = InvoiceDao.get(invoice.getId());
        invoiceViewModel.setInvoices(Invoices);

        return invoiceViewModel;
    }
    /*
    @Transactional
    public void updateInvoice(InvoiceViewModel invoiceViewModel) {
        Invoice invoice = new Invoice();
        invoice.setId(invoiceViewModel.getId());
        invoice.setReturnDate(invoiceViewModel.getReturnDate());
        invoice.setOrderDate(invoiceViewModel.getOrderDate());
        invoice.setPickupDate(invoiceViewModel.getPickupDate());
        invoice.setLateFee(invoiceViewModel.getLateFee());
        invoice.setConsoleId(invoiceViewModel.getConsoleId());
        invoiceDao.updateInvoice(invoice);

        List<Invoice> Invoices = InvoiceDao.getInvoicesByInvoice(invoice.getId());
        Invoices.stream().forEach(Invoice -> {
            InvoiceDao.deleteInvoice(Invoice.getId());
        });

        Invoices = invoiceViewModel.getInvoices();
        Invoices.stream().forEach(Invoice -> {
            Invoice.setInvoiceId(invoiceViewModel.getId());
            Invoice = InvoiceDao.addInvoice(Invoice);

        });
    }*/

    public InvoiceViewModel findInvoice(int id) {
        Invoice invoice = invoiceDao.getInvoice(id);
        if(invoice == null )
            return null;
        else
            return buildInvoiceViewModel(invoice);
    }

    public List<InvoiceViewModel> findInvoiceByConsole(int ConsoleId)
    {
        List<Invoice> invoices = invoiceDao.getInvoiceByCutomer(ConsoleId);
        List<InvoiceViewModel> invoiceViewModels = new ArrayList<>();

        for (Invoice invoice: invoices) {
            invoiceViewModels.add(buildInvoiceViewModel(invoice));
        }
        return invoiceViewModels;
    }

    public void removeInvoice(int id)
    {
        List<Invoice> Invoices = InvoiceDao.getInvoicesByInvoice(id);
        for (Invoice Invoice: Invoices) {
            InvoiceDao.deleteInvoice(Invoice.getId());
        }
        invoiceDao.deleteInvoice(id);
    }

    public Invoice saveInvoice(Invoice Invoice) {
        return InvoiceDao.addInvoice(Invoice);
    }



    private InvoiceViewModel buildInvoiceViewModel(Invoice invoice) {

        InvoiceViewModel invoiceViewModel = new InvoiceViewModel();
        invoiceViewModel.setId(invoice.getId());
        invoiceViewModel.setReturnDate(invoice.getReturnDate());
        invoiceViewModel.setOrderDate(invoice.getOrderDate());
        invoiceViewModel.setPickupDate(invoice.getPickupDate());
        invoiceViewModel.setLateFee(invoice.getLateFee());

        Console Console = ConsoleDao.getConsole(invoice.getConsoleId());
        invoiceViewModel.setConsoleId(Console.getId());

        List<Invoice> Invoices = InvoiceDao.getInvoicesByInvoice(invoice.getId());
        invoiceViewModel.setInvoices(Invoices);
        return invoiceViewModel;
    }


    private ConsoleViewModel buildGameViewModel(Game  game) {
        GameViewModel gameViewModel = new GameViewModel();
        GameViewModel.setId(Game.getId());
        GameViewModel.setFirstName(Game.getFirstName());
        GameViewModel.setLastName(Game.getLastName());
        GameViewModel.setCompany(Game.getCompany());
        GameViewModel.setEmail(Game.getEmail());
        GameViewModel.setPhone(Game.getPhone());

        return GameViewModel;
    }


}

