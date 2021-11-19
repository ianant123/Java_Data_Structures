package com.datastructures.array;

//https://www.geeksforgeeks.org/array-rotation/
//Write a function rotate(ar[], d, n) that rotates arr[] of size n by d elements.

public class ArrayRotation {

    public static void leftRotate(int[] array, int d){
        int length = array.length;
        if(d <= 0 || d == length){
            return;
        }
        int i = 0;
        int temp = array[i];
        for(; i < length - 1; i++){
            array[i] = array[i+1];
        }
        array[i] = temp;
        leftRotate(array,d - 1);

    }


    public static void main(String[] args) {


        int[] arr = { 1, 2, 3, 4, 5, 6, 7 };
        leftRotate(arr, 2);
        System.out.println("printing the array");
        for (int j : arr) {
            System.out.print(j + ",");
        }
    }
}
