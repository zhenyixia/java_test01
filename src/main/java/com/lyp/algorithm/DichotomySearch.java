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
        int endPos = arrays.length - 1;
        int middlePos = (startPos + endPos) / 2;

        int count = 1;
        while (startPos <= endPos) {

            int middleVal = arrays[middlePos];
            if (a == middleVal) {
                System.out.println(a + ": -- " + count);
                return middlePos;
            }
            if (a > middleVal) {
                startPos = middlePos + 1;
            }
            if (a < middlePos) {
                endPos = middlePos - 1;
            }

            middlePos = (startPos + endPos) / 2;
            count++;
        }
        return -1;
    }

    public static void main(String[] args) {
        int[] arrays = new int[10000];
        for (int i = 0; i < 10000; i++) {
            arrays[i] = i;
        }

        //查看找到数组每一个元素需要的次数
        for (int i = 0; i < 10000; i++) {
            int index = search(arrays, i);
            if (index == -1) {
                System.out.println(i);
            }
        }

    }
}
