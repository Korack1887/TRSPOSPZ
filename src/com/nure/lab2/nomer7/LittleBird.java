package com.nure.lab2.nomer7;

import java.util.Random;

public class LittleBird extends Thread{
    Food food;
    MamaBird mamaBird;
    private void callMamaBird(){
        mamaBird.isCalled.set(true);
    }
    public LittleBird(Food food, MamaBird mamaBird) {
        this.food = food;
        this.mamaBird = mamaBird;
    }

    @Override
    public void run() {
        while (true) {
            if (food.getFood() >0) {
                System.out.println(this.getName() + " is eating");
                food.eatFood();
                if (food.getFood()<=0){
                    callMamaBird();
                    System.out.println("no food");
                }
                try {
                    sleep(new Random().nextInt(1000));
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
