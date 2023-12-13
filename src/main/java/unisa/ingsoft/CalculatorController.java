package unisa.ingsoft;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import unisa.ingsoft.ComplexNumber.ComplexNumber;
import unisa.ingsoft.Exceptions.LessThanOneElementException;
import unisa.ingsoft.Exceptions.LessThanTwoElementsException;
import unisa.ingsoft.Exceptions.SyntaxException;
import unisa.ingsoft.Exceptions.VariableNotInitializedException;

public class CalculatorController {
    @FXML
    private GridPane numbersGridPane;
    @FXML
    private GridPane varGridPane;
    @FXML
    private Label outputview;
    @FXML
    private Label stackview;

    private Calculator calculator;

    public void initialize() {
        varGridPane.setVisible(false); // Imposta il setVisible a false all'avvio
        calculator = new Calculator();
    }


    @FXML
    private void enterHandler(ActionEvent e) throws VariableNotInitializedException, LessThanOneElementException{
        String input = outputview.getText();

        // enter rocco
        if (!input.isEmpty()) {
            if(input.equals("+")){
                try{

                    ComplexNumber somma = calculator.sumCalculator();
                    outputview.setText(somma.toString());

                }catch(LessThanTwoElementsException ex){
                    String errMessage = ex.getMessage();
                    outputview.setText(errMessage);
                }
            }else if (input.equals("-")){
                try{

                    ComplexNumber diff = calculator.subCalculator();
                    outputview.setText(diff.toString());
                    showStackContent();

                }catch(LessThanTwoElementsException ex){
                    String errMessage = ex.getMessage();
                    outputview.setText(errMessage);
                }
            }else if (input.equals("*")){
                try{

                    ComplexNumber mol = calculator.molCalculator();
                    outputview.setText(mol.toString());
                    showStackContent();

                }catch(LessThanTwoElementsException ex){
                    String errMessage = ex.getMessage();
                    outputview.setText(errMessage);
                }
            }else if (input.equals("/")){
                try{

                    ComplexNumber div = calculator.divCalculator();
                    outputview.setText(div.toString());
                    showStackContent();

                }catch(LessThanTwoElementsException ex){
                    String errMessage = ex.getMessage();
                    outputview.setText(errMessage);
                }
            }else if (input.equals("sqrt")){
                try{

                    ComplexNumber sqrt = calculator.sqrtCalculator();
                    outputview.setText(sqrt.toString());
                    showStackContent();

                }catch(LessThanOneElementException ex){
                    String errMessage = ex.getMessage();
                    outputview.setText(errMessage);
                }
            }else if (input.equals("conj")){
                try{

                    ComplexNumber conj = calculator.conjCalculator();
                    outputview.setText(conj.toString());
                    showStackContent();

                }catch(LessThanOneElementException ex){
                    String errMessage = ex.getMessage();
                    outputview.setText(errMessage);
                }
            }else if (input.equals("+/-")){
                try{

                    ComplexNumber inv = calculator.invCalculator();
                    outputview.setText(inv.toString());
                    showStackContent();

                }catch(LessThanOneElementException ex){
                    String errMessage = ex.getMessage();
                    outputview.setText(errMessage);
                }
            }else if (input.charAt(0) == '>' && Character.isLowerCase(input.charAt(1))) {
                    try{
                        ComplexNumber num = calculator.saveOnVariable(input.charAt(1));
                        showStackContent();
                        outputview.setText(input.charAt(1)+"="+num.toString());
                    }catch(LessThanOneElementException wx){
                        outputview.setText(wx.getMessage());
                    }catch(VariableNotInitializedException w){
                        outputview.setText(w.getMessage());
                    }
            }else if (input.charAt(0) == '<' && Character.isLowerCase(input.charAt(1))){
                    try{
                        ComplexNumber num = calculator.saveOnStack(input.charAt(1));
                        showStackContent();
                        outputview.setText(input.charAt(1)+"=" + num);
                    }catch(VariableNotInitializedException wx){
                        String err = wx.getMessage();
                        outputview.setText(err);
                    }
            }else if (input.charAt(0) == '+' && Character.isLowerCase(input.charAt(1))){
                    try{
                        ComplexNumber num = calculator.increaseVariable(input.charAt(1));
                        showStackContent();
                        outputview.setText(input.charAt(1)+"="+num.toString());
                    }catch(VariableNotInitializedException ex){
                        String err = ex.getMessage();
                        outputview.setText(err);
                    }catch(LessThanOneElementException wx){
                        outputview.setText(wx.getMessage());
                    }
            }else if (input.charAt(0) == '-' && Character.isLowerCase(input.charAt(1))){
                    try{
                        ComplexNumber num = calculator.decreaseVariable(input.charAt(1));
                        showStackContent();
                        outputview.setText(input.charAt(1)+"="+num.toString());
                    }catch(VariableNotInitializedException ex){
                        String err = ex.getMessage();
                        outputview.setText(err);
                    }catch(LessThanOneElementException wx){
                        outputview.setText(wx.getMessage());
                    }
            }else{
                try{
                    calculator.insert(input);
                    showStackContent();
                    outputview.setText("");
                }catch(SyntaxException ex){
                    String err = ex.getMessage();
                    outputview.setText(err);
                }
            }

            showStackContent();
        }

        
    }


    @FXML
    private void switchToVariables(ActionEvent e){
        numbersGridPane.setVisible(false);
        varGridPane.setVisible(true);
    }
    @FXML
    private void switchToNumbers(ActionEvent e){
        numbersGridPane.setVisible(true);
        varGridPane.setVisible(false);
    }
    @FXML
    private void buttonHandler (ActionEvent e){
        String buttontxt = ((Button) e.getSource()).getText();

        if(outputview.getText().equals("")){
            outputview.setText(buttontxt);
        }else{
            outputview.setText(outputview.getText() + buttontxt);
        }
    }
    @FXML
    private void cancelHandler(ActionEvent e){  
        if(!outputview.getText().equals("")){
            outputview.setText("");
        }
    }
    @FXML
    private void deleteHandler(ActionEvent e){
        String currentText = outputview.getText();

        if (!currentText.equals("")) {
            // Rimuovi l'ultimo carattere dal testo attuale
            String newText = currentText.substring(0, currentText.length() - 1);
            // Aggiorna il testo della Label con il nuovo testo
            outputview.setText(newText);
        }

    }


    @FXML
    private void swapHandler(ActionEvent e){
        try{
            calculator.swap();
            showStackContent();
        }catch(LessThanTwoElementsException ex){
            String errMessage = ex.getMessage();
            outputview.setText(errMessage);
        }
    }
    @FXML
    private void dupHandler(ActionEvent e){
        try{
            calculator.dup();
            showStackContent();
        }catch(LessThanOneElementException ex){
            String errMessage = ex.getMessage();
            outputview.setText(errMessage);
        }
    }
    @FXML
    private void overHandler(ActionEvent e){
        try{
            calculator.over();
            showStackContent();
        }catch(LessThanTwoElementsException ex){
            String errMessage = ex.getMessage();
            outputview.setText(errMessage);
        }
    }
    @FXML
    private void dropHandler(ActionEvent e){
        calculator.drop();
        showStackContent();
    }
    @FXML
    private void clearHandler(ActionEvent e){
        calculator.clear();
        showStackContent();
    }
    

    private void showStackContent(){
        StringBuffer content = new StringBuffer();
        ComplexNumber[] numbsOnStack = calculator.stackToArray();
        int length = numbsOnStack .length;

        if (length<=12){
            for(int i = length-1; i>= 0; i--){
                content.append(numbsOnStack[i]).append("\n");
            }
        }else{
            for(int i = length - 1; i >= length - 12; i--){
                content.append(numbsOnStack[i]).append("\n");
            }
        }
        stackview.setText(content.toString());
    }
}
