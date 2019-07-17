//sample customer servicelayer

package com.group.jdbc.U1M6GroupProject.service;

import com.group.jdbc.U1M6GroupProject.dao.CustomerDao;
import com.group.jdbc.U1M6GroupProject.dao.InvoiceDao;
import com.group.jdbc.U1M6GroupProject.dao.InvoiceItemDao;
import com.group.jdbc.U1M6GroupProject.dao.ItemDao;
import com.group.jdbc.U1M6GroupProject.model.Customer;
import com.group.jdbc.U1M6GroupProject.model.Invoice;
import com.group.jdbc.U1M6GroupProject.model.InvoiceItem;
import com.group.jdbc.U1M6GroupProject.model.Item;
import com.group.jdbc.U1M6GroupProject.viewmodel.CustomerViewModel;
import com.group.jdbc.U1M6GroupProject.viewmodel.InvoiceViewModel;
import com.group.jdbc.U1M6GroupProject.viewmodel.ItemViewModel;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Component
public class InvoiceInventoryService {

    CustomerDao customerDao;
    InvoiceDao invoiceDao;
    InvoiceItemDao invoiceItemDao;
    ItemDao itemDao;

    @Autowired
    public InvoiceInventoryService(CustomerDao customerDao, InvoiceDao invoiceDao, InvoiceItemDao invoiceItemDao, ItemDao itemDao) {
        this.customerDao = customerDao;
        this.invoiceDao = invoiceDao;
        this.invoiceItemDao = invoiceItemDao;
        this.itemDao = itemDao;
    }

    public CustomerViewModel saveCustomer(CustomerViewModel customerViewModel) {
        Customer customer = new Customer();
        customer.setFirstName(customerViewModel.getFirstName());
        customer.setLastName(customerViewModel.getLastName());
        customer.setPhone(customerViewModel.getPhone());
        customer.setCompany(customerViewModel.getCompany());
        customer.setEmail(customerViewModel.getEmail());
        customer =  customerDao.addCustomer(customer);

        customerViewModel.setId(customer.getId());
        return customerViewModel;
    }

    public void updateCustomer(CustomerViewModel customerViewModel)
    {
        Customer customer = new Customer();
        customer.setId(customerViewModel.getId());
        customer.setFirstName(customerViewModel.getFirstName());
        customer.setLastName(customerViewModel.getLastName());
        customer.setPhone(customerViewModel.getPhone());
        customer.setCompany(customerViewModel.getCompany());
        customer.setEmail(customerViewModel.getEmail());

        customerDao.updateCustomer(customer);
    }

    public CustomerViewModel findCustomerbyId(int id) {
        Customer customer =  customerDao.getCustomer(id);
        if(customer == null)
            return null;
        else
            return buildCustomerViewModel(customer);
    }

    public void removeCustomer(int id)
    {
        customerDao.deleteCustomer(id);
    }
