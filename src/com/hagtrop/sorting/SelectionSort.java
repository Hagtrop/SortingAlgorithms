package com.hagtrop.sorting;

import java.util.ArrayList;

public class SelectionSort {
    static void unidir(ArrayList<Integer> array){
        int size = array.size();
        int min;
        for(int i=0; i<size-1; i++){
            min = i;
            for(int j=i+1; j<size; j++){
                if(array.get(j) < array.get(min)) min = j;
            }
            if(min > i) Swap.execute(array, i, min);
        }
    }
    static void bidir(ArrayList<Integer> array){
        int size = array.size();
        //minInd, maxInd - current index of minimum and maximum
        //maxPos - index of position for maximum
        int minInd, maxInd, maxPos;
        for(int i=0; i<size/2; i++){
            minInd = i;
            maxInd = maxPos = (size-1)-i;
            if(array.get(i) > array.get(maxPos)) Swap.execute(array, i, maxPos);
            for(int j=i+1; j<maxPos; j++){
                if(array.get(j) < array.get(minInd)) minInd = j;
                if(array.get(j) > array.get(maxInd)) maxInd = j;
            }
            if(minInd > i) Swap.execute(array, i, minInd);
            if(maxInd < maxPos) Swap.execute(array, maxPos, maxInd);
        }
    }
}
