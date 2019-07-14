package BobTriesteU1Capstone.GameStore.model;

import java.math.BigDecimal;
import java.util.Objects;

public class Console {

    private int gameId;
    private String model;
    private String manufacturer;
    private String memoryAmount;
    private String processor;
    private BigDecimal price;
    private int quantity;

    public int getGameId() {
        return gameId;
    }

    public void setGameId(int gameId) {
        this.gameId = gameId;
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
        Console that = (Console) o;
        return gameId == that.gameId &&
                model == that.model &&
                manufacturer == that.manufacturer &&
                memoryAmount == that.memoryAmount &&
                processor.equals(that.processor) &&
                price.equals(that.price) &&
                quantity==(that.quantity);
    }

    @Override
    public int hashCode() {
        return Objects.hash(gameId, model, manufacturer, memoryAmount, processor, price, quantity);
    }
}
