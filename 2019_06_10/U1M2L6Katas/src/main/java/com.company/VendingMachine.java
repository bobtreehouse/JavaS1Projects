package com.company;

public class VendingMachine {

    private boolean acceptsCash;
    private String color;
    private boolean runsJava;
    private int itemCount;
    private boolean givesReceipt;

    public boolean isAcceptsCash() {
        return acceptsCash;
    }

    public void setAcceptsCash(boolean acceptsCash) {
        this.acceptsCash = acceptsCash;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public boolean isRunsJava() {
        return runsJava;
    }

    public void setRunsJava(boolean runsJava) {
        this.runsJava = runsJava;
    }

    public int getItemCount() {
        return itemCount;
    }

    public void setItemCount(int itemCount) {
        this.itemCount = itemCount;
    }

    public boolean isGivesReceipt() {
        return givesReceipt;
    }

    public void setGivesReceipt(boolean givesReceipt) {
        this.givesReceipt = givesReceipt;
    }
}
