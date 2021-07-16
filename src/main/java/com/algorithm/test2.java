package com.algorithm;

import edu.princeton.cs.algs4.StdDraw;

import java.awt.*;


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

    public static void draw3(String tips,int tx,double radius,int multiple) throws InterruptedException {
        int i=0;
        for (double t = tx; true; t += 1.5) {
            StdDraw.clear(Color.BLACK);
            System.out.println(tips);
            double x = Math.sin(t);
            double y = Math.cos(t);
            if (i%2==0){
                StdDraw.setPenColor(StdDraw.RED);
            }else {
                StdDraw.setPenColor(StdDraw.GREEN);
            }
            i++;
            Thread.sleep(1);
            StdDraw.filledCircle(multiple*x,multiple*y, radius);
            if (i%2==0){
                StdDraw.setPenColor(StdDraw.YELLOW);
            }else {
                StdDraw.setPenColor(StdDraw.BLUE);
            }
            StdDraw.filledCircle(multiple*-x,multiple*-y, radius);
            StdDraw.show();
            StdDraw.pause(20);
        }
    }


    public static void main(String[] args) {
        StdDraw.setScale(-2,2);
        StdDraw.enableDoubleBuffering();
        Thread thread1=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    draw3("第一个",0,0.08,1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread2=new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    draw3("第二个",1,0.1,2);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });
        Thread thread3=new Thread(new Runnable() {
            @Override
            public void run() {
                StdDraw.setPenRadius(0.05);
                StdDraw.setPenColor(StdDraw.BLUE);
                StdDraw.point(0, 0);
            }
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }
}
