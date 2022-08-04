/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pizzeria.logic;

import javafx.scene.AccessibleRole;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;

/**
 *
 * @author Mateo
 */
public class Usuario {

    private String name;
    private String apellidos;
    private TipoUsuario tipousuario;

    public Usuario() {
        this.name = "";
        this.apellidos = "";
        this.tipousuario=TipoUsuario.EMPLEADO;
    }

    public void init(String nombre, String apellidos,TipoUsuario tipo) {
        this.name = nombre;
        this.apellidos = apellidos;
        this.tipousuario=tipo;
    }

    
    public VBox toVBox() {
        VBox vbox = new VBox();
        Image rutaimagen = new Image("imagenlogin.jpg");
        Label nombre = new Label(this.toString());
        ImageView view = new ImageView(rutaimagen);
        view.setFitWidth(70);
        view.setFitHeight(70);
    
        vbox.getChildren().add(view);
        vbox.getChildren().add(nombre);
        vbox.setAccessibleText(this.toString());
        vbox.setAccessibleRoleDescription(this.tipousuario.toString());
        return vbox;
        
       
    }

    public String toString() {
        return (this.name + " " + this.apellidos);
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the surname
     */
    public String getApellidos() {
        return apellidos;
    }

    /**
     * @param surname the surname to set
     */
    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    /**
     * @return the tipousuario
     */
    public TipoUsuario getTipousuario() {
        return tipousuario;
    }

    /**
     * @param tipousuario the tipousuario to set
     */
    public void setTipousuario(TipoUsuario tipousuario) {
        this.tipousuario = tipousuario;
    }

}
