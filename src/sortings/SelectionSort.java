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


    int[] arrayToSort;
    SortingsViewController controller; 
    
    SelectionSort(int[] inputArray, SortingsViewController controller){
        this.arrayToSort = inputArray;
        this.controller = controller; 
    }
    
    @Override
    public void Sort(){
    
        int size = arrayToSort.length;
        for(int index = 0 ; index<size ; index++){
            int remainingSmallestIndex = getSmallestIndex(arrayToSort,index,size-1);
            swap(arrayToSort,remainingSmallestIndex,index);
            try{
                Thread.sleep(500);
                controller.fillText(this.toString());
            }
            catch(InterruptedException ex){
            }
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
        /*
        Platform.runLater(()->{
            //add controller.
        })
        */
    }
    
    @Override
    public String toString(){
        String stringOfArray = " ";
        for(int i =0; i<arrayToSort.length ; i++){
            stringOfArray =  stringOfArray + String.valueOf(arrayToSort[i]) + " ";
        }
        
        return stringOfArray;
    }
    
    @Override
    public void run(){
        this.Sort();
    }
}
