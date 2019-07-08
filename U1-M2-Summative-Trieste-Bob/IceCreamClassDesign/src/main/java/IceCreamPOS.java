public class IceCreamPOS {

    // inputs slightly different for the store;

    private String flavorAvailable;
    private String toppingsAvailable;
    private int numCashiers;
    private int numSmallCups;
    private int numMedCups;
    private int numLargeCups;
    private double salePriceSmall;
    private double salePriceMed;
    private double salePriceLarge;

    public IceCreamPOS(String flavorAvailable, String toppingsAvailable, int numCashiers, int numSmallCups, int numMedCups, int numLargeCups, double salePriceSmall, double salePriceMed, double salePriceLarge) {
        this.flavorAvailable = flavorAvailable;
        this.toppingsAvailable = toppingsAvailable;
        this.numCashiers = numCashiers;
        this.numSmallCups = numSmallCups;
        this.numMedCups = numMedCups;
        this.numLargeCups = numLargeCups;
        this.salePriceSmall = salePriceSmall;
        this.salePriceMed = salePriceMed;
        this.salePriceLarge = salePriceLarge;
    }

    public String getFlavorAvailable() {
        return flavorAvailable;
    }

    public void setFlavorAvailable(String flavorAvailable) {
        this.flavorAvailable = flavorAvailable;
    }

    public String getToppingsAvailable() {
        return toppingsAvailable;
    }

    public void setToppingsAvailable(String toppingsAvailable) {
        this.toppingsAvailable = toppingsAvailable;
    }

    public int getNumCashiers() {
        return numCashiers;
    }

    public void setNumCashiers(int numCashiers) {
        this.numCashiers = numCashiers;
    }

    public int getNumSmallCups() {
        return numSmallCups;
    }

    public void setNumSmallCups(int numSmallCups) {
        this.numSmallCups = numSmallCups;
    }

    public int getNumMedCups() {
        return numMedCups;
    }

    public void setNumMedCups(int numMedCups) {
        this.numMedCups = numMedCups;
    }

    public int getNumLargeCups() {
        return numLargeCups;
    }

    public void setNumLargeCups(int numLargeCups) {
        this.numLargeCups = numLargeCups;
    }

    public double getSalePriceSmall() {
        return salePriceSmall;
    }

    public void setSalePriceSmall(double salePriceSmall) {
        this.salePriceSmall = salePriceSmall;
    }

    public double getSalePriceMed() {
        return salePriceMed;
    }

    public void setSalePriceMed(double salePriceMed) {
        this.salePriceMed = salePriceMed;
    }

    public double getSalePriceLarge() {
        return salePriceLarge;
    }

    public void setSalePriceLarge(double salePriceLarge) {
        this.salePriceLarge = salePriceLarge;
    }







}
