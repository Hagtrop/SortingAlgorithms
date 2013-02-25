package com.hagtrop.sorting;

import java.util.ArrayList;

public class Swap {
    static void execute(ArrayList<Integer> array, int index1, int index2){
        Integer n = array.get(index1);
        array.set(index1, array.get(index2));
        array.set(index2, n);
    }
}
