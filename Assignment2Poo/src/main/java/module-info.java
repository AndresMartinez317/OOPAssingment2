module org.example.assignment2poo {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.assignment2poo to javafx.fxml;
    exports org.example.assignment2poo;
}