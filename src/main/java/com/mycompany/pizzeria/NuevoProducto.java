/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/javafx/FXMLController.java to edit this template
 */
package com.mycompany.pizzeria;

import com.mycompany.pizzeria.App;
import com.mycompany.pizzeria.logic.Pedido;
import com.mycompany.pizzeria.logic.Pedido;
import com.mycompany.pizzeria.logic.Principal;
import com.mycompany.pizzeria.logic.Principal;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

/**
 * FXML Controller class
 *
 * @author DAM
 */
public class NuevoProducto implements Initializable {

    private Pedido c;
    @FXML
    private TextField nombre;
    @FXML
    private Button enviar;
    @FXML
    private Button botoncancelar;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }

    @FXML
    private void cancelar(MouseEvent event) throws IOException {
        App.setRoot("primary");

    }

    @FXML
    private void añadirnuevo(MouseEvent event) {
        if (c != null) {
            c.setName(nombre.getText());
        } else {
            this.c = new Pedido();
            this.c.setName(nombre.getText());
            Principal.getInstance().getPedidos().add(c);
        }
    }

}
