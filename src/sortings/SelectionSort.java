/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortings;

/**
 *
 * @author MHK
 */
public class SelectionSort implements SortingsStrategy{


    //int[] arrayToSort = null;
    
    SelectionSort(){
      //nothing needed in constructor
    }
    
    @Override
    public void Sort(int[] inputArray){
    
        int size = inputArray.length;
        for(int index = 0 ; index<size ; index++){
            int remainingSmallestIndex = getSmallestIndex(inputArray,index,size-1);
            swap(inputArray,remainingSmallestIndex,index);
        }
        
    }
    
    private int getSmallestIndex(int[] array,int first,int last){
        int min = array[first];
        int minIndex = first;
        for(int i = first+1 ; i<=last ; i++){
            if(array[i]<min){
                min = array[i];
                minIndex = i;
            }
        }
        return minIndex;
    }
    
    private void swap(int[] inputArray, int indexOfMin, int toReplaceIndex){
        int temp = inputArray[toReplaceIndex];
        inputArray[toReplaceIndex] = inputArray[indexOfMin];
        inputArray[indexOfMin] = temp;
    }
}
