//package BobTriesteU1Capstone.GameStore.service;
//
//import BobTriesteU1Capstone.GameStore.*;
//import BobTriesteU1Capstone.GameStore.model.Game;
//import org.junit.Before;
//import BobTriesteU1Capstone.GameStore.dao.*;
//import BobTriesteU1Capstone.GameStore.model.Console;
//import BobTriesteU1Capstone.GameStore.Game;
//import BobTriesteU1Capstone.GameStore.model.Invoice;
//import BobTriesteU1Capstone.GameStore.model.Tshirt;
//import BobTriesteU1Capstone.GameStore.viewmodel.CustomerViewModel;
//import BobTriesteU1Capstone.GameStore.viewmodel.InvoiceViewModel;
//import org.junit.Before;
//import org.junit.Test;
//
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.*;
//import static org.junit.Assert.assertEquals;
//import static org.mockito.Mockito.doReturn;
//import static org.mockito.Mockito.mock;
//import org.junit.Test;
//
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.util.ArrayList;
//import java.util.List;
//
//import static org.junit.Assert.*;
//import static org.mockito.Mockito.doReturn;
//import static org.mockito.Mockito.mock;
//
//public class InvoiceInventoryServiceTest {
//
//
//
//
//    ConsoleDao consoleDao;
//    GameDao gameDao;
//    InvoiceDao invoiceDao;
//    TshirtDao tshirtDao;
//    ProcessingFeeDao processingFeeDao;
//    SalesTaxRateDao salesTaxRateDao;
//
//    @Before
//    public void setUp() throws Exception {
//
//        setUpConsoleDaoMock();
//        setUpGameDaoMock();
//        setUpInvoiceDaoMock();
//        setUpTshirtDaoMock();
//        setUpProcessingFeeDaoDaoMock();
//        setUpSalesTaxRateDaoMock();
//
//        invoiceInventoryService = new InvoiceInventoryService(customerDao,invoiceDao,ConsoleDao,itemDao);
//    }
//
//    private void setUpConsoleDaoMock() {
//
//        ConsoleDao = mock(ConsoleDaoJdbcTemplateImpl.class);
//
//        Console Console = new Console();
//        Console.setModel(1);
//        Console.setItemId(42);
//        Console.setQuantity(3);
//        Console.setInvoiceId(2);
//        Console.setUnitRate(new BigDecimal(35).setScale(2));
//        Console.setDiscount(new BigDecimal(3).setScale(2));
//
//        Console Console1 = new Console();
//
//        Console1.setItemId(42);
//        Console1.setQuantity(3);
//        Console1.setInvoiceId(2);
//        Console1.setUnitRate(new BigDecimal(35).setScale(2));
//        Console1.setDiscount(new BigDecimal(3).setScale(2));
//
//        List<Console> ConsoleList = new ArrayList<>();
//        ConsoleList.add(Console);
//
//        doReturn(Console).when(ConsoleDao).addConsole(Console1);
//        doReturn(Console).when(ConsoleDao).getConsole(1);
//        doReturn(ConsoleList).when(ConsoleDao).getAllConsoles();
//    }
//
//    private void setUpInvoiceDaoMock() {
//        invoiceDao = mock(InvoiceDaoJdbcTemplateImpl.class);
//
//        Invoice invoice = new Invoice();
//        invoice.setId(2);
//        invoice.setCustomerId(7);
//        invoice.setOrderDate(LocalDate.of(2010, 1, 5));
//        invoice.setPickupDate(LocalDate.of(2010, 1, 10));
//        invoice.setReturnDate(LocalDate.of(2010, 1, 18));
//        invoice.setLateFee(new BigDecimal(3.5).setScale(2));
//
//        Invoice invoice1 = new Invoice();
//        invoice1.setCustomerId(7);
//        invoice1.setOrderDate(LocalDate.of(2010, 1, 5));
//        invoice1.setPickupDate(LocalDate.of(2010, 1, 10));
//        invoice1.setReturnDate(LocalDate.of(2010, 1, 18));
//        invoice1.setLateFee(new BigDecimal(3.5).setScale(2));
//
//        List<Invoice> invoiceList = new ArrayList<>();
//        invoiceList.add(invoice);
//
//        doReturn(invoice).when(invoiceDao).addInvoice(invoice1);
//        doReturn(invoice).when(invoiceDao).getInvoice(2);
//        doReturn(invoiceList).when(invoiceDao).getAllInvoices();
//        doReturn(invoiceList).when(invoiceDao).getInvoiceByCutomer(7);
//    }
//
//    private void setUpItemDaoMock() {
//        itemDao = mock(ItemDaoJdbcTemplateImpl.class);
//
//        Item item = new Item();
//        item.setId(42);
//        item.setDescription("Laptop");
//        item.setName("MacBook Air");
//        item.setDailyRate(new BigDecimal("3.5").setScale(2));
//
//        Item item1 = new Item();
//        item1.setDescription("Laptop");
//        item1.setName("MacBook Air");
//        item1.setDailyRate(new BigDecimal("3.5").setScale(2));
//
//        List<Item> itemList = new ArrayList<>();
//        itemList.add(item);
//
//        doReturn(item).when(itemDao).addItem(item1);
//        doReturn(item).when(itemDao).getItem(42);
//        doReturn(itemList).when(itemDao).getAllItems();
//    }
//
//    private void setUpCustomerDaoMock() {
//        customerDao = mock(CustomerDaoJdbcTemplateImpl.class);
//
//        Customer customer = new Customer();
//        customer.setId(7);
//        customer.setFirstName("Reshma");
//        customer.setLastName("Mary");
//        customer.setEmail("reshmamary.serine@gmail.com");
//        customer.setCompany("Trilogy");
//        customer.setPhone("2246239082");
//
//        Customer customer1 = new Customer();
//        customer1.setFirstName("Reshma");
//        customer1.setLastName("Mary");
//        customer1.setEmail("reshmamary.serine@gmail.com");
//        customer1.setCompany("Trilogy");
//        customer1.setPhone("2246239082");
//
//        List<Customer> cList =  new ArrayList<>();
//        cList.add(customer);
//
//        doReturn(customer).when(customerDao).addCustomer(customer1);
//        doReturn(customer).when(customerDao).getCustomer(7);
//        doReturn(cList).when(customerDao).getAllCustomers();
//    }
//
//    @Test
//    public void saveFindCustomer()
//    {
//        CustomerViewModel customer = new CustomerViewModel();
//        customer.setFirstName("Reshma");
//        customer.setLastName("Mary");
//        customer.setEmail("reshmamary.serine@gmail.com");
//        customer.setCompany("Trilogy");
//        customer.setPhone("2246239082");
//
//        customer = invoiceInventoryService.saveCustomer(customer);
//        CustomerViewModel fromService  =invoiceInventoryService.findCustomerbyId(customer.getId());
//        assertEquals(customer,fromService);
//    }
//
//    @Test
//    public void saveFindItem()
//    {
//        Item item = new Item();
//        item.setDescription("Laptop");
//        item.setName("MacBook Air");
//        item.setDailyRate(new BigDecimal("3.5").setScale(2));
//
//        item = itemDao.addItem(item);
//
//        Item item1 = itemDao.getItem(item.getId());
//        assertEquals(item1,item);
//    }
//
//    @Test
//    public void saveInvoice() {
//        InvoiceViewModel invoiceViewModel = new InvoiceViewModel();
//
//        invoiceViewModel.setCustomerId(7);
//        invoiceViewModel.setOrderDate(LocalDate.of(2010, 1, 5));
//        invoiceViewModel.setPickupDate(LocalDate.of(2010, 1, 10));
//        invoiceViewModel.setReturnDate(LocalDate.of(2010, 1, 18));
//        invoiceViewModel.setLateFee(new BigDecimal(3.5).setScale(2));
//
//        Console Console = new Console();
//        Console.setItemId(42);
//        Console.setQuantity(3);
//        Console.setInvoiceId(2);
//        Console.setUnitRate(new BigDecimal(35).setScale(2));
//        Console.setDiscount(new BigDecimal(3).setScale(2));
//        Console = invoiceInventoryService.saveConsole(Console);
//
//        List<Console> Consoles = new ArrayList<>();
//        Consoles.add(Console);
//
//        invoiceViewModel.setConsoles(Consoles);
//
//        invoiceViewModel = invoiceInventoryService.saveInvoice(invoiceViewModel);
//
//        InvoiceViewModel fromService =  invoiceInventoryService.findInvoice(invoiceViewModel.getId());
//        assertEquals(invoiceViewModel,fromService);
//    }
//
//    @Test
//    public void findInvoiceByCustomer()
//    {
//        InvoiceViewModel invoiceViewModel = new InvoiceViewModel();
//
//        invoiceViewModel.setCustomerId(7);
//        invoiceViewModel.setOrderDate(LocalDate.of(2010, 1, 5));
//        invoiceViewModel.setPickupDate(LocalDate.of(2010, 1, 10));
//        invoiceViewModel.setReturnDate(LocalDate.of(2010, 1, 18));
//        invoiceViewModel.setLateFee(new BigDecimal(3.5).setScale(2));
//
//        Console Console = new Console();
//        Console.setItemId(42);
//        Console.setQuantity(3);
//        Console.setInvoiceId(2);
//        Console.setUnitRate(new BigDecimal(35).setScale(2));
//        Console.setDiscount(new BigDecimal(3).setScale(2));
//        Console = invoiceInventoryService.saveConsole(Console);
//
//        List<Console> Consoles = new ArrayList<>();
//        Consoles.add(Console);
//
//        invoiceViewModel.setConsoles(Consoles);
//
//        invoiceViewModel = invoiceInventoryService.saveInvoice(invoiceViewModel);
//
//        List<InvoiceViewModel> invoices = invoiceInventoryService.findInvoiceByCustomer(7);
//        assertEquals(1,invoices.size());
//        assertEquals(invoiceViewModel,invoices.get(0));
//    }
//}