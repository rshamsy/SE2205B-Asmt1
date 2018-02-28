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
public class MergeTestMain {
    public static void main(String args[]){
        /*
        int[] exArray = new int[]{3,2,1,55,77,54};
        SortingsStrategy sortObjectSelection = new SelectionSort();
        
        sortObjectSelection.Sort(exArray);
        System.out.println("Following is the array after SelectionSort:\n");
        for(int i = 0; i<exArray.length ; i++){
          System.out.println(exArray[i]);
        }
        */
        
        SortingsModel arrayGenerator = new SortingsModel(20);
        
        System.out.print(arrayGenerator.toString());
    }
}
