/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.pizzeria.logic;

import java.util.Collection;
import java.util.List;


/**
 *
 * @author Pedro
 */
public class Producto {

    private int id;
 
    private String name;
 
  
    private double price;
  
    private String description;
    private Pedido pedido;

    public List<Producto> findProduct(Collection<Producto> collection) {
        return null;
    }

    public Producto() {
        this.name = "";
        this.id = -1;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }


    public String toString() {
        return "Id:" + this.id + " name:" + this.description + " price:" + this.price;
    }

    public Pedido getPedido() {
        return pedido;
    }

    public void setPedido(Pedido pedido) {
        this.pedido = pedido;
    }
}
