package com.nure.lab2.nomer4;

import java.util.LinkedList;

public class WaitSeat extends LinkedList<Visitor> {
    CutSeat cutSeat;
    private WaitSeatThread waitSeatThread;
    public WaitSeat(CutSeat cutSeat) {
        this.cutSeat  = cutSeat;
        waitSeatThread = new WaitSeatThread();
    }
    public void start(){
        waitSeatThread.start();
    }
    @Override
    public boolean add(Visitor o) {
        System.out.println("Total visitors waiting:" + size());
        if (!(this.size()+1>4)) {
            System.out.println(o.toString() + " on wait");
            return super.add(o);
        }
        System.out.println(o.toString() + " going home");
        return false;
    }

    private class WaitSeatThread extends Thread{
        @Override
        public void run() {
            while (true){
                if(cutSeat.getVisitor()==null && size()!=0){
                    cutSeat.setVisitor(getFirst());
                    System.out.println(getFirst() + " seated on cutSeat");
                    remove(getFirst());
                }
            }
        }
    }
}
