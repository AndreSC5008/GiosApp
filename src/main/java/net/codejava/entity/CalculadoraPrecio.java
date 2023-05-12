/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.codejava.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

/**
 *
 * @author ansan
 */

@Entity
public class CalculadoraPrecio {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String sabor, tamano,decoracion, precio; 

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSabor() {
        return sabor;
    }

    public void setSabor(String sabor) {
        this.sabor = sabor;
    }

    public String getTamano() {
        return tamano;
    }

    public void setTamano(String tamano) {
        this.tamano = tamano;
    }

    public String getDecoracion() {
        return decoracion;
    }

    public void setDecoracion(String decoracion) {
        this.decoracion = decoracion;
    }

    public String getPrecio() {
        return precio;
    }

    public void setPrecio(String precio) {
        this.precio = precio;
    }

    public CalculadoraPrecio(String sabor, String tamano, String decoracion) {
        this.sabor = sabor;
        this.tamano = tamano;
        this.decoracion = decoracion;
    }
    
    public CalculadoraPrecio(String sabor, String tamano, String decoracion,String precio) {
        this.sabor = sabor;
        this.tamano = tamano;
        this.decoracion = decoracion;
        this.precio=precio;
    }
    
     public CalculadoraPrecio() {
        
    }
    private double calcularPrecioBase() {
        double precioBase = 0;
        switch (sabor) {
            case "vainilla":
                switch (tamano) {
                    case "chico":
                        precioBase = 100;
                        break;
                    case "mediano":
                        precioBase = 200;
                        break;
                    case "grande":
                        precioBase = 300;
                        break;
                    default:
                        break;
                }   break;
            case "chocolate":
            switch (tamano) {
                case "chico":
                    precioBase = 120;
                    break;
                case "mediano":
                    precioBase = 220;
                    break;
                case "grande":
                    precioBase = 320;
                    break;
                default:
                    break;
            }
break;

            case "fresa":
            switch (tamano) {
                case "chico":
                    precioBase = 130;
                    break;
                case "mediano":
                    precioBase = 230;
                    break;
                case "grande":
                    precioBase = 330;
                    break;
                default:
                    break;
            }
break;

            default:
                break;
        }
        return precioBase;
    }
    
    private double calcularPrecioDecoracion() {
        double precioDecoracion = 0;
        if (decoracion.equals("sencillo")) {
            precioDecoracion = 50;
        } else if (decoracion.equals("elegante")) {
            precioDecoracion = 100;
        } else if (decoracion.equals("extravagante")) {
            precioDecoracion = 150;
        }
        return precioDecoracion;
    }
    
    public String cotizarPrecio(){
        double pBase, pDecoracion;
        pBase= calcularPrecioBase();
        pDecoracion= calcularPrecioDecoracion();
        precio= String.valueOf(pBase+pDecoracion);
        return precio; 
        
    }
}
