package com.nure.lab1;

import java.awt.image.BufferedImage;
import java.util.Arrays;

public class FilterThreadPool {
    int[][] imageMatrix;
    int[][] sourceMatrix;
    BufferedImage image;
    FilterThread[] threadPool;

    public FilterThreadPool(BufferedImage image, int threadCount) {
        this.image = image;
        int imageHeight, imageWidth;
        imageHeight = image.getHeight();
        imageWidth = image.getWidth();
        sourceMatrix = new int[imageHeight][imageWidth];
        imageMatrix = new int[imageHeight][imageWidth];
        for (int i = 0; i < imageHeight; i++) {
            for (int j = 0; j < imageWidth; j++) {
                sourceMatrix[i][j] = image.getRGB(j, i);
            }
        }
        threadPool = new FilterThread[threadCount];
    }

    public int[][] startFilter() {
        int start = 0;
        for (int i = 0; i < threadPool.length; i++) {
            if (i != 0) {
                start += image.getHeight() / threadPool.length;
                threadPool[i - 1].setFinish(start);
            }
            FilterThread thread = new FilterThread(start);
            threadPool[i] = thread;
        }
        startThreads();
        while (anyActiveThreads()) {

        }
        return imageMatrix;
    }

    private boolean anyActiveThreads() {
        for (Thread thread : threadPool) {
            if (thread.isAlive()) {
                return true;
            }
        }
        return false;
    }

    private void startThreads() {
        for (FilterThread filterThread : threadPool) {
            filterThread.start();
        }
    }

    private class FilterThread extends Thread {
        int start;
        int finish;

        public FilterThread(int start) {
            super();
            this.start = start;
            finish = image.getHeight();
        }

        public void setFinish(int finish) {
            this.finish = finish;
        }

        @Override
        public void run() {
            int[][] localMatrix = new int[finish][image.getWidth()];
            for (int i = start; i < finish; i++) {
                for (int j = 0; j < image.getWidth(); j++) {
                    localMatrix[i][j] = applyFilter(image, i, j);
                }
            }
            System.arraycopy(localMatrix, 0, imageMatrix, start, finish-start);
        }

        private int applyFilter(BufferedImage image, int i, int j) {
            final int BLACK = -16711423;
            int[] arrayOfSmallMatrix = new int[9];
            int index = 0;
            int jIndex;
            int iIndex;
            for (int counterI = -1; counterI < 2; counterI++) {
                for (int counterJ = -1; counterJ < 2; counterJ++) {
                    iIndex = i + counterI;
                    jIndex = j + counterJ;
                    if (iIndex < 0 || jIndex < 0 || iIndex > image.getWidth() - 1 || jIndex > image.getHeight() - 1) {
                        //arrayOfSmallMatrix[index++] = BLACK;
                        return BLACK;
                    } else {
                        try {
                            arrayOfSmallMatrix[index++] = sourceMatrix[i][j];
                        } catch (ArrayIndexOutOfBoundsException e) {
                            e.printStackTrace();
                        }
                    }
                }
            }
            Arrays.sort(arrayOfSmallMatrix);
            return arrayOfSmallMatrix[4];
        }
    }
}
