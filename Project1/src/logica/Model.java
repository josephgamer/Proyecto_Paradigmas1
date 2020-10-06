/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.Observable;
import java.util.Observer;

/**
 *
 * @author Esteban
 */
public class Model extends Observable{
    Expresiones expresion;
    
    public Model() {
        this.expresion = new Expresiones();
    }

    public Expresiones getExpresion() {
        return expresion;
    }

    public void setExpresion(Expresiones expresion) {
        this.expresion = expresion;
        this.setChanged();
        this.notifyObservers();
    }
    
    public void addOserver(Observer o){
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers();
    }
    
}
