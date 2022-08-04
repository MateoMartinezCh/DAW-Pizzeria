package com.mycompany.pizzeria;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
import com.mycompany.pizzeria.logic.Principal;
import com.mycompany.pizzeria.logic.TipoUsuario;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.layout.AnchorPane;

/**
 * FXML Controller class
 *
 * @author Mateo
 */
public class LoginuserController implements Initializable {

    @FXML
    private PasswordField campotexto;
    private StringProperty texto;
    @FXML
    private Button botonaceptar;
    @FXML
    private Button botoncancelar;
    @FXML
    private AnchorPane panel;

    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        texto = new SimpleStringProperty("");
        campotexto.textProperty().bindBidirectional(texto);
        /*panel.setOnKeyPressed(eh ->{
            if (eh.getCode()==KeyCode.ENTER) {
                
                this.aceptar(event);
            }
        });*/
    }

    @FXML
    private void pulso7(ActionEvent event) {
        if (texto.getValue().isEmpty()) {
            texto.set("7");
        } else {
            if (texto.getValue().length() < 8) {

                texto.set(texto.get() + "7");
            }
        }
    }

    @FXML
    private void pulso8(ActionEvent event) {
        if (texto.getValue().isEmpty()) {
            texto.set("8");
        } else {
            if (texto.getValue().length() < 8) {

                texto.set(texto.get() + "8");
            }
        }
    }

    @FXML
    private void pulso9(ActionEvent event) {
        if (texto.getValue().isEmpty()) {
            texto.set("9");
        } else {
            if (texto.getValue().length() < 8) {

                texto.set(texto.get() + "9");
            }
        }
    }

    @FXML
    private void pulso4(ActionEvent event) {
        if (texto.getValue().isEmpty()) {
            texto.set("4");
        } else {
            if (texto.getValue().length() < 8) {

                texto.set(texto.get() + "4");
            }
        }
    }

    @FXML
    private void pulso5(ActionEvent event) {
        if (texto.getValue().isEmpty()) {
            texto.set("5");
        } else {
            if (texto.getValue().length() < 8) {

                texto.set(texto.get() + "5");
            }
        }
    }

    @FXML
    private void pulso6(ActionEvent event) {
        if (texto.getValue().isEmpty()) {
            texto.set("6");
        } else {
            texto.set(texto.get() + "6");
        }
    }

    @FXML
    private void pulso1(ActionEvent event) {
        if (texto.getValue().isEmpty()) {
            texto.set("1");
        } else {
            if (texto.getValue().length() < 8) {

                texto.set(texto.get() + "1");
            }
        }
    }

    @FXML
    private void pulso2(ActionEvent event) {
        if (texto.getValue().isEmpty()) {
            texto.set("2");
        } else {
            if (texto.getValue().length() < 8) {

                texto.set(texto.get() + "2");
            }
        }
    }

    @FXML
    private void pulso3(ActionEvent event) {
        if (texto.getValue().isEmpty()) {
            texto.set("3");
        } else {
            if (texto.getValue().length() < 8) {

                texto.set(texto.get() + "3");
            }
        }
    }

    @FXML
    private void pulso0(ActionEvent event) {
        if (texto.getValue().isEmpty()) {
            texto.set("0");
        } else {
            if (texto.getValue().length() < 8) {

                texto.set(texto.get() + "0");
            }
        }
    }

    @FXML
    private void aceptar(ActionEvent event) throws IOException {
        if (!this.texto.getValue().isEmpty() && this.texto.getValue().length() == 8) {
            try {
                if (Principal.getInstance().getUsuariosActivos().get(Integer.parseInt(texto.getValue())) != null) {

                    Principal.getInstance().getUsuariosDesconectados().put(Integer.parseInt(texto.getValue()), Principal.getInstance().getUsuariosActivos().get(Integer.parseInt(texto.getValue())));
                    Principal.getInstance().getUsuariosActivos().remove(Integer.parseInt(texto.getValue()));
                } else if (Principal.getInstance().getUsuariosDesconectados().get(Integer.parseInt(texto.getValue()))!=null) {
                    Principal.getInstance().getUsuariosActivos().put(Integer.parseInt(texto.getValue()), Principal.getInstance().getUsuariosDesconectados().get(Integer.parseInt(texto.getValue())));
                    Principal.getInstance().getUsuariosDesconectados().remove(Integer.parseInt(texto.getValue()));
                }else{
                    throw new NullPointerException();
                }
                Principal.getInstance().getUsuarioseleccionado().setTipousuario(TipoUsuario.EMPLEADO);
                App.setRoot("primary");

            } catch (Exception e) {
                System.out.println("No existe este usuario con esa contraseña");
            }
        }
    }

    @FXML
    private void cancelar(ActionEvent event) throws IOException {
        App.setRoot("primary");
    }

}
