package com.mycompany.pizzeria;

import com.mycompany.pizzeria.logic.Pedido;
import com.mycompany.pizzeria.logic.Principal;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.stream.Collectors;
import javafx.beans.value.ObservableListValue;
import javafx.beans.value.ObservableValueBase;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.control.Button;
import javafx.scene.control.TableCell;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.util.Callback;

public class TablaProductoController implements Initializable, ListChangeListener<Pedido> {

    @FXML
    private TableColumn<Pedido, Integer> c_id;
    @FXML
    private TableColumn<Pedido, String> c_nombre;
    @FXML
    private TableColumn<Pedido, Void> c_editar;
    @FXML
    private TableColumn<Pedido, Void> c_borrar;
    @FXML
    private TableView<Pedido> tabla_categorias;
    @FXML
    private AnchorPane contenedor;
    private Principal p;
    private ObservableList<Pedido> pedidos;
    @FXML
    private Button botonnuevopedido;

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        this.p = Principal.getInstance();

        this.configTable();
        this.initTable();
    }

    private void initTable() {
        ArrayList categorias = new ArrayList(p.getPedidos());
        this.pedidos = FXCollections.observableArrayList(categorias);
        this.tabla_categorias.setItems(p.getPedidos());
        this.pedidos.addListener(this);

    }

    private void configTable() {

        //para que pinte el valor de tipo cadena
        this.c_nombre.setCellValueFactory(c -> {
            return new ObservableValueBase<String>() {
                @Override
                public String getValue() {
                    return c.getValue().getName();
                }
            };
        });

        this.c_id.setCellValueFactory(c -> {
            return new ObservableValueBase<Integer>() {
                @Override
                public Integer getValue() {
                    return c.getValue().getId();
                }

            };
        });
       
        //devuelve una celda personalizada
        this.c_editar.setCellFactory(categorytablecell -> {
            return new TableCell<Pedido, Void>() {
                private final Button btn = new Button("Editar");
                //similar al constructor por defecto

                {
                    btn.setOnAction((ActionEvent event) -> {

                        contenedor.getChildren().clear();
                        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("ActualizarProducto.fxml"));
                        try {
                            Parent t = fxmlLoader.load();
                            RenameProductController sc = fxmlLoader.getController();
                            sc.setC(getTableRow().getItem());
                            contenedor.getChildren().add(t);

                        } catch (IOException ex) {
                            ex.printStackTrace();
                        }
                    });
                }

                /*
                    Se encarga de pintar el botón
                 */
                @Override
                public void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(btn);
                    }
                }
            };

        });

        this.c_borrar.setCellFactory((m) -> {
            //clase anónima creada para esto
            return new TableCell<Pedido, Void>() {
                private final Button btn = new Button("Borrar");

                {
                    btn.setOnAction((ActionEvent event) -> {
                        Pedido data = getTableView().getItems().get(getIndex());
                        p.removePedido(data.getId());
                        tabla_categorias.setItems(FXCollections.observableArrayList(p.getPedidos()));
                        tabla_categorias.refresh();
                    });
                }

                @Override
                public void updateItem(Void item, boolean empty) {
                    super.updateItem(item, empty);
                    if (empty) {
                        setGraphic(null);
                    } else {
                        setGraphic(btn);
                    }
                }

            };
        });

    }

    private void listado(MouseEvent event) {
        this.contenedor.getChildren().clear();
        this.tabla_categorias.refresh();
        this.contenedor.getChildren().add(this.tabla_categorias);
    }

    @Override
    public void onChanged(Change<? extends Pedido> change) {
        this.tabla_categorias.refresh();
    }

    private void nuevo(MouseEvent event) throws IOException {
        contenedor.getChildren().clear();
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource("secondary.fxml"));

        Parent t = fxmlLoader.load();
        RenameProductController sc = fxmlLoader.getController();

        contenedor.getChildren().add(t);
    }

    @FXML
    private void cambiaranuevopedido(MouseEvent event) throws IOException {
        this.contenedor.getChildren().clear();
        Parent p = App.loadFXML("NuevoProducto");
        this.contenedor.getChildren().add(p);
    }

}
