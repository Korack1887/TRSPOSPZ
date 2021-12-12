package com.nure.lab1;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class MedianFilter {
    public static int[][] filter(String filePath, int threadCounter) {
        int[][] imageArr = new int[0][0];
        BufferedImage image = getImageFromFile(filePath);
        if (image == null) {
            return imageArr;
        }
        imageArr = new FilterThreadPool(image, threadCounter).startFilter();
        return imageArr;
    }

    public static BufferedImage getImageFromFile(String filePath) {
        BufferedImage image;
        try {
            image = ImageIO.read(new File(filePath));
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("Can`t find such file, try another one");
            return null;
        }
        return image;
    }
}
