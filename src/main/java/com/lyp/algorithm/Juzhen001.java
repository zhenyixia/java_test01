package com.lyp.algorithm;

import java.util.Arrays;

/**
 * 矩阵算法 001
 */
public class Juzhen001 {
    /*
        求数值1在矩阵中最大数量是多少：现在有一个尺寸为width*height的矩阵M，矩阵中的每个单元格的值不是0就是1。
        而且矩阵M中每个大小为sideLength*sideLength的正方形子阵中，1的数量 不得超过maxOnes。

        请你设计一个算法，计算矩阵中最多可以有多少个1。
        示例1：
        输入: width = 3, height = 3,sideLength = 2,maxOnes = 1
        输出 ： 4
        [1,0,1]
        [0,0,0]
        [1,0,1]

        示例2：
        输入: width = 3, height = 3,sideLength = 2,maxOnes = 2
        输出 ： 6
        [1,0,1]
        [1,0,1]
        [1,0,1]

        提示：
        1 <= width, height <= 100
        1 <= sideLength <= width,height
        0 <= maxOnes <= sideLength * sideLength
     */


    /*
        第一种算法实现原理
        从示例输出可以推测出：
        1，1必须在最边角才能有最多。如示例1，如果1在 3 * 3的中心，则只能有一个1。如下：
        [0,0,0]
        [0,1,0]
        [0,0,0]
        2，从最边角(0,0)位置开始，以sideLength*sideLength为单位，依次填1，直到达到maxOnes。如果到边界则停止。
            如示例1：
            [1,0,1]
            [0,0,0]
            [1,0,1]
            最边角坐标 (0,0)填一个1，即达到maxOnes，所以不用再填。到下一个sideLength*sideLength 的最边角(0，2))，
            以及最后一个单元sideLength*sideLength的最起始边角(2,2)

            如示例2：
            [1,1,1]
            [0,0,0]
            [1,1,1]
            最边角坐标 (0,0)填一个1，未达到maxOnes，所以继续再填。到下一个坐标(0,1)填1后即达到maxOnes，所以后面(1,0),(1,1)就不用再填。
            然后到下一个sideLength*sideLength 的最边角(0，2)填1后横方向到达边界，即停止。
            第三行的第一个单元sideLength*sideLength的最起始边角(2,0)填一个1，未达到maxOnes，所以继续再填(2,1)后达到maxOnes，也终止。
            第三行的第二个单元sideLength*sideLength的最起始边角(2,2)填一个1，未达到maxOnes，但是已经到达边界，也终止。
            最终形成上的效果。
        2，width 和 height 可能不相等，选择值比较大的依次填充1。由于上面我们的填充方向是先填横方向，这种情况会造成如果height > width时，
        有时候会少计算，如 width*height:3 * 5, sideLenth:2,  maxOnes:2时，按上面的规则我们填充是这样的：
            [1,1,1]
            [0,0,0]
            [1,1,1]
            [0,0,0]
            [1,1,1]
            最大为9

            [1,1,1,1,1]
            [0,0,0,0,0]
            [1,1,1,1,1]
            最大为10



     */
    public static int maximumNumberOfOnes(int width, int height, int sideLength, int maxOnes) {
        int temp;
        if (height > width) {
            temp = width;
            width = height;
            height = temp;
        }

        int[][] a = new int[height][width];


        //初始化一个全为1的二维数组
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                a[i][j] = 1;
            }
        }

        int total = 0;
        for (int x = 0; x < width; x++) {
            for (int y = 0; y < height; y++) {

                for (int i = y; i < y + sideLength && i < height; i++) {
                    for (int j = x; j < x + sideLength && j < width; j++) {
                        if (i == y && j == x) {
                            total = 0;
                            total += a[i][j];
                            continue;
                        }

                        total += a[i][j];
                        if (total > maxOnes) {
                            total -= a[i][j];
                            a[i][j] = 0;
                        }
                    }
                }
            }
        }

        System.out.println(Arrays.deepToString(a));

        int count = 0;
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                count += a[i][j];
            }
        }

        return count;
    }


    public static int maximumNumberOfOnes2(int width, int height, int sideLength, int maxOnes) {
        int[] arr = new int[sideLength * sideLength];
        for (int i = 0; i < height; i++) {
            for (int j = 0; j < width; j++) {
                int row = i % sideLength;
                int col = j % sideLength;
                ++arr[row * sideLength + col];
            }
        }

        //升序
        Arrays.sort(arr);

        //结果
        int ans = 0;

        //1的数量
        for (int i = 0; i < maxOnes; ++i) {
            ans += arr[arr.length - 1 - i];
        }

        return ans;
    }

    public static void main(String[] args) {
        int width = 6;
        int height = 9;
        int sideLength = 2;
        int maxOnes = 1;
        int ans1 = maximumNumberOfOnes(width,height,sideLength,maxOnes);
        int ans2 = maximumNumberOfOnes2(width,height,sideLength,maxOnes);

        System.out.println(ans1);
        System.out.println(ans2);

    }
}
