package com.datastructures.array.seach;

/* Java program to search an element in
   sorted and rotated array using
   single pass of Binary Search*/

public class PivotedBinarySearchTry2 {

    static int searchSingleScan(int[] array, int low, int high, int key){
        int mid = (high + low)/2;
        if(low > high)
            return -1;
        if(array[mid] == key)
            return mid;

        /* If arr[l...mid] first sub array is sorted */
        if(array[low] < array[mid]){
            if(key >= array[low] && key <= array[mid])
                return searchSingleScan(array, low, mid -1, key);
            return searchSingleScan(array, mid + 1, high, key);
        }

        if(key >= array[mid] && key <= array[high])
            return searchSingleScan(array, mid + 1, high, key);
        return searchSingleScan(array, low, mid -1, key);
    }

    // main function
    public static void main(String[] args){
        // Let us search 3 in below array
        int[] arr1 = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
        int key = 8;
        System.out.println("Index of the element is : " + searchSingleScan(arr1, 0, arr1.length - 1, key));
    }
}
