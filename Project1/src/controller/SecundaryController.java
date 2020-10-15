/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import logica.Expresiones;
import logica.Model;
import view.SecundaryView;

/**
 *
 * @author Esteban
 */
public class SecundaryController {
    Model model;
    SecundaryView view;
    
    public SecundaryController() {}
    
    public SecundaryController(Model model, SecundaryView view) {
        this.model = model;
        this.view = view;
        view.setModel(model);
        view.setController(this);
    }
    
    public void setExpresion(Expresiones expresion) {
        this.model.setExpresion(service.Servicio.instance().returnExpresion(expresion));
    }
    
    public void secundaryView() {
        this.view.setVisible(true);
    }
}
