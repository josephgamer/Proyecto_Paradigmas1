/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
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
    
    public void cargarDatos() {
        try {
            model.setExpresiones(service.Servicio.instance().cargarDesdeArchivo());
            model.setTableExpresiones(service.Servicio.instance().cargarDesdeArchivo());
        } catch (IOException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }

    }
}
