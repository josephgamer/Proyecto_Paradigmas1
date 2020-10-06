/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.util.List;
import javax.swing.table.AbstractTableModel;
import logica.Expresiones;

/**
 *
 * @author Esteban
 */
public class TableModelArchivo extends AbstractTableModel {

    private List<Expresiones> expresiones;
    int[] cols;

    public TableModelArchivo(int[] cols, List<Expresiones> expresiones) {
        this.cols = cols;
        this.expresiones = expresiones;
        initCols();
    }

    public List<Expresiones> getExpresiones() {
        return this.expresiones;
    }

    public void setExpresiones(List<Expresiones> expresiones) {
        this.expresiones = expresiones;
    }

    @Override
    public int getRowCount() {
        return this.expresiones.size();
    }

    public Expresiones getRowAt(int row) {
        return expresiones.get(row);
    }

    @Override
    public int getColumnCount() {
        return this.cols.length;
    }

    @Override
    public String getColumnName(int columnIndex) {
        return colsName[columnIndex];
    }

    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        Expresiones expresion = expresiones.get(rowIndex);
        switch (cols[columnIndex]) {
            case EXPRESION:
                return expresion.getExpresion();
            default:
                return "";
        }
    }

    public static final int EXPRESION = 0;
    String[] colsName = new String[5];

    private void initCols() {
        colsName[EXPRESION] = "Expresion a evaluar";
    }

}
