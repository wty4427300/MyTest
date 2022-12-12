package com.algorithm;

class Allocator {

    private int[] arr;
    private int n;

    public Allocator(int n) {
        this.n = n;
        arr = new int[n];
    }

    public int allocate(int size, int mID) {
        if (size > n) {
            return -1;
        }
        int i = 0;
        while (i < n) {
            //跳过已被分配的位置
            while (i < n && arr[i] > 0) {
                i++;
            }
            int start = i;
            while (i < n && arr[i] == 0) {
                i++;
            }
            if (i - start >= size) {
                for (int j = start; j < start + size; j++) {
                    arr[j] = mID;
                }
                return start;
            }
            i++;
        }
        return -1;
    }

    public int free(int mID) {
        int i = 0;
        int count = 0;
        while (i < n) {
            if (arr[i] == mID) {
                ++count;
                arr[i] = 0;
            }
            ++i;
        }
        return count;
    }
}
