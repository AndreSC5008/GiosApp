/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package net.codejava.entity;

/**
 *
 * @author ansan
 */
public class CalculadoraPrecio {
    private String sabor, tamano,decoracion; 

    public CalculadoraPrecio(String sabor, String tamano, String decoracion) {
        this.sabor = sabor;
        this.tamano = tamano;
        this.decoracion = decoracion;
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
    
    public double cotizarPrecio(){
        double pBase, pDecoracion;
        pBase= calcularPrecioBase();
        pDecoracion= calcularPrecioDecoracion();
        
        return pBase+pDecoracion; 
        
    }
}
