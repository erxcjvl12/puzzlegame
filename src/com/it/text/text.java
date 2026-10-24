package com.it.text;

import java.util.Random;

public class text {
    public static void main(String[] args) {
        //定义数组
        int[] temArr = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11, 12, 13, 14, 15};
        //循环遍历打乱通过随机索引打乱数组
        Random r = new Random();
        for (int i = 0; i < temArr.length; i++) {
            int index = r.nextInt(temArr.length);
            //拿着数组索引进行交换
            int temp = temArr[i];
            temArr[i] = temArr[index];
            temArr[index] = temp;
        }
        for (int i = 0; i < temArr.length; i++) {
            System.out.print(temArr[i] + " ");
        }
        System.out.println();
        //下面把打乱的一维数组循环遍历到二维数组中可以采用两种解法
        //解法一：循环遍历一维数组
        int[][] data = new int[4][4];
        for (int i = 0; i < temArr.length; i++) {
            data[i / 4][i % 4] = temArr[i];
        }
        //解法二：循环遍历二维数组
        /*1
        int index = 0;
        for (int i = 0; i < temArr.length; i++) {
            for (int j = 0; j < temArr.length; j++) {
                data[i][j] = temArr[index];
                index++;
            }
        }*/
        //打印二维数组
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                System.out.print(data[i][j] + " ");
            }
            System.out.println();
        }
    }
}
