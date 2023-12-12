package unisa.ingsoft;

import java.util.EmptyStackException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;


public class CalculatorController {
    @FXML
    private GridPane numbersGridPane;
    @FXML
    private GridPane varGridPane;
    @FXML
    private Label outputview;
    @FXML
    private Label stackview;


    public void initialize() {
        varGridPane.setVisible(false); // Imposta il setVisible a false all'avvio
    }


    @FXML
    private void enterHandler(ActionEvent e){
        
    }


    @FXML
    private void switchToVariables(ActionEvent e){
 
    }
    @FXML
    private void switchToNumbers(ActionEvent e){
 
    }
    @FXML
    private void buttonHandler (ActionEvent e){

    }
    @FXML
    private void cancelHandler(ActionEvent e){  
 
    }
    @FXML
    private void deleteHandler(ActionEvent e){

    }


    @FXML
    private void swapHandler(ActionEvent e){
 
    }
    @FXML
    private void dupHandler(ActionEvent e){

    }
    @FXML
    private void overHandler(ActionEvent e){
    
    }
    @FXML
    private void dropHandler(ActionEvent e){
      
    }
    @FXML
    private void clearHandler(ActionEvent e){
 
    }
    

    private void showStackContent(){
     
}
}
