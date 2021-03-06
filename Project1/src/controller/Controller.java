/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import logica.Expresiones;
import logica.Model;
import view.View;

/**
 *
 * @author Esteban
 */
public class Controller {
    ModelTable model;
    View view;
    
    public Controller(ModelTable model, View view) {
        this.model = model;
        this.view = view;
        view.setModelTable(model);
        view.setController(this);
    }
    
    public void cargarDatos(String archivo) {
        try {
            List<Expresiones> result = service.Servicio.instance().cargarDesdeArchivo(archivo);
            model.setExpresiones(result);
            model.setTableExpresiones(result);
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
    
    public void guardarArchivo(File archivo) {
        try {
            service.Servicio.instance().guardarArchivo(archivo);
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void addExpresion(Expresiones expresion) {
        service.Servicio.instance().addExpression(expresion);
    }
    
    public void refrescarPantalla() {
        List<Expresiones> pantalla = service.Servicio.instance().getExpresiones();
        model.setExpresiones(pantalla);
        model.setTableExpresiones(pantalla);
    }
    
    public void showPrincipal() {
        this.view.setVisible(true);
    }
    
    public void row(int row) {
        project1.Project1.SECUNDARY_CONTROLLER.setExpresion(model.getExpresiones().get(row));
    }
    
    public int returnNumExpresion() {
        return this.view.returnNumExpresion();
    }
}
