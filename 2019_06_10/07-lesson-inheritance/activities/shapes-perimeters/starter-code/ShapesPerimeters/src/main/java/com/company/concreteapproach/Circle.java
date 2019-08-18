package com.company.concreteapproach;

import java.security.SecureRandom;

public class Circle extends Shape {


    /* Include properties for name, color, x coordinate,
    and y coordinate. Also provide an empty implementation
    for area() and perimeter() methods.
     */
    private String name;
    private String color;
    private int x_coordinate;
    private int y_coordinate;

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

    public int getX_coordinate() {
        return x_coordinate;
    }

    public void setX_coordinate(int x_coordinate) {
        this.x_coordinate = x_coordinate;
    }

    public int getY_coordinate() {
        return y_coordinate;
    }

    public void setY_coordinate(int y_coordinate) {
        this.y_coordinate = y_coordinate;
    }
//    private double radius;
//
//    public Circle(double radius) {
//        this.radius = radius;
//    }
//
//    public double area() {
//        return radius * radius * Math.PI;
//    }
//
//    public double perimeter() {
//        return 2 * Math.PI * radius;
//    }
//
//    public double getRadius() {
//        return radius;
//    }
}
