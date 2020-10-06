/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Observable;
import java.util.Observer;
import javax.swing.table.TableModel;
import logica.Expresiones;

/**
 *
 * @author Esteban
 */
public class ModelTable extends Observable{
    List<Expresiones> expresiones;
    int[] cols = {TableModelArchivo.EXPRESION};
    TableModelArchivo table;
    Expresiones filter;
    
    public ModelTable(){
        this.expresiones = new ArrayList<>();
        this.table = new TableModelArchivo(cols, new ArrayList<>());
    }
    
    public List<Expresiones> getExpresiones() {
        return this.expresiones;
    }
    
    public Expresiones getFilter() {
        return this.filter;
    }
    
    public TableModel getTableExpresion() {
        return this.table;
    }
    
    public Expresiones getRowAt(int row) {
        return this.table.getRowAt(row);
    }
    
    public void setFilter(Expresiones filter) {
        this.filter = filter;
    }
    
    public void setTableExpresiones(ArrayList<Expresiones> expresiones) {
        this.table = new TableModelArchivo(cols, expresiones);
        setChanged();
        notifyObservers();
    }
    
    public void setExpresiones(List<Expresiones> expresiones) {
        this.expresiones = expresiones;
        this.setChanged();
        this.notifyObservers();
    } 
    
    public void addOserver(Observer o){
        super.addObserver(o);
        this.setChanged();
        this.notifyObservers();
    }
}
