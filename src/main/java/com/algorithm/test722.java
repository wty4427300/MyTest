//package com.algorithm;
// todo
//import java.util.ArrayDeque;
//import java.util.Arrays;
//import java.util.List;
//import java.util.Queue;
//
//public class test722 {
//    public List<String> removeComments(String[] source) {
//        Queue<String> queue=new ArrayDeque<>();
//        Arrays.stream(source).filter(
//                it->{
//                    queue.
//                    for(int i=0;i<it.length();i++){
//                        if (it.charAt(i)=='/'){
//                            if (it.charAt(i+1)=='/'){
//                                //单行注释
//                                return false;
//                            }else {
//                                //可能多行注释
//                                queue.add()
//                            }
//                        }
//                    }
//                }
//        )
//    }
//
//    public static void main(String[] args) {
//        String[] source = new String[]{
//                "/*Test program */",
//                "int main()",
//                "{ ",
//                "  // variable declaration ",
//                "int a, b, c;",
//                "/* This is a test",
//                "   multiline  ",
//                "   comment for ",
//                "   testing */",
//                "a = b + c;",
//                "}"};
//    }
//}
