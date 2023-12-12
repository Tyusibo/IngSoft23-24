module unisa.ingsoft {
    requires javafx.controls;
    requires javafx.fxml;

    opens unisa.ingsoft to javafx.fxml;
    exports unisa.ingsoft;
}
