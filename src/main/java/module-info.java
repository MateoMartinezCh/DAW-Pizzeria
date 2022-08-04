/* doesn't work with source level 1.8:
module com.mycompany.pizzeria {
    requires javafx.controls;
    requires javafx.fxml;

    opens com.mycompany.pizzeria to javafx.fxml;
    exports com.mycompany.pizzeria;
}
*/
