module unisa.ingsoft {
    requires transitive javafx.graphics;
    requires javafx.controls;
    requires javafx.fxml;
    
    

    opens unisa.ingsoft to javafx.fxml;
    exports unisa.ingsoft.ComplexNumber;
    exports unisa.ingsoft;
    

}
