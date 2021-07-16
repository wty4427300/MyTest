package com.algorithm;

import edu.princeton.cs.algs4.StdDraw;

public class test2 {

    public static void draw1(){
        StdDraw.setPenRadius(0.05);
        StdDraw.setPenColor(StdDraw.BLUE);
        StdDraw.point(0.5, 0.5);
    }

    public static void draw2() throws InterruptedException {
        int n=500;
        StdDraw.setXscale(0,n);
        StdDraw.setYscale(0,n*n);
        StdDraw.setPenRadius(.01);
        for(int i=1;i<=n;i++){
            if (i%2==0){
                StdDraw.setPenColor(StdDraw.RED);
            }else {
                StdDraw.setPenColor(StdDraw.GREEN);
            }
            StdDraw.point(i,i);
            Thread.sleep(10);
            if (i%2==0){
                StdDraw.setPenColor(StdDraw.YELLOW);
            }else {
                StdDraw.setPenColor(StdDraw.BLUE);
            }
            StdDraw.point(i,i*i);
            Thread.sleep(20);
            if (i%2==1){
                StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            }else {
                StdDraw.setPenColor(StdDraw.GREEN);
            }
            StdDraw.point(i,i*Math.log(i));
        }
    }

    public static void draw3() throws InterruptedException {
        StdDraw.clear(StdDraw.BLACK);
        StdDraw.setScale(-2, +2);
        StdDraw.enableDoubleBuffering();
        int i=0;
        for (double t = 0.0; true; t += 0.01) {
            double x = Math.sin(t);
            double y = Math.cos(t);
            if (i%2==0){
                StdDraw.setPenColor(StdDraw.RED);
            }else {
                StdDraw.setPenColor(StdDraw.GREEN);
            }
            i++;
            Thread.sleep(1);
            StdDraw.filledCircle(x, y, 0.05);
            if (i%2==0){
                StdDraw.setPenColor(StdDraw.YELLOW);
            }else {
                StdDraw.setPenColor(StdDraw.BLACK);
            }
            StdDraw.filledCircle(-x, -y, 0.05);
            StdDraw.show();
            StdDraw.pause(20);
        }
    }
    public static void main(String[] args) {
        try {
//            draw1();
//            draw2();
            draw3();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
