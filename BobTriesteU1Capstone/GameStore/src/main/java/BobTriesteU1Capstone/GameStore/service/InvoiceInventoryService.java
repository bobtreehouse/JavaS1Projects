//package BobTriesteU1Capstone.GameStore.service;
//
//import java.util.ArrayList;
//import java.util.List;
//
//public class InvoiceInventoryService {
//package com.group.jdbc.U1M6GroupProject.service;
//
//import com.group.jdbc.U1M6GroupProject.dao.CustomerDao;
//import com.group.jdbc.U1M6GroupProject.dao.InvoiceDao;
//import com.group.jdbc.U1M6GroupProject.dao.InvoiceItemDao;
//import com.group.jdbc.U1M6GroupProject.dao.ItemDao;
//import com.group.jdbc.U1M6GroupProject.model.Customer;
//import com.group.jdbc.U1M6GroupProject.model.Invoice;
//import com.group.jdbc.U1M6GroupProject.model.InvoiceItem;
//import com.group.jdbc.U1M6GroupProject.model.Item;
//import com.group.jdbc.U1M6GroupProject.viewmodel.CustomerViewModel;
//import com.group.jdbc.U1M6GroupProject.viewmodel.InvoiceViewModel;
//import com.group.jdbc.U1M6GroupProject.viewmodel.ItemViewModel;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.transaction.annotation.Transactional;
//
//import java.util.ArrayList;
//import java.util.List;
//
//    @Component
//    public class InvoiceInventoryService {
//
//        CustomerDao customerDao;
//        InvoiceDao invoiceDao;
//        InvoiceItemDao invoiceItemDao;
//        ItemDao itemDao;
//
//        @Autowired
//        public InvoiceInventoryService(CustomerDao customerDao, InvoiceDao invoiceDao, InvoiceItemDao invoiceItemDao, ItemDao itemDao) {
//            this.customerDao = customerDao;
//            this.invoiceDao = invoiceDao;
//            this.invoiceItemDao = invoiceItemDao;
//            this.itemDao = itemDao;
//        }
//
//        public CustomerViewModel saveCustomer(CustomerViewModel customerViewModel) {
//            Customer customer = new Customer();
//            customer.setFirstName(customerViewModel.getFirstName());
//            customer.setLastName(customerViewModel.getLastName());
//            customer.setPhone(customerViewModel.getPhone());
//            customer.setCompany(customerViewModel.getCompany());
//            customer.setEmail(customerViewModel.getEmail());
//            customer =  customerDao.addCustomer(customer);
//
//            customerViewModel.setId(customer.getId());
//            return customerViewModel;
//        }
//
//        public void updateCustomer(CustomerViewModel customerViewModel)
//        {
//            Customer customer = new Customer();
//            customer.setId(customerViewModel.getId());
//            customer.setFirstName(customerViewModel.getFirstName());
//            customer.setLastName(customerViewModel.getLastName());
//            customer.setPhone(customerViewModel.getPhone());
//            customer.setCompany(customerViewModel.getCompany());
//            customer.setEmail(customerViewModel.getEmail());
//
//            customerDao.updateCustomer(customer);
//        }
//
//        public CustomerViewModel findCustomerbyId(int id) {
//            Customer customer =  customerDao.getCustomer(id);
//            if(customer == null)
//                return null;
//            else
//                return buildCustomerViewModel(customer);
//        }
//
//        public void removeCustomer(int id)
//        {
//            customerDao.deleteCustomer(id);
//        }
//
//        public ItemViewModel saveItem(ItemViewModel itemViewModel)
//        {
//            Item item = new Item();
//            item.setName(itemViewModel.getName());
//            item.setDescription(itemViewModel.getDescription());
//            item.setDailyRate(itemViewModel.getDailyRate());
//
//            item =  itemDao.addItem(item);
//            itemViewModel.setId(item.getId());
//            return itemViewModel;
//        }
//
//        public ItemViewModel findItem(int id)
//        {
//            Item item = itemDao.getItem(id);
//            if(item != null)
//            {
//                ItemViewModel itemViewModel = new ItemViewModel();
//                itemViewModel.setId(item.getId());
//                itemViewModel.setDailyRate(item.getDailyRate());
//                itemViewModel.setDescription(item.getDescription());
//                itemViewModel.setName(item.getName());
//
//                return itemViewModel;
//            }
//            else return null;
//
//        }
//
//        public void removeItem(int id)
//        {
//            itemDao.deleteItem(id);
//        }
//
//        public void updateItem(ItemViewModel itemViewModel)
//        {
//            Item item = new Item();
//            item.setId(itemViewModel.getId());
//            item.setName(itemViewModel.getName());
//            item.setDescription(itemViewModel.getDescription());
//            item.setDailyRate(itemViewModel.getDailyRate());
//            itemDao.updateItem(item);
//        }
//
//        @Transactional
//        public InvoiceViewModel saveInvoice(InvoiceViewModel invoiceViewModel) {
//
//            Invoice invoice = new Invoice();
//            invoice.setReturnDate(invoiceViewModel.getReturnDate());
//            invoice.setOrderDate(invoiceViewModel.getOrderDate());
//            invoice.setPickupDate(invoiceViewModel.getPickupDate());
//            invoice.setLateFee(invoiceViewModel.getLateFee());
//            invoice.setCustomerId(invoiceViewModel.getCustomerId());
//            invoice = invoiceDao.addInvoice(invoice);
//            invoiceViewModel.setId(invoice.getId());
//
//            List<InvoiceItem> invoiceItems = invoiceViewModel.getInvoiceItems();
//            invoiceItems.stream().forEach(invoiceItem -> {
//                invoiceItem.setInvoiceId(invoiceViewModel.getId());
//                invoiceItemDao.addInvoiceItem(invoiceItem);
//            });
//
//            invoiceItems = invoiceItemDao.getInvoiceItemsByInvoice(invoice.getId());
//            invoiceViewModel.setInvoiceItems(invoiceItems);
//
//            return invoiceViewModel;
//        }
//    /*
//    @Transactional
//    public void updateInvoice(InvoiceViewModel invoiceViewModel) {
//        Invoice invoice = new Invoice();
//        invoice.setId(invoiceViewModel.getId());
//        invoice.setReturnDate(invoiceViewModel.getReturnDate());
//        invoice.setOrderDate(invoiceViewModel.getOrderDate());
//        invoice.setPickupDate(invoiceViewModel.getPickupDate());
//        invoice.setLateFee(invoiceViewModel.getLateFee());
//        invoice.setCustomerId(invoiceViewModel.getCustomerId());
//        invoiceDao.updateInvoice(invoice);
//
//        List<InvoiceItem> invoiceItems = invoiceItemDao.getInvoiceItemsByInvoice(invoice.getId());
//        invoiceItems.stream().forEach(invoiceItem -> {
//            invoiceItemDao.deleteInvoiceItem(invoiceItem.getId());
//        });
//
//        invoiceItems = invoiceViewModel.getInvoiceItems();
//        invoiceItems.stream().forEach(invoiceItem -> {
//            invoiceItem.setInvoiceId(invoiceViewModel.getId());
//            invoiceItem = invoiceItemDao.addInvoiceItem(invoiceItem);
//
//        });
//    }*/
//
//        public InvoiceViewModel findInvoice(int id) {
//            Invoice invoice = invoiceDao.getInvoice(id);
//            if(invoice == null )
//                return null;
//            else
//                return buildInvoiceViewModel(invoice);
//        }
//
//        public List<InvoiceViewModel> findInvoiceByCustomer(int customerId)
//        {
//            List<Invoice> invoices = invoiceDao.getInvoiceByCutomer(customerId);
//            List<InvoiceViewModel> invoiceViewModels = new ArrayList<>();
//
//            for (Invoice invoice: invoices) {
//                invoiceViewModels.add(buildInvoiceViewModel(invoice));
//            }
//            return invoiceViewModels;
//        }
//
//        public void removeInvoice(int id)
//        {
//            List<InvoiceItem> invoiceItems = invoiceItemDao.getInvoiceItemsByInvoice(id);
//            for (InvoiceItem invoiceitem: invoiceItems) {
//                invoiceItemDao.deleteInvoiceItem(invoiceitem.getId());
//            }
//            invoiceDao.deleteInvoice(id);
//        }
//
//        public InvoiceItem saveInvoiceItem(InvoiceItem invoiceItem) {
//            return invoiceItemDao.addInvoiceItem(invoiceItem);
//        }
//
//        private CustomerViewModel buildCustomerViewModel(Customer customer) {
//            CustomerViewModel customerViewModel = new CustomerViewModel();
//            customerViewModel.setId(customer.getId());
//            customerViewModel.setFirstName(customer.getFirstName());
//            customerViewModel.setLastName(customer.getLastName());
//            customerViewModel.setCompany(customer.getCompany());
//            customerViewModel.setEmail(customer.getEmail());
//            customerViewModel.setPhone(customer.getPhone());
//
//            return customerViewModel;
//        }
//
//        private InvoiceViewModel buildInvoiceViewModel(Invoice invoice) {
//
//            InvoiceViewModel invoiceViewModel = new InvoiceViewModel();
//            invoiceViewModel.setId(invoice.getId());
//            invoiceViewModel.setReturnDate(invoice.getReturnDate());
//            invoiceViewModel.setOrderDate(invoice.getOrderDate());
//            invoiceViewModel.setPickupDate(invoice.getPickupDate());
//            invoiceViewModel.setLateFee(invoice.getLateFee());
//
//            Customer customer = customerDao.getCustomer(invoice.getCustomerId());
//            invoiceViewModel.setCustomerId(customer.getId());
//
//            List<InvoiceItem> invoiceItems = invoiceItemDao.getInvoiceItemsByInvoice(invoice.getId());
//            invoiceViewModel.setInvoiceItems(invoiceItems);
//            return invoiceViewModel;
//        }
//    }
//
