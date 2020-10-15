/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project1;

import java.io.IOException;
import java.util.List;
import logica.DibujarTabla;
import logica.Expresiones;
import service.Servicio;

/**
 *
 * @author Esteban
 */
public class Project1 {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) throws IOException {
        /*Servicio servicio = new Servicio();
        List<Expresiones> list = servicio.cargarDesdeArchivo();
        for (Expresiones expresion : list) {
            System.out.println(expresion.getExpresion());
        }*/
        controller.ModelTable model = new controller.ModelTable();
        view.View view = new view.View();
        controller.Controller controller = new controller.Controller(model, view);
        view.setVisible(true);
        LISTADO_EXPRESIONES = controller;
        
        logica.Model secundary = new logica.Model();
        view.SecundaryView sv = new view.SecundaryView();
        controller.SecundaryController cs = new controller.SecundaryController(secundary, sv);
        //sv.setVisible(true);
        SECUNDARY_CONTROLLER = cs;
        
    }

    public static controller.Controller LISTADO_EXPRESIONES;
    public static controller.SecundaryController SECUNDARY_CONTROLLER;
}
