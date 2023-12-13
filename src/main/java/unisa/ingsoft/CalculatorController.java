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

        try {
            if (!input.isEmpty()) {
                if(input.equals("+")){
                    ComplexNumber somma = calculator.sumCalculator();
                    outputview.setText(somma.toString());
                }else if (input.equals("-")){
                    ComplexNumber diff = calculator.subCalculator();
                    outputview.setText(diff.toString());
                }else if (input.equals("*")){
                    ComplexNumber mol = calculator.molCalculator();
                    outputview.setText(mol.toString());
                }else if (input.equals("/")){
                    ComplexNumber div = calculator.divCalculator();
                    outputview.setText(div.toString());
                }else if (input.equals("sqrt")){
                    ComplexNumber sqrt = calculator.sqrtCalculator();
                    outputview.setText(sqrt.toString());
                }else if (input.equals("conj")){
                    ComplexNumber conj = calculator.conjCalculator();
                    outputview.setText(conj.toString());
                }else if (input.equals("+/-")){
                    ComplexNumber inv = calculator.invCalculator();
                    outputview.setText(inv.toString());
                }else if (input.charAt(0) == '>' && Character.isLowerCase(input.charAt(1))) {
                    ComplexNumber num = calculator.saveOnVariable(input.charAt(1));
                    outputview.setText(input.charAt(1)+"="+num.toString());
                }else if (input.charAt(0) == '<' && Character.isLowerCase(input.charAt(1))){
                    ComplexNumber num = calculator.saveOnStack(input.charAt(1));
                    outputview.setText(input.charAt(1)+"=" + num);
                }else if (input.charAt(0) == '+' && Character.isLowerCase(input.charAt(1))){
                    ComplexNumber num = calculator.increaseVariable(input.charAt(1));
                    outputview.setText(input.charAt(1)+"="+num.toString());
                }else if (input.charAt(0) == '-' && Character.isLowerCase(input.charAt(1))){
                    ComplexNumber num = calculator.decreaseVariable(input.charAt(1));
                    outputview.setText(input.charAt(1)+"="+num.toString());
                }else{
                    calculator.insert(input);
                    outputview.setText("");
                }
                showStackContent();
            }
        }catch(LessThanTwoElementsException ex){
            outputview.setText(ex.getMessage());
        }catch(LessThanOneElementException ex){
            outputview.setText(ex.getMessage());
        }catch(VariableNotInitializedException ex){
            outputview.setText(ex.getMessage());
        }catch(SyntaxException ex){
            outputview.setText(ex.getMessage());
        }catch(ArithmeticException ex){
            outputview.setText("Divisione per 0");
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
            outputview.setText(ex.getMessage());
        }
    }
    @FXML
    private void dupHandler(ActionEvent e){
        try{
            calculator.dup();
            showStackContent();
        }catch(LessThanOneElementException ex){
            outputview.setText(ex.getMessage());
        }
    }
    @FXML
    private void overHandler(ActionEvent e){
        try{
            calculator.over();
            showStackContent();
        }catch(LessThanTwoElementsException ex){
            outputview.setText(ex.getMessage());
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
