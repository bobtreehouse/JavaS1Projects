public class IceCreamFactory {

    /*factory for ice cream will differ from the POS or store in
    types of inouts including labor and power for machines in addition to
    the raw ingredients like sugar and flavoring
     */
    private String iceFlavor;
    private String rawSugar;
    private String iceMilk;
    private int factoryRent;
    private int laborHoursAvail;
    private double laborSalary;

//constructor
    public IceCreamFactory(String iceFlavor, String rawSugar, String iceMilk, int factoryRent, int laborHoursAvail, double laborSalary) {
        this.iceFlavor = iceFlavor;
        this.rawSugar = rawSugar;
        this.iceMilk = iceMilk;
        this.factoryRent = factoryRent;
        this.laborHoursAvail = laborHoursAvail;
        this.laborSalary = laborSalary;
    }

//getters // setters

    public String getIceFlavor() {
        return iceFlavor;
    }

    public void setIceFlavor(String iceFlavor) {
        this.iceFlavor = iceFlavor;
    }

    public String getRawSugar() {
        return rawSugar;
    }

    public void setRawSugar(String rawSugar) {
        this.rawSugar = rawSugar;
    }

    public String getIceMilk() {
        return iceMilk;
    }

    public void setIceMilk(String iceMilk) {
        this.iceMilk = iceMilk;
    }

    public int getFactoryRent() {
        return factoryRent;
    }

    public void setFactoryRent(int factoryRent) {
        this.factoryRent = factoryRent;
    }

    public int getLaborHoursAvail() {
        return laborHoursAvail;
    }

    public void setLaborHoursAvail(int laborHoursAvail) {
        this.laborHoursAvail = laborHoursAvail;
    }

    public double getLaborSalary() {
        return laborSalary;
    }

    public void setLaborSalary(float laborSalary) {
        this.laborSalary = laborSalary;
    }




}
