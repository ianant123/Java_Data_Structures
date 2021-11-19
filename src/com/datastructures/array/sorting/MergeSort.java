package com.datastructures.array.sorting;

public class MergeSort {

    public static void merge(int[] arr, int l, int m, int r){

        int i = l;
        int j = m+1;

        int tempArraySize = r - l + 1;
        int k = 0;

        int[] temp = new int[tempArraySize];

        while(i<=m && j<=r){
            if(arr[i]<arr[j])
            {
                temp[k++] = arr[i++];
            }
            else{
                temp[k++] = arr[j++];
            }
        }

        while(i<=m){
            temp[k++] = arr[i++];
        }
        while(j<=r){
            temp[k++] = arr[j++];
        }

        i = l;
        for(k = 0; k<tempArraySize; k++, i++){
            arr[i] = temp[k];
        }

    }

    public static void mergeSort(int[] arr, int l, int r){
        if(l<r) {
            int m = l + (r-l)/2;
            mergeSort(arr, l, m);
            mergeSort(arr, m + 1, r);
            merge(arr, l, m, r);
        }
    }

    public static void main(String[] args){
        int[] arr = {10,80, 60, 40, 90, 12};
        // int arr[] = {100,80};
        int r = arr.length-1;
        int l = 0;
        int m = (r-1)/2;
        System.out.println("m " +m);
        System.out.println("r " +r);

        mergeSort(arr, l , r);

        System.out.println("printing the array");
        for(int i = 0; i<=r ; i++){
            System.out.print(arr[i] + ",");
        }
    }
}
