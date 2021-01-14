package com.andy.interview;

import java.util.Arrays;
/*
arr[] = {10, 80, 30, 90, 40, 50, 70}
Indexes:  0   1   2   3   4   5   6

low = 0, high =  6, pivot = arr[h] = 70
Initialize index of smaller element, i = -1

Traverse elements from j = low to high-1
j = 0 : Since arr[j] <= pivot, do i++ and swap(arr[i], arr[j])
i = 0
arr[] = {10, 80, 30, 90, 40, 50, 70} // No change as i and j
                                     // are same

j = 1 : Since arr[j] > pivot, do nothing
// No change in i and arr[]

j = 2 : Since arr[j] <= pivot, do i++ and swap(arr[i], arr[j])
i = 1
arr[] = {10, 30, 80, 90, 40, 50, 70} // We swap 80 and 30

j = 3 : Since arr[j] > pivot, do nothing
// No change in i and arr[]

j = 4 : Since arr[j] <= pivot, do i++ and swap(arr[i], arr[j])
i = 2
arr[] = {10, 30, 40, 90, 80, 50, 70} // 80 and 40 Swapped
j = 5 : Since arr[j] <= pivot, do i++ and swap arr[i] with arr[j]
i = 3
arr[] = {10, 30, 40, 50, 80, 90, 70} // 90 and 50 Swapped

We come out of loop because j is now equal to high-1.
Finally we place pivot at correct position by swapping
arr[i+1] and arr[high] (or pivot)
arr[] = {10, 30, 40, 50, 70, 90, 80} // 80 and 70 Swapped

Now 70 is at its correct place. All elements smaller than
70 are before it and all elements greater than 70 are after
it.
 */

public class QuickSort {
    public static void main(String[]ss){
        int []arr =new int[]{1,5,3,8,7,9};
        QuickSort(arr,0,arr.length-1);
        Arrays.stream(arr).forEach(System.out::println);
    }
    public static void QuickSort(int []arr, int begin,int end){
        if( (begin < end))
        {
            int tmp = partition(arr, begin, end);
            QuickSort(arr, begin, tmp - 1);
            QuickSort(arr, tmp + 1, end);
        }

    }
   public static int  partition(int[]arr,int low,int high)
    {
        // pivot (Element to be placed at right position)
        int pivot = arr[high];
int i= (low - 1) ; // Index of smaller element

        for (int j = low; j <= high- 1; j++)    //注意这里实际是移动pivot，比如10, 80,70， 30，然后把pivot左右两边j与i的对应数交换 ；还可以有其他寻找方式
        {
            // If current element is smaller than the pivot
            if (arr[j] < pivot)
            {
                i++;    // increment index of smaller element
                swap(arr,i, j);
            }
        }
        swap (arr,i + 1 ,high);
        return (i + 1);
    }
    public static void swap(int []arr,int a,int b){
        int tmp=arr[a];
        arr[a]=arr[b];
        arr[b]=tmp;
    }
}
