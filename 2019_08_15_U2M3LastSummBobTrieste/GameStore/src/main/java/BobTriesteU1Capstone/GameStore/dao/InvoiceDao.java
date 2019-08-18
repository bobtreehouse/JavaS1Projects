package BobTriesteU1Capstone.GameStore.dao;

import BobTriesteU1Capstone.GameStore.model.Invoice;
import java.util.List;

public interface InvoiceDao {


    Invoice addInvoice(Invoice invoice);

    Invoice getInvoice(int id);

    List<Invoice> getAllInvoices();

    void updateInvoice(Invoice invoice);

    void deleteInvoice(int id);

    List<Invoice> getInvoicesByConsoleId();


}
