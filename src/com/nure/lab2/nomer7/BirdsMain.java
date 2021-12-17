package com.nure.lab2.nomer7;

public class BirdsMain {
    public static void main(String[] args) {
        Food food = new Food();
        MamaBird mamaBird = new MamaBird(food);
        mamaBird.start();
        for (int i=0;i<4;i++){
           LittleBird littleBird = new LittleBird(food, mamaBird);
           littleBird.setName("Bird - " + i);
           littleBird.start();
        }
    }
}
