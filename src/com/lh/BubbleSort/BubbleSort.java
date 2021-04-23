package com.lh.BubbleSort;

import com.lh.Sort.IArraySort;

import java.util.Arrays;

/**
 * @Author: LH
 * @Date: 2020/10/21 15:10
 */
public class BubbleSort implements IArraySort {

    public static int[] sort(int[] sourceArray) {
        int[] arr = Arrays.copyOf(sourceArray, sourceArray.length);
        for (int i = 1; i < arr.length; i++) {
            boolean flag = true;

            for (int j = 0; j < arr.length - i; j++) {
                if (arr[j] > arr[j + 1]) {
                    int tmp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = tmp;

                    flag = false;
                }
            }
            if (flag) {
                break;
            }
        }
        return arr;
    }

    public static void main(String[] args) {
        int[] arr = {12, 5, 15, 8, 66, 44, 12, 52, 20};
        int[] result = sort(arr);
        for (int value : result) {
            System.out.println(value);
        }
    }
}
