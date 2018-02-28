/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortings;
import java.util.*;
import java.util.stream.Collectors;

/**
 *
 * @author MHK
 */
public class SortingsModel {
    
    private int[] intArray;
    private int arraySize;
    
    SortingsModel(int arraySize){
        this.arraySize = arraySize;
        intArray = getUnSortedList(this.arraySize);
    }
    
    public void reset(int size){
        
        intArray = getUnSortedList(size);
    }
    
    private int[] getUnSortedList(int size){
        int[] arrayToCreate = new int[size];
        for(int i = 1; i<size ; i++){
            arrayToCreate[i] = i;
        }
        List<Integer> newList = Arrays.stream(arrayToCreate).boxed().collect(Collectors.toList()); //built in function in Stream() class used to convert array to List
        Collections.shuffle(newList); //conversion to List<Integer> done before so as to use this method
        arrayToCreate = newList.stream().mapToInt(Integer::intValue).toArray(); //to convert List<Integer> back to int[]
        
        return arrayToCreate;
    }
    
    public int getArraySize(){
        return this.arraySize;
    }
    
    public void setArraySize(){
        //?? No need really - could just reset
    }
    
    public int[] getArray(){
        return intArray;
    }
    
    @Override
    public String toString(){
        String stringOfArray = " ";
        for(int i =0; i<this.getArraySize() ; i++){
            stringOfArray =  stringOfArray + String.valueOf(intArray[i]) + " ";
        }
        
        return stringOfArray;
    }
    
}
