package BobTriesteU1Capstone.GameStore.service;

import BobTriesteU1Capstone.GameStore.dao.*;
import BobTriesteU1Capstone.GameStore.model.*;
import BobTriesteU1Capstone.GameStore.viewmodel.ConsoleViewModel;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;

import BobTriesteU1Capstone.GameStore.dao.TshirtDao;

import BobTriesteU1Capstone.GameStore.viewmodel.InvoiceViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

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



    public void updateInvoice(InvoiceViewModel invoiceViewModel) {
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
        invoiceDao.updateInvoice(invoice);

    }

    private InvoiceViewModel buildInvoiceViewModel(Invoice invoice) {

        InvoiceViewModel invoiceViewModel = new InvoiceViewModel();
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
        return invoiceViewModel;
    }


    public InvoiceViewModel getInvoice(int id) {
        Invoice invoice = invoiceDao.getInvoice(id);
        if(invoice == null )
            return null;
        else
            return buildInvoiceViewModel(invoice);
    }


    public void removeInvoice(int id)

    {

        invoiceDao.deleteInvoice(id);
    }



    private BigDecimal subtotal(BigDecimal itemPrice, int quantity){

        BigDecimal quantity1 = new BigDecimal(BigInteger.valueOf(quantity));
        BigDecimal subTotal = (itemPrice.multiply(quantity1)).setScale(2, RoundingMode.HALF_UP);
        return subTotal;
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
        invoice.setQuantity(invoiceViewModel.getQuantity());

        // Calculationstshirt
        BigDecimal unitPrice;
        BigDecimal subtotal;
        BigDecimal tax;
        BigDecimal fees;
        BigDecimal total;

        if(invoice.getItemType().equals("Console")){

            Console console = consoleDao.getConsole(invoice.getItemId());
            unitPrice = console.getPrice();

            if (invoice.getQuantity() > console.getQuantity()){
                throw new IllegalArgumentException("Not enough items in stock");
            }else {
                console.setQuantity(console.getQuantity()-invoice.getQuantity());
                consoleDao.updateConsole(console);
            }
        }else if (invoice.getItemType().equals("Game")){

            Game game = gameDao.getGame(invoice.getItemId());
            unitPrice = game.getPrice();

            if (invoice.getQuantity() > game.getQuantity()){
                throw new IllegalArgumentException("Not enough items in stock");
            }else {
                game.setQuantity(game.getQuantity()-invoice.getQuantity());
                gameDao.updateGame(game);
            }


        }else if (invoice.getItemType().equals("T-Shirts")){

            Tshirt tshirt = tshirtDao.getTshirt(invoice.getItemId());
            unitPrice = tshirt.getPrice();

            if (invoice.getQuantity() > tshirt.getQuantity()){
                throw new IllegalArgumentException("Not enough items in stock");
            }else {
                tshirt.setQuantity(tshirt.getQuantity() - invoice.getQuantity());
                tshirtDao.updateTshirt(tshirt);
            }

        }else{
            throw new IllegalArgumentException("Product type is not correct");
        }

        //
        subtotal = unitPrice.multiply(BigDecimal.valueOf(invoice.getQuantity())).setScale(2, RoundingMode.HALF_UP);

        //
        tax = salesTaxRateDao.getSalesTaxRate(invoice.getState()).getRate().multiply(subtotal).setScale(2,RoundingMode.HALF_UP);
        //
        fees = processingFeeDao.getByItemType(invoice.getItemType()).getFee();

        if (invoice.getQuantity() > 10){
            fees = fees.add(new BigDecimal(15.49)).setScale(2,RoundingMode.HALF_UP) ;
        }
        //
        total = subtotal.add(tax).add(fees).setScale(2,RoundingMode.HALF_UP);
        //
        invoice.setUnitPrice(unitPrice);
        invoice.setSubtotal(subtotal);
        invoice.setTax(tax);
        invoice.setProcessiongFee(fees);
        invoice.setTotal(total);

        invoice =  invoiceDao.addInvoice(invoice);

        return buildInvoiceViewModel(invoice);
    }





}

