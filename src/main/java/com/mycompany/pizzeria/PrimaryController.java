package com.mycompany.pizzeria;

import com.mycompany.pizzeria.logic.Principal;
import com.mycompany.pizzeria.logic.TipoUsuario;
import com.mycompany.pizzeria.logic.Usuario;
import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.beans.value.ObservableValueBase;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;

public class PrimaryController implements Initializable {

    private Image whiteTileImg = new Image("imagenlogin.jpg");

    @FXML
    private Pane contenedor;
    private Principal p;
    @FXML
    private ImageView imagen_botonlogin;
    @FXML
    private ImageView imagen_botonpedidos;
    @FXML
    private ListView<VBox> listviewiconos;
    @FXML
    private Label labelnombreusuario;
    @FXML
    private Label labelrolusuario;
    @FXML
    private ImageView imagen_botonlogear;
    @FXML
    private Label labeldia;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.p = Principal.getInstance();
        this.listviewiconos.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue ov, Object t, Object t1) {

                Principal.getInstance().getUsuarioseleccionado().setName(getListviewiconos().getSelectionModel().getSelectedItem().getAccessibleText());
                labelnombreusuario.setText(Principal.getInstance().getUsuarioseleccionado().getName());
                if (getListviewiconos().getSelectionModel().getSelectedItem().getAccessibleRoleDescription().equals(TipoUsuario.ADMINISTRADOR.toString())) {
                    Principal.getInstance().getUsuarioseleccionado().setTipousuario(TipoUsuario.ADMINISTRADOR);
                } else {
                    Principal.getInstance().getUsuarioseleccionado().setTipousuario(TipoUsuario.EMPLEADO);
                }
                labelrolusuario.setText(Principal.getInstance().getUsuarioseleccionado().getTipousuario().toString());
                listviewiconos.refresh();
            }
        });
        this.labeldia.setText(LocalDate.now().toString());
        this.listviewiconos.getItems().addAll(Principal.getInstance().getUsuariosActivos().values());

    }

    /*private static PrimaryController instance;

    static {
        instance = null;

    }

    private PrimaryController() {
        this.p = Principal.getInstance();
        this.listviewiconos.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener() {
            @Override
            public void changed(ObservableValue ov, Object t, Object t1) {
                usuarioseleccionado = getListviewiconos().getSelectionModel().getSelectedItem();
                labelnombreusuario.setText(usuarioseleccionado.getName());
            }
        });

    }

    public static PrimaryController getInstance() {
        if (instance == null) {
            instance = new PrimaryController();
        }
        return instance;

    }
     */
    @FXML
    private void cambiar1(MouseEvent event) throws IOException {
        if (Principal.getInstance().getUsuarioseleccionado().getTipousuario() == TipoUsuario.ADMINISTRADOR) {

            this.contenedor.getChildren().clear();
            Parent p = App.loadFXML("adduser");
            this.contenedor.getChildren().add(p);
        }
    }

    @FXML
    private void cambiar2(MouseEvent event) throws IOException {
        this.contenedor.getChildren().clear();
        Parent p = App.loadFXML("secondary");
        this.contenedor.getChildren().add(p);
    }

    @FXML
    private void cambiar3(MouseEvent event) throws IOException {
        this.contenedor.getChildren().clear();
        Parent p = App.loadFXML("loginuser");
        this.contenedor.getChildren().add(p);
    }

    /**
     * @return the listviewiconos
     */
    public ListView<VBox> getListviewiconos() {
        return listviewiconos;
    }

    /**
     * @param listviewiconos the listviewiconos to set
     */
    public void setListviewiconos(ListView<VBox> listviewiconos) {
        this.listviewiconos = listviewiconos;
    }

}
