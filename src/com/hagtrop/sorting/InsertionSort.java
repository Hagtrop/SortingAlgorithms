package com.hagtrop.sorting;

import java.util.ArrayList;

public class InsertionSort {
    static void sort(ArrayList<Integer> array){
        int size = array.size();
        for(int i=1; i<size; i++){
            int j = i;
            while(--j >= 0 && array.get(j) > array.get(j+1)){
                Swap.execute(array, j, j+1);
            }
        }
    }
}
