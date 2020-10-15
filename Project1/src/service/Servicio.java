/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package service;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import logica.Expresiones;

/**
 *
 * @author Esteban
 */
public class Servicio {
    private List<Expresiones> expresiones;
    
    public Servicio() {
        this.expresiones = new ArrayList<>();
    }
    
    public List<Expresiones> cargarDesdeArchivo() throws FileNotFoundException, IOException {
        FileReader file = new FileReader("C:/Users/Esteban/Desktop/General/paradigmas/Proyecto1/prueba.txt");
        BufferedReader buffered = new BufferedReader(file);
        String cadena = "";
        while ((cadena = buffered.readLine()) != null) {
            this.expresiones.add(new Expresiones(cadena));
            cadena = "";
        }
        buffered.close();
        
        return expresiones;
    }
    
    public void addExpression(Expresiones expresion) {
        this.expresiones.add(expresion);
    }
    
    public void updateExpression(int position, Expresiones expression) {
        this.expresiones.set(position, expression);
    }
    
    public void deleteEsxpression(int position) {
        this.expresiones.remove(position);
    }
    
    public Expresiones returnExpresion(Expresiones expresion) {
        for (Expresiones result : this.expresiones) {
            if (result.getExpresion().equals(expresion.getExpresion())) {
                return result;
            }
        }
        return null;
    }
    
    static Servicio the_instance;
    public static Servicio instance(){
        if(the_instance == null){
            the_instance=new Servicio();
        }
        return the_instance;
    }
}
