package com.nure.lab2.nomer4;

public class Barber {
    public CutSeat cutseat;
    private BarberThread barberThread;
    public Barber(CutSeat cutseat) {
        this.cutseat = cutseat;
        barberThread = new BarberThread();
    }
    public void start(){
        barberThread.start();
    }
    public void toCut(){
        for (int i=0;i<100;i+=33){
            System.out.println("Cutting " + cutseat.getVisitor().toString() + " in progress - " + i + "%");
            try {
                barberThread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        toWalkClientOut();
    }
    public void toWalkClientOut(){
        Visitor toWalkOut = cutseat.visitor;
        cutseat.setVisitor(null);
        for (int i=0;i<100;i+=33){
            System.out.println("Walking out  " + toWalkOut + " in progress - " + i + "%");
            try {
                barberThread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    private class BarberThread extends Thread{
        @Override
        public void run() {
        while (cutseat.getVisitor()!=null){
            toCut();
        }
            try {
                System.out.println("Barber is sleeping");
                barberThread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            run();
        }
    }
}
