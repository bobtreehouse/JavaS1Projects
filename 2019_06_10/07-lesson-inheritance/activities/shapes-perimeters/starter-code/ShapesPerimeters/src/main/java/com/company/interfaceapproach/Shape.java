package com.company.interfaceapproach;

public interface Shape {


    private String name;
    private String color;
    private int x_coordinate;
    private int y_coordinate;

    public double perimeter();
    public double area();
}




/*


*Interfaces versus Abstraction:


With abstraction you can only have one abstract Class however with interfaces you have have a countless
number for different purposes.

However; the abstract methd allow for some more "one-off" customization for the class whereas the interface
has to run its full course as designed.




*/


