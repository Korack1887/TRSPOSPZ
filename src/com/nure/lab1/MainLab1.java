package com.nure.lab1;

import java.awt.image.BufferedImage;
import java.io.IOException;

public class MainLab1 {

    public static void main(String[] args) {
        long startProgram = System.currentTimeMillis();
        String filePath = "src/com/nure/lab1/Ducky_Head_Web_Low-Res.jpg";
        BufferedImage image = MedianFilter.getImageFromFile(filePath);
        System.out.println(System.currentTimeMillis()-startProgram + " - image from file");
        int test[][] = MedianFilter.filter(filePath,1);
        long startTime = System.currentTimeMillis();
        try {
            TextToImageUtil.textToImage("testFile.jpg", image.getWidth(), image.getHeight(), test);
        } catch (IOException e) {
            e.printStackTrace();
        }
        System.out.println(System.currentTimeMillis()-startTime + " - print picture");
        System.out.println(System.currentTimeMillis()-startProgram + " - summary");
    }
}
