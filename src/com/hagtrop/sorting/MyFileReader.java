package com.hagtrop.sorting;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class MyFileReader {
    static ArrayList getArray(File file) throws IOException{
        ArrayList<Integer> array = new ArrayList<>();
        try(BufferedReader br = new BufferedReader(new FileReader(file))){
            
            String nextStr;
            while((nextStr = br.readLine()) != null){
                nextStr = nextStr.trim();
                String[] subStrings = nextStr.split("[\\s]+");
                for(String str : subStrings){
                    array.add(Integer.parseInt(str));
                }
            }
            
        }
        return array;
    }
}
