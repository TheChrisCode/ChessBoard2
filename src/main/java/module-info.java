module com.example.chessboard2 {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.example.chessboard2 to javafx.fxml;
    exports com.example.chessboard2;
}