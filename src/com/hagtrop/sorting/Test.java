package com.hagtrop.sorting;

import java.util.ArrayList;

public class Test {
    static boolean arraySorted(ArrayList<Integer> array){
        boolean sorted = true;
        for(int i=1; i<array.size(); i++){
            if(array.get(i) < array.get(i-1)){
                sorted = false;
                break;
            }
        }
        return sorted;
    }
}
