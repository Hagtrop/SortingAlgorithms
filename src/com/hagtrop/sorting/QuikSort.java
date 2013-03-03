package com.hagtrop.sorting;

import java.util.ArrayList;

public class QuikSort {
    static void sort(ArrayList<Integer> array, int startPos, int endPos){
        if(endPos-startPos == 1){
            if(array.get(startPos) > array.get(endPos))
                Swap.execute(array, startPos, endPos);
            return;
        }
        int i = startPos;
        int j = endPos;
        int middlePos = (startPos + endPos)/2;
        int middle = array.get(middlePos);
        while(i < j){
            while(array.get(i) < middle && i<endPos) ++i;
            while(array.get(j) > middle) --j;
            if(i<j){
                Swap.execute(array, i, j);
                i++;
                j--;
            }
        }
        if(startPos < j) sort(array, startPos,j);
        if(endPos > i) sort(array, i, endPos);
    }
}
