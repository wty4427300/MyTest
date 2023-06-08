package com.algorithm_template.code;

import java.util.Arrays;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class MergeSort {

    private static class MergeSortTask extends RecursiveAction {
        private final int[] array;
        private final int left;
        private final int right;

        public MergeSortTask(int[] array, int left, int right) {
            this.array = array;
            this.left = left;
            this.right = right;
        }

        @Override
        protected void compute() {
            if (left < right) {
                int mid = (left + right) / 2;

                MergeSortTask leftTask = new MergeSortTask(array, left, mid);
                MergeSortTask rightTask = new MergeSortTask(array, mid + 1, right);

                invokeAll(leftTask, rightTask);

                merge(array, left, mid, right);
            }
        }

        private void merge(int[] array, int left, int mid, int right) {
            int[] temp = new int[right - left + 1];
            int i = left;
            int j = mid + 1;
            int k = 0;

            while (i <= mid && j <= right) {
                if (array[i] <= array[j]) {
                    temp[k] = array[i];
                    i++;
                } else {
                    temp[k] = array[j];
                    j++;
                }
                k++;
            }

            while (i <= mid) {
                temp[k] = array[i];
                i++;
                k++;
            }

            while (j <= right) {
                temp[k] = array[j];
                j++;
                k++;
            }

            System.arraycopy(temp, 0, array, left, temp.length);
        }
    }

    public static void mergeSort(int[] array) {
        ForkJoinPool forkJoinPool = new ForkJoinPool();
        MergeSortTask mergeSortTask = new MergeSortTask(array, 0, array.length - 1);
        forkJoinPool.invoke(mergeSortTask);
    }

    public static void main(String[] args) {
        int[] array = {5, 2, 9, 1, 3, 6, 4, 8, 7};
        mergeSort(array);
        System.out.println(Arrays.toString(array));
    }
}
