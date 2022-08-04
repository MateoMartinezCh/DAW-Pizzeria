/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pizzeria.logic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.collections.ObservableMap;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 *
 * @author Pedro
 */
public class Principal {

    // private HashMap<Integer, Pedido> categorias;
    private ObservableList<Pedido> pedidos;
    private ObservableMap<Integer, VBox> usuariosactivos;
    private HashMap<Integer, VBox> usuariosdesconectados;
    private Usuario usuarioseleccionado;

    private static Principal instance;

    static {
        instance = null;

    }

    private Principal() {
        this.pedidos = FXCollections.observableArrayList();
        this.usuariosactivos = FXCollections.observableHashMap();
        this.usuariosdesconectados = new HashMap<>();
        this.usuarioseleccionado = new Usuario();
        Usuario usuariotemporal = new Usuario();
        usuariotemporal.init("Administrador", "Contraseña 12341234", TipoUsuario.ADMINISTRADOR);
        this.usuariosactivos.put(12341234,usuariotemporal.toVBox());
        // this.categorias = new HashMap<>();
    }

    public static Principal getInstance() {
        if (instance == null) {
            instance = new Principal();
            instance.init();
        }
        return instance;

    }

    private void init() {

        Pedido c;
        Producto p;
        c = new Pedido();
        c.setId(1);
        c.setName("Pedido de Roberto");
        this.addPedido(c);
        p = new Producto();

        p.setDescription("Pizza Parmesano Mediana");
        p.setPrice(9.5d);
        c.addProduct(p);

        c = new Pedido();
        c.setId(2);
        c.setName("Pedido de Juan Carlos");

        this.addPedido(c);

        c = new Pedido();
        c.setId(3);
        c.setName("Pedido de Noelia");
        p.setDescription("Pizza 4 quesos");
        p.setPrice(7.5d);
        c.addProduct(p);

        this.addPedido(c);
        c = new Pedido();
        c.setId(4);
        c.setName("Pedido de Canela");
        p.setDescription("Pizza 20 quesos");
        p.setPrice(70.5d);
        c.addProduct(p);

        this.addPedido(c);

    }

    public ObservableList<Pedido> getPedidos() {
        return this.pedidos;
    }

    public void addPedido(Pedido p) {
        if (p.getId() == -1) {
            p.setId(this.getNextId());
        }
        this.pedidos.add(p);
    }

    public Pedido removePedido(Pedido c) {
        return this.pedidos.remove(c.getId());
    }

    public boolean removePedido(Integer id) {
        return this.pedidos.removeIf(e -> e.getId() == id);
    }

    public Pedido getPedido(Integer id) {
        return this.pedidos.get(id);
    }

    private Integer getNextId() {
        Optional<Pedido> o = this.pedidos.stream().max(
                (a, b) -> {
                    return a.getId() - b.getId();
                }
        );
        if (o.isPresent()) {
            return o.get().getId() + 1;
        } else {
            return 1;
        }

    }

    /**
     * @return the usuarios
     */
    public ObservableMap<Integer, VBox> getUsuariosActivos() {
        return usuariosactivos;
    }

    /**
     * @param usuarios the usuarios to set
     */
    public void setUsuariosActivos(ObservableMap<Integer, VBox> usuarios) {
        this.usuariosactivos = usuarios;
    }

    public Usuario getUsuarioseleccionado() {
        return usuarioseleccionado;
    }

    /**
     * @return the usuariosdesconectados
     */
    public HashMap<Integer, VBox> getUsuariosDesconectados() {
        return usuariosdesconectados;
    }

    /**
     * @param usuariosdesconectados the usuariosdesconectados to set
     */
    public void setUsuariosDesconectados(HashMap<Integer, VBox> usuariosdesconectados) {
        this.usuariosdesconectados = usuariosdesconectados;
    }

}
