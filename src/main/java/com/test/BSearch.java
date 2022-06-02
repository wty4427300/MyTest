package com.test;

/**
 * 准备的二分法模版，有更好的思路再改
 */
public class BSearch {

    public static void main(String[] args) {
        int[] a = {1, 2, 3, 4, 5, 6, 8};
        int rs = bSearch(a, a.length, 5);
        System.out.println("该数在数组中的下标为" + rs);
        int low =2;
        int high =6;
        int mid = low + ((high - low) >> 1);
        System.out.println("mid的值为"+mid);
        int b=2<<1;
        System.out.println(b);
    }

    public static int bSearch(int[] a, int n, int value) {
        //头下标
        int low = 0;
        //尾下标
        int high = n - 1;
        while (low <= high) {
            //二分法吗，必须要获得中位数下标
            int mid = (low + high) / 2;
            //如果这个下标获取的元素刚好是我想要查询的值，直接返回就好下标
            if (a[mid] == value) {
                return mid;
            } else if (a[mid] < value) {
                //如果mid下标获取的值小于value,就说明value在[mid+,high]这个范围内
                low = mid + 1;
            } else {
                //如果mid下标获取的值大于value,就说明value在[low,mid-1]这个范围内
                high = mid - 1;
            }
        }
        return -1;
    }

    public static int bSearchByTwo(int[] a, int n, int value) {
        return bsearchInternally(a, 0, n - 1, value);
    }

    public static int bsearchInternally(int[] a, int low, int high, int value) {
        if (low > high) {
            //头下标如果大于为下标了，那么就说明数组越界了返回-1，表示错误
            return -1;
        }
        int mid = low + ((high - low) >> 1);
        if (a[mid] == value) {
            return mid;
        } else if (a[mid] < value) {
            return bsearchInternally(a, mid + 1, high, value);
        } else {
            return bsearchInternally(a, low, mid - 1, value);
        }
    }

    //元素重复的情况下，查找第一个元素==value的值
    public static int bsearch(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 2);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = high + 1;
            } else {
                if (mid == 0 || (a[mid - 1] != value)) {
                    return mid;
                } else {
                    high = mid - 1;
                }
            }
        }
        return -1;
    }

    //元素重复的情况下，查找最后一个元素==value的值
    public static int bsearchByLast(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 2);
            if (a[mid] > value) {
                high = mid - 1;
            } else if (a[mid] < value) {
                low = high + 1;
            } else {
                if (mid == 0 || (a[mid + 1] != value)) {
                    return mid;
                } else {
                    low= mid + 1;
                }
            }
        }
        return -1;
    }

    //元素重复的情况下，查找第一个大于等于给定元素的值
    public static int bsearchByFirst(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 2);
            if(a[mid]>=value){
                if (mid==0||a[mid-1]<value){
                    return mid;
                }else {
                    high=mid-1;
                }
            }else {
                low=mid+1;
            }
        }
        return -1;
    }

    //元素重复的情况下，查找最后一个一个小于等于给定元素的值
    public static int bSearchByFirst(int[] a, int n, int value) {
        int low = 0;
        int high = n - 1;
        while (low <= high) {
            int mid = low + ((high - low) >> 2);
            if(a[mid]>value){
                high=mid-1;
            }else {
                if (mid==0||a[mid+1]>value){
                    return mid;
                }else {
                    low=mid+1;
                }
            }
        }
        return -1;
    }
}

