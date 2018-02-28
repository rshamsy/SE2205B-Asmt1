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
public class MergeSort implements SortingsStrategy {
    
    MergeSort(){
        
    }
    @Override
    public void Sort(int[] inputArray){
        
        int size = inputArray.length;
        int last = size-1;
        int first = 0;
        
        SortAux(inputArray,first,last);
    }
    
    private void SortAux(int[] array, int first, int last){
        
        int mid = (first+last)/2;
        
        if(last-first>=1){    
            SortAux(array,first,mid);
            SortAux(array,mid+1,last);
            merge(array,first,mid,last);
        }
        
        
    }
    
    private void merge(int[] arrayFull, int first, int mid, int last){
        
        int begHalf1 = first;
        int begHalf2 = mid+1;
        int endHalf1 = mid;
        int endHalf2 = last;
        
        int [] tempArray =  new int[last+1];
        int index = 0;
        while((begHalf1<=endHalf1) & (begHalf2<=endHalf2)){
            if (arrayFull[begHalf1]<arrayFull[begHalf2]){
                tempArray[index] = arrayFull[begHalf1];
                begHalf1++;
            }
            else{
                tempArray[index]=arrayFull[begHalf2];
                begHalf2++;
            }
            index++;
        }
        
        if(begHalf1>endHalf1){
            for(int i=begHalf2 ; i<=endHalf2 ; i++){
                tempArray[index]=arrayFull[i];
                index++;
            }
        }
        
        if(begHalf2>endHalf2){
            for(int i=begHalf1 ; i<=endHalf1 ; i++){
                tempArray[index]=arrayFull[i];
                index++;
            }
        }
        int indArrayFull=first;
        int indTemp=0;
        while(indArrayFull<=last & indTemp<tempArray.length){
            
            arrayFull[indArrayFull]=tempArray[indTemp];
            indArrayFull++;
            indTemp++;
        }
    }
}
