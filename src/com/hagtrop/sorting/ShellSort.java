package com.hagtrop.sorting;

import java.util.ArrayList;

public class ShellSort {
    static void sort(ArrayList<Integer> array){
        int size = array.size();
        int h = 1;
        while(h < size/3) h = 3*h + 1;
        while(h>=1){ //change distance between elements for comparing
             for(int i=0; i<h; i++){ //iterates through groups
                 int j = i + h;
                 while(j < size){//sorting elements of current group by "insertion"
                     int k = j;
                     while(k-h >= 0 && array.get(k-h) > array.get(k)){
                         Swap.execute(array, k-h, k);
                         k = k-h;
                     }
                     j += h;
                 }
             }
             h = h/3;
        }
    }
}
