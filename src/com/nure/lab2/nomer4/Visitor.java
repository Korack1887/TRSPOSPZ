package com.nure.lab2.nomer4;

public class Visitor {
    String name;

    @Override
    public String toString() {
        return "Visitor{" +
                "name='" + name + '\'' +
                '}';
    }

    public Visitor(String name) {
        this.name = name;
    }
    public void toVisit(BarberShop barberShop){
        barberShop.waitSeat.add(this);
    }
}
