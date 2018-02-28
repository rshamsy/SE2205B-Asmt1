/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sortings;

import java.net.URL;
import java.util.ResourceBundle;
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
        this.textArea.setText(arrayGenerator.toString());
    }
    
    public void SetSortStrategy(){
        
    }


    @Override
    public void initialize(URL url, ResourceBundle rb) { //used to set initial state of View upon opening
        
        comboBox.getItems().addAll("SelectionSort","MergeSort");
        
        textArea.setText("");
        arraySizeSlider.setValue(50);
        sliderValue.setText(String.valueOf((int)arraySizeSlider.getValue()));
    
    }    
    
}
