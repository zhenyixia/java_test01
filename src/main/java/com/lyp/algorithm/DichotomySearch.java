package com.lyp.algorithm;

/**
 * 二分法查询
 */
public class DichotomySearch {


    /**
     * @param arrays 目标数组
     * @param a      要查找的元素
     * @return 要查找元素所在目标数组的下标
     */
    public static int search(int[] arrays, int a) {
        if (arrays == null || arrays.length == 0) {
            return -1;
        }

        int startPos = 0;
        int endPos = arrays.length;
        int middlePos = (startPos + endPos) / 2;

        while (startPos < endPos) {
            int middleVal = arrays[middlePos];
            if (a == middleVal) return middlePos;
            if (a > middleVal) {
                startPos = middlePos + 1;
            }
            if (a < middlePos) {
                endPos = middlePos - 1;
            }

            middlePos = (startPos + endPos) / 2;
        }

        return -1;
    }

    public static void main(String[] args) {
        int[] arrays = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        int index = search(arrays, 10);
        System.out.println(index);
    }
}
