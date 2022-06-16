package com.algorithm;

public class test1089 {
    public void duplicateZeros(int[] arr) {
        int length = arr.length;
        int top = 0;
        int i = -1;
        while (top < length) {
            i++;
            if (arr[i] != 0) {
                top++;
            } else {
                top += 2;
            }
        }
        int j = length - 1;
        //压栈最后一位为0的情况
        if (top == length + 1) {
            arr[j] = 0;
            j--;
            i--;
        }
        while (j >= 0) {
            arr[j] = arr[i];
            j--;
            if (arr[i] == 0) {
                arr[j] = arr[i];
                j--;
            }
            i--;
        }
    }

    public static void main(String[] args) {
        int[] arr={1,0,2,3,0,4,5,0};
        test1089 test1089=new test1089();
        test1089.duplicateZeros(arr);
    }
}
