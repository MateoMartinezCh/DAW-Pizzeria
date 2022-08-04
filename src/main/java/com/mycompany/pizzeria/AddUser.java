/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pizzeria;

import com.mycompany.pizzeria.App;
import com.mycompany.pizzeria.logic.Principal;
import com.mycompany.pizzeria.logic.TipoUsuario;
import com.mycompany.pizzeria.logic.Usuario;
import java.io.IOException;
import java.net.URL;
import java.util.LinkedList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.GridPane;
import javafx.stage.Popup;

/**
 * FXML Controller class
 *
 * @author Mateo
 */
public class AddUser implements Initializable {

    @FXML
    private Button iniciarsesion;
    @FXML
    private PasswordField contraseñafield;
    @FXML
    private TextField namefield;
    @FXML
    private TextField surnamefield;
    @FXML
    private GridPane contenedor;
    @FXML
    private ComboBox<TipoUsuario> usertypefield;
    private Label label = new Label();
    private Popup popup = new Popup();

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        ObservableList<TipoUsuario> tipo = FXCollections.observableArrayList(TipoUsuario.ADMINISTRADOR, TipoUsuario.EMPLEADO);
        this.usertypefield.setItems(tipo);
        label.setText("No puedes crear un usuario con un campo vacío");
        label.setMinWidth(100);
        label.setMinHeight(80);
        popup.getContent().add(label);
    }

    @FXML
    private void agregarusuario(ActionEvent event) throws IOException {
        Usuario nuevo = new Usuario();
        popup.hide();
        //label.setStyle("-fx-background-color: green;");
        if (!this.namefield.getText().isBlank() && !this.surnamefield.getText().isBlank() && !this.contraseñafield.getText().isBlank()) {

            try {
                nuevo.init(this.namefield.getText(), this.surnamefield.getText(), this.usertypefield.getValue());
                Principal.getInstance().getUsuariosDesconectados().put(Integer.parseInt(contraseñafield.getText()), nuevo.toVBox());
                App.setRoot("primary");
            } catch (NumberFormatException e) {
                if (this.contraseñafield.getText().isBlank()) {
                    label.setText("No puedes dejar la contraseña vacía");
                } else if (this.contraseñafield.getText().length() != 8) {
                    label.setText("Deben ser 8 números, ni más ni menos");
                } else {
                    label.setText("Has introducido carácteres inválidos, solo puedes introducir números en la contraseña");
                }
                if (!popup.isShowing()) {
                    popup.show(this.contenedor, 400, 400);
                } else {
                    popup.hide();
                }
            }
        } else {
            popup.show(this.contenedor, 400, 400);
        }

    }

    /* @FXML
    private void iniciarusuario(MouseEvent event) {
        Principal.getInstance().
        if (u != null) {
            u.setName(nombre1.getText());
            u.setSurname("Luis");
            u.setAge(19);
            u.setId(id);
            this.subirid();
        } else {
            this.u = new Usuario();
            this.u.setName(nombre1.getText());
            Principal.getInstance().addUser(u);
        }
    }
    private void subirid(){
        this.id = this.id +1;
    }*/
    /**
     * @return the u
     */
}
