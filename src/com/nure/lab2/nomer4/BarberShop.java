package com.nure.lab2.nomer4;

public class BarberShop {
    Barber barber;
    WaitSeat waitSeat;
    CutSeat cutSeat;

    public void start(){
        this.barber.start();
        this.waitSeat.start();
    }

    public BarberShop(Barber barber, WaitSeat waitSeat, CutSeat cutSeat) {
        this.barber = barber;
        this.waitSeat = waitSeat;
        this.cutSeat = cutSeat;
    }

    public Barber getBarber() {
        return barber;
    }

    public WaitSeat getWaitSeat() {
        return waitSeat;
    }

    public CutSeat getCutSeat() {
        return cutSeat;
    }


}
