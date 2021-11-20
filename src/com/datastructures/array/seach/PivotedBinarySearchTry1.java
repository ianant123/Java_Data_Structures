package com.datastructures.array.seach;

//Search an element in a sorted and rotated array
/*
* Search an element in a sorted and rotated array
* An element in a sorted array can be found in O(log n) time via binary search.
* But suppose we rotate an ascending order sorted array at some pivot unknown to you beforehand.
* So for instance, 1 2 3 4 5 might become 3 4 5 1 2.
* Devise a way to find an element in the rotated array in O(log n) time.
*
* */

/* Java program to search an element
   in a sorted and pivoted array*/

public class PivotedBinarySearchTry1 {

    /* Searches an element key in a
       pivoted sorted array array[]
       of size n */
    public static int pivotedBinarySearch(int[] array, int key){
        int length = array.length;

        int pivot = findPivot(array,0, length-1);
        System.out.println("findPivot  : " + pivot);

        // If we didn't find a pivot, then
        // array is not rotated at all
        if(pivot == -1)
            return binarySearch(array, key, 0, length-1);

        // If we found a pivot, then first
        // compare with pivot and then
        // search in two sub-arrays around pivot
        if(array[pivot] == key)
            return pivot;
        if(array[0] <= key)
            return binarySearch(array, key, 0, pivot - 1);
        return binarySearch(array, key, pivot + 1, length - 1);
    }

    /* Standard Binary Search function */
    static int binarySearch(int[] array, int key, int low, int high){
        int mid = (high + low)/2;
//        System.out.println("low: " + low + "mid: " + mid + "high: " + high);
        if(low > high)
            return -1;
        if(array[mid] == key)
            return mid;
        if (key > array[mid])
            return binarySearch(array, key, (mid + 1), high);
        return binarySearch(array, key, low, (mid - 1));
    }

    /* Function to get pivot. For array
       3, 4, 5, 6, 1, 2 it returns
       3 (index of 6) */
    public static int findPivot(int[] array, int low, int high){
        int mid = low + (high - low)/2;
        if(low > high)
            return -1;
//        System.out.println("low: " + low + "mid: " + mid + "high: " + high);
        if(mid < high && array[mid] > array[mid + 1])
            return mid;
        if(mid > low && array[mid] < array[mid - 1])
            return mid - 1;
        if (array[low] >= array[mid])
            return findPivot(array, low, mid - 1);
        return findPivot(array, mid + 1, high);
    }

    // main function
    public static void main(String[] args){
        // Let us search 3 in below array
        int[] arr1 = { 5, 6, 7, 8, 9, 10, 1, 2, 3 };
        int key = 3;
        System.out.println("Index of the element is : "
                + pivotedBinarySearch(arr1, key));
    }
}
