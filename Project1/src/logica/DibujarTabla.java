/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package logica;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 *
 * @author Esteban
 */
public class DibujarTabla {

    private Boolean[][] variablesPositivas;
    private Boolean[][] variablesNegativas;
    private List<String> variablesPositive;
    private List<String> variablesNegative;

    public DibujarTabla() {
        this.variablesNegative = new ArrayList<>();
        this.variablesPositive = new ArrayList<>();
    }

    public String devuelveVariablesPositivas() {
        String matriz = "";
        this.variablesPositivas
                = new Boolean[(int) Math.pow(2, this.variablesPositive.size())][this.variablesPositive.size()];
        int j = 0;
        int contador = 0;
        int dividendo = 2;
        int mitadMatriz = this.variablesPositivas.length / 2;
        while (j < this.variablesPositivas[j].length) {
            for (int i = 0; i < this.variablesPositivas.length; i++) {
                if (mitadMatriz > 0) {
                    if (contador % 2 == 0) {
                        this.variablesPositivas[i][j] = true;
                        mitadMatriz--;

                    }
                    if (contador % 2 == 1) {
                        this.variablesPositivas[i][j] = false;
                        mitadMatriz--;
                    }
                }
                if (mitadMatriz == 0) {
                    mitadMatriz = this.variablesPositivas.length / dividendo;
                    contador++;
                }

            }
            dividendo = dividendo * 2;
            mitadMatriz = this.variablesPositivas.length / dividendo;
            contador = 0;
            j++;
        }

        for (int x = 0; x < this.variablesPositivas.length; x++) {
            for (int y = 0; y < this.variablesPositivas[x].length; y++) {
                //System.out.print(matriz[x][y]);
                matriz = matriz + this.variablesPositivas[x][y];
                if (y != this.variablesPositivas[x].length - 1) {
                    matriz = matriz + "\t";
                }
            }
            matriz = matriz + "\n";
        }
        return matriz;
    }

    public String devuelveVariablesNegativas() {
        String matriz = "";
        this.variablesNegativas
                = new Boolean[(int) Math.pow(2, this.variablesNegative.size())][this.variablesNegative.size()];
        int j = 0;
        int contador = 0;
        int dividendo = 2;
        int mitadMatriz = this.variablesNegativas.length / 2;
        while (j < this.variablesNegativas[j].length) {
            for (int i = 0; i < this.variablesNegativas.length; i++) {
                if (mitadMatriz > 0) {
                    if (contador % 2 == 0) {
                        this.variablesNegativas[i][j] = false;
                        mitadMatriz--;

                    }
                    if (contador % 2 == 1) {
                        this.variablesNegativas[i][j] = true;
                        mitadMatriz--;
                    }
                }
                if (mitadMatriz == 0) {
                    mitadMatriz = this.variablesNegativas.length / dividendo;
                    contador++;
                }

            }
            dividendo = dividendo * 2;
            mitadMatriz = this.variablesNegativas.length / dividendo;
            contador = 0;
            j++;
        }

        for (int x = 0; x < this.variablesNegativas.length; x++) {
            for (int y = 0; y < this.variablesNegativas[x].length; y++) {
                matriz = matriz + this.variablesNegativas[x][y];
                if (y != this.variablesNegativas[x].length - 1) {
                    matriz = matriz + "\t";
                }
            }
            matriz = matriz + "\n";
        }
        return matriz;
    }

    public boolean parentesisBalanceado(String expresion) {
        int apertura = 0;
        int cierre = 0;
        if (expresion.indexOf("(") != -1) {
            for (int i = 0; i < expresion.length(); i++) {
                if (expresion.charAt(i) == '(') {
                    apertura++;
                }
                if (expresion.charAt(i) == ')') {
                    cierre++;
                }
            }
        }
        return apertura == cierre;
    }
    
    public void addVariablesPositive(String expresion) {
        String onlyVariables = expresion.replaceAll("[()˄˅↔→⌐]", "");
        
        if (!onlyVariables.isEmpty()) {
            for (int i = 0; i< onlyVariables.length(); i++) {
                String aux = Character.toString(onlyVariables.charAt(i));
                if (!this.variablesPositive.contains(aux)) {
                    this.variablesPositive.add(aux);
                    aux = "";
                }
                aux = "";
            }
        }
    }
    
    public void addVariablesNegative(String expresion) {
        String onlyVariables = expresion.replaceAll("[()˄˅↔→⌐]", "");
        String negativo = "";
        if (!onlyVariables.isEmpty()) {
            for (int i = 0; i < onlyVariables.length(); i++) {
                String aux = Character.toString(onlyVariables.charAt(i));
                negativo = negativo + "⌐" + aux;
                if (!this.variablesNegative.contains(negativo)) {
                    this.variablesNegative.add(negativo);
                    aux = "";
                    negativo = "";
                }
                aux = "";
                negativo = "";
            }
        }
    }
    
    public String returnVariablesPositive() {
        String result = "";
        for (String aux : this.variablesPositive) {
            if (result.isEmpty()) {
                result = result + aux;
            } else {
                result = result + "\t" + aux;
            }
        }
        return result;
    }
    
    public String returnVaraiblesNegative() {
        String result = "";
        for (String aux : this.variablesNegative) {
            if (result.isEmpty()) {
                result = result + aux;
            } else {
                result = result + "\t" + aux;
            }
        }
        return result;
    }

    public Boolean[][] getVariablesPositivas() {
        return variablesPositivas;
    }

    public void setVariablesPositivas(Boolean[][] variablesPositivas) {
        this.variablesPositivas = variablesPositivas;
    }

    public Boolean[][] getVariablesNegativas() {
        return variablesNegativas;
    }

    public void setVariablesNegativas(Boolean[][] variablesNegativas) {
        this.variablesNegativas = variablesNegativas;
    }

    public List<String> getVariablesPositive() {
        return variablesPositive;
    }

    public void setVariablesPositive(List<String> variablesPositive) {
        this.variablesPositive = variablesPositive;
    }

    public List<String> getVariablesNegative() {
        return variablesNegative;
    }

    public void setVariablesNegative(List<String> variablesNegative) {
        this.variablesNegative = variablesNegative;
    }

}
