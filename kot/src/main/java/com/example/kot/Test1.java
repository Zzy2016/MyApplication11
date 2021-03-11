package com.example.kot;

public class Test1 {

    public static void main(String[] args) {
        int[] array = new int[]{3, 2, 5, 7, 6, 1, 4, 9, 8};
        for (int i = 0; i < array.length; i++) {
            for (int j = i; j > 0; j--) {
                //array[j]  当前数 在当前数之前的列表中，找到位置
                if (array[j] < array[j - 1]) {
                    int temp = array[j];
                    array[j] = array[j - 1];
                    array[j - 1] = temp;
                }
            }
        }

        for (int a : array) {
            System.out.println(a);
        }
    }
}
