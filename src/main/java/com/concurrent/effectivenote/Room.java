//package com.concurrent.effectivenote;
//
//import sun.misc.Cleaner;
//
//
////一般写native的时候可以用finalize
////因为他不是一个java对象,所以比较适合使用finalize回收
////这个只写了一半肯定是错的,主要是本地也没有open jdk9的环境暂时就这样吧
//public class Room implements AutoCloseable{
//    private final State state;
//
//    private static final Cleaner cleaner=Cleaner.create(new Room(10),new State(10));
//
//    public Room(int numJunPiles) {
//        state=new State(numJunPiles);
//    }
//
//    @Override
//    public void close() throws Exception {
//
//    }
//
//    private static class State implements Runnable{
//        int numJunPiles;
//
//        public State(int numJunPiles) {
//            this.numJunPiles = numJunPiles;
//        }
//
//        @Override
//        public void run() {
//            System.out.println("Clear Room");
//            numJunPiles= 0;
//        }
//    }
//
//}
