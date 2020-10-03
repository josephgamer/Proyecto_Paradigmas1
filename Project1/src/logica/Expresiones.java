/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

/**
 *
 * @author Esteban
 */
public class Expresiones {
    private String expresion;

    public Expresiones(String expresion) {
        this.expresion = expresion;
    }

    public Expresiones() {
    }

    public String getExpresion() {
        return expresion;
    }

    public void setExpresion(String expresion) {
        this.expresion = expresion;
    }

    @Override
    public String toString() {
        return "Expresiones{" + "expresion=" + expresion + '}';
    }
    
    
}
