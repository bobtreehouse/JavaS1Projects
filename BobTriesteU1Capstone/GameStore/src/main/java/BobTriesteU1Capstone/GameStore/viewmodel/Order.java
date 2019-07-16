//package BobTriesteU1Capstone.GameStore.viewmodel;
//
//import javax.validation.constraints.DecimalMax;
//import javax.validation.constraints.DecimalMin;
//import javax.validation.constraints.NotEmpty;
//import java.math.BigDecimal;
//import java.time.LocalDate;
//import java.util.List;
//import java.util.Objects;
//
//public class Order {
//
//
//
//
//    public class InvoiceViewModel {
//
//        private int id;
//        @NotEmpty(message="Please supply an orderDate")
//        private LocalDate orderDate;
//        @NotEmpty(message="Please supply a pickupDate")
//        private LocalDate pickupDate;
//        @NotEmpty(message = "Please supply a return Date")
//        private LocalDate returnDate;
//        @NotEmpty(message="Please supply a lateFee")
//        @DecimalMin(value = "0.0", inclusive = true)
//        @DecimalMax(value = "999999.99", inclusive = true)
//        private BigDecimal lateFee;
//        @NotEmpty(message="Please supply a customer id")
//        private int customerId;
//        @NotEmpty(message="Please supply invoice items")
//        private List<Invoice> invoiceItems;
//
//        public int getId() {
//            return id;
//        }
//
//        public void setId(int id) {
//            this.id = id;
//        }
//
//        public LocalDate getOrderDate() {
//            return orderDate;
//        }
//
//        public void setOrderDate(LocalDate orderDate) {
//            this.orderDate = orderDate;
//        }
//
//        public LocalDate getPickupDate() {
//            return pickupDate;
//        }
//
//        public void setPickupDate(LocalDate pickupDate) {
//            this.pickupDate = pickupDate;
//        }
//
//        public LocalDate getReturnDate() {
//            return returnDate;
//        }
//
//        public void setReturnDate(LocalDate returnDate) {
//            this.returnDate = returnDate;
//        }
//
//        public BigDecimal getLateFee() {
//            return lateFee;
//        }
//
//        public void setLateFee(BigDecimal lateFee) {
//            this.lateFee = lateFee;
//        }
//
//        public int getCustomerId() {
//            return customerId;
//        }
//
//        public void setCustomerId(int customerId) {
//            this.customerId = customerId;
//        }
//
//        public List<InvoiceItem> getInvoiceItems() {
//            return invoiceItems;
//        }
//
//        public void setInvoiceItems(List<InvoiceItem> invoiceItems) {
//            this.invoiceItems = invoiceItems;
//        }
//
//        @Override
//        public boolean equals(Object o) {
//            if (this == o) return true;
//            if (o == null || getClass() != o.getClass()) return false;
//            InvoiceViewModel that = (InvoiceViewModel) o;
//            return id == that.id &&
//                    orderDate.equals(that.orderDate) &&
//                    pickupDate.equals(that.pickupDate) &&
//                    returnDate.equals(that.returnDate) &&
//                    lateFee.equals(that.lateFee) &&
//                    customerId  == that.customerId &&
//                    invoiceItems.equals(that.invoiceItems);
//        }
//
//        @Override
//        public int hashCode() {
//            return Objects.hash(id, orderDate, pickupDate, returnDate, lateFee, customerId, invoiceItems);
//        }
//    }
//
//}
