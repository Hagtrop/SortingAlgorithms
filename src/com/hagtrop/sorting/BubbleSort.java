package com.hagtrop.sorting;

import java.util.ArrayList;

public class BubbleSort {
    static void sort(ArrayList<Integer> array){
        boolean sorted = false;
        int size = array.size();
        int i = 0;
        while(++i < size && !sorted){
            sorted = true;
            for(int j = 0; j<size-i; j++){
                if(array.get(j) > array.get(j+1)){
                    Swap.execute(array, j, j+1);
                    sorted = false;
                }
            }
        }
    }
}
