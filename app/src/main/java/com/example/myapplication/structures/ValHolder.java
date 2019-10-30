package com.example.myapplication.structures;

public class ValHolder {

    private double val;
    private double pos;
    private boolean isDist = false;

    public ValHolder(double val, double pos, boolean isDist) {
        this.val = val;
        this.pos = pos;
        this.isDist = isDist;
    }

    public ValHolder(double val, double pos) {
        this.val = val;
        this.pos = pos;
    }

    public double getVal() {
        return val;
    }

    public void setVal(double val) {
        this.val = val;
    }

    public double getPos() {
        return pos;
    }

    public void setPos(double pos) {
        this.pos = pos;
    }

    public boolean isDist() {
        return isDist;
    }

    public void setDist(boolean dist) {
        isDist = dist;
    }
}
