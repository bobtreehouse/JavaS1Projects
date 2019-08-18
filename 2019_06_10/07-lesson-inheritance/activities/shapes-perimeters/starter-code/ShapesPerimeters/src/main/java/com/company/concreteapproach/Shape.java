package com.company.concreteapproach;

public class Shape {
    private String name;
    private String color;
    private int xCoordinate;
    private int yCoordinate;


    public double area() {
        return 0;
    }
    public double perimeter() {
        return 0;
    }



    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getxCoordinate() {
        return xCoordinate;
    }

    public void setxCoordinate(int xCoordinate) {
        this.xCoordinate = xCoordinate;
    }

    public int getyCoordinate() {
        return yCoordinate;
    }

    public void setyCoordinate(int yCoordinate) {
        this.yCoordinate = yCoordinate;
    }
}

/*


*Interfaces versus Abstraction:


With abstraction you can only have one abstract Class however with interfaces you have have a countless
number for different purposes.

However; the abstract methd allow for some more "one-off" customization for the class whereas the interface
has to run its full course as designed.




*/
