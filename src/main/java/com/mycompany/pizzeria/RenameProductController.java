package com.mycompany.pizzeria;

import com.mycompany.pizzeria.logic.Pedido;
import com.mycompany.pizzeria.logic.Principal;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class RenameProductController implements Initializable {

    private Pedido c;
    @FXML
    private TextField nombre;
    @FXML
    private Button enviar;
    @FXML
    private Button botoncancelar;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
    }

    @FXML
    private void actualizar(MouseEvent event) {
        if (c != null) {
            c.setName(nombre.getText());
        }else{
            this.c=new Pedido();
            this.c.setName(nombre.getText());
            Principal.getInstance().addPedido(c);
        }
    }

    public Pedido getC() {
        return c;
    }

    public void setC(Pedido c) {
        this.c = c;
        this.nombre.setText(this.c.getName());
    }

    @FXML
    private void cancelar(MouseEvent event) throws IOException {
        
        App.setRoot("primary");
    }

}
