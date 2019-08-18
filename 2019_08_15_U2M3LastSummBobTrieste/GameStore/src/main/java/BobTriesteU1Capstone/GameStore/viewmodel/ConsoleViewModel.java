package BobTriesteU1Capstone.GameStore.viewmodel;

import BobTriesteU1Capstone.GameStore.model.Console;

import java.math.BigDecimal;
import java.util.Objects;
import javax.validation.constraints.NotEmpty;
public class ConsoleViewModel extends InvoiceViewModel {

    private int consoleId;
    @NotEmpty(message = "Please supply a value for model")
    private String model;
    @NotEmpty(message = "Please supply a value for manufacturer")
    private String manufacturer;
    @NotEmpty(message = "Please supply a value for first memory amount")
    private String memoryAmount;
    @NotEmpty(message = "Please supply a value for processor")
    private String processor;
    @NotEmpty(message = "Please supply a value for price")
    private BigDecimal price;
    private int quantity;

    public int getConsoleId() {
        return consoleId;
    }

    public void setConsoleId(int gameId) {
        this.consoleId = consoleId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(String manufacturer) {
        this.manufacturer = manufacturer;
    }

    public String getMemoryAmount() {
        return memoryAmount;
    }

    public void setMemoryAmount(String memoryAmount) {
        this.memoryAmount = memoryAmount;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ConsoleViewModel that = (ConsoleViewModel) o;
        return consoleId == that.consoleId &&
                model == that.model &&
                manufacturer == that.manufacturer &&
                memoryAmount == that.memoryAmount &&
                processor.equals(that.processor) &&
                price.equals(that.price) &&
                quantity==(that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(consoleId, model, manufacturer, memoryAmount, processor, price, quantity);
    }
}
