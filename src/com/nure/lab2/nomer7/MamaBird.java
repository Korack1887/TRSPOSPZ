package com.nure.lab2.nomer7;

import java.util.concurrent.atomic.AtomicBoolean;

public class MamaBird extends Thread{
    Food food;
    AtomicBoolean isCalled;
    public MamaBird(Food food) {
        this.food = food;
        isCalled = new AtomicBoolean(false);
    }

    @Override
    public void run() {
        while (true){
            if(isCalled.get()) {
                System.out.println("Mama bird get new food");
                food.setFood(9);
                isCalled.set(false);
            }
        }
    }
}
