package com.nure.lab2.nomer4;

import java.util.Random;

public class MainLab2 {
    public static void main(String[] args) {
        CutSeat cutSeat = new CutSeat();
        Barber barber = new Barber(cutSeat);
        WaitSeat waitSeat = new WaitSeat(cutSeat);
        BarberShop barberShop = new BarberShop(barber, waitSeat, cutSeat);
        barberShop.start();
        for (int i=0;i<15;i++){
            int time = new Random().nextInt(1000);
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            new Visitor(String.valueOf(i)).toVisit(barberShop);
        }
    }
}
