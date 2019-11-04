package com.example.myapplication.structures;

public class EquationHolder {

    Double x1;
    Double x2;
    String equation;

    public EquationHolder(Double x1, Double x2, String equation) {
        this.x1 = x1;
        this.x2 = x2;
        this.equation = equation;
    }

    public Double getX1() {
        return x1;
    }

    public void setX1(Double x1) {
        this.x1 = x1;
    }

    public Double getX2() {
        return x2;
    }

    public void setX2(Double x2) {
        this.x2 = x2;
    }

    public String getEquation() {
        return equation;
    }

    public void setEquation(String equation) {
        this.equation = equation;
    }
}
