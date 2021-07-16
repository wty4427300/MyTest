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
            if (i%2==1){
                StdDraw.setPenColor(StdDraw.LIGHT_GRAY);
            }else {
                StdDraw.setPenColor(StdDraw.GREEN);
            }
            StdDraw.point(i,i*Math.log(i));
        }
    }
    public static void main(String[] args) {
        try {
            draw1();
            draw2();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
