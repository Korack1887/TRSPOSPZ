package com.nure.lab1;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

public class TextToImageUtil {
    public static void textToImage(String path, int width, int height, int[][] data) throws IOException {
        BufferedImage bufferedImage = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
        for (int i =0; i<width;i++){
            for (int j=0; j<height;j++){
                bufferedImage.setRGB(i,j, data[j][i]);
            }
        }
        ImageIO.write(bufferedImage, "jpg", new File(path));
        System.out.println("Done! Check the result");
    }
}
