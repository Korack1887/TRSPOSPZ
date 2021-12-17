package com.nure.lab2.nomer7;


public class Food {
    int food;
    public void eatFood(){
        food--;
    }
    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public Food() {
        this.food = 9;
    }
}
