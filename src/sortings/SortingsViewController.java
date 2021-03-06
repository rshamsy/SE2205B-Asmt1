/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortings;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.Slider;
import javafx.scene.control.TextArea;

/**
 *
 * @author MHK
 */
public class SortingsViewController implements Initializable {
    
    @FXML
    private Label label;
    
    @FXML
    private ComboBox comboBox;
    
    @FXML
    private Label comboBoxLabel;
        
    @FXML
    private Slider arraySizeSlider;
    
    @FXML
    private Label sliderValue;
    
    @FXML
    private TextArea textArea;
    
    @FXML
    private Button resetButton;
    
    @FXML
    private Button sortButton;
    
    private SortingsModel arrayGenerator;
    
    public void comboBoxUpdated(){
        this.comboBoxLabel.setText(comboBox.getValue().toString());
    }
    
    public void sliderDragged() {
        this.sliderValue.setText(String.valueOf((int)arraySizeSlider.getValue()));
        arraySizeSlider.setValue((int)arraySizeSlider.getValue());
        //this.textArea.setText("Label Value: " + sliderValue + " Slider Value: " + arraySizeSlider.getValue());
        
        // create array using SortingsModel:
        arrayGenerator = new SortingsModel((int)arraySizeSlider.getValue());
        this.textArea.setText(arrayGenerator.toString());
        
        //create Model class and create array. 
    }
    
    public void resetBtn_Click(){
        arrayGenerator.reset((int)arraySizeSlider.getValue());
        fillText(arrayGenerator.toString());
        //this.textArea.setText(arrayGenerator.toString());
    }
    
    public void fillText(String arrayFill){
        this.textArea.setText(arrayFill);
    }
    
    private SortingsStrategy sortingsMethod;
    //Thread sortThread;
    public Thread SetSortStrategy(){
        
        
        //String selection = comboBox.getSelectionModel().getSelectedItem().toString();
        String selection = comboBox.getValue().toString();
        
        if(selection.equals("SelectionSort")){
            sortingsMethod = new SelectionSort(arrayGenerator.getArray(),this);
            
        }
        else{
            sortingsMethod = new MergeSort(arrayGenerator.getArray(),this);
        }
        Thread sortThread = new Thread(sortingsMethod);
        //create new thread here -- send new to run on the entire thread -- send sortingsMethod and this.
        return sortThread;
        
    }
    
    public void sortBtn_Click(){
        SetSortStrategy().start();
        fillText(arrayGenerator.toString());
    }
    


    @Override
    public void initialize(URL url, ResourceBundle rb) { //used to set initial state of View upon opening
        
        comboBox.getItems().addAll("SelectionSort","MergeSort");
        comboBox.setValue("SelectionSort");
        arrayGenerator = new SortingsModel((int)arraySizeSlider.getValue());
        textArea.setText(arrayGenerator.toString());
        arraySizeSlider.setValue(50);
        sliderValue.setText(String.valueOf((int)arraySizeSlider.getValue()));
        
        
    }    
    
}
