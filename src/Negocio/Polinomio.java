/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Modelo.Monomio;


public class Polinomio {

    Monomio[] polinomio;
    int contador = 0;

    /**
     * Constructor vacío de la clase polinomio
     */
    public Polinomio() {
    }

    /**
     * Constructor que recibe un párametro para determinar su tamaño
     *
     * @param n: Entero que termina el tamaño que va a tener su polinomio
     */
    public Polinomio(int n) {
        polinomio = new Monomio[n];
    }

    /**
     * Función parar agregar cada uno de los monomios al polinomio siempre que
     * haya espacio dentro del arreglo
     *
     * @param m: Objeto monomio
     */
    public void addTermino(Monomio m) {
        if (this.contador < this.polinomio.length && !this.existeMonomio(m)) {
            this.polinomio[this.contador] = m;
            this.contador++;
        }
    }
    
    /**
     * Función para verificar que no exista el mismo monomio, de ser así, lo suma o lo resta
     * @param m: objeto monomio
     * @return boolean de si existe o no
     */
    public boolean existeMonomio(Monomio m) {
        boolean r = false;
        for(int i = 0; r==false && i<this.contador; i++) {
            if(this.polinomio[i].equals(m)) {
                this.polinomio[i].getRestarSumar(m);
                r = true;
            }
        }
        
        return r;
    }

    /**
     * Función parar agregar cada uno de los monomios a partir de valores al
     * polinomio siempre que haya espacio dentro del arreglo
     *
     * @param valor: flotante o base del monomio
     * @param literal: La letra que acompaña al polinomio
     * @param exponente: Grado al que va a estar su monomio
     */
    public void addTermino(float valor, String literal, int exponente) {
        if (contador < this.polinomio.length) {
            this.addTermino(new Monomio(valor, literal, exponente));
        }
    }

    /**
     * Recorre el polinomio y los espacios null los envía al final
     */
    public void cleanNullEspacios() {
        for (int i = 0; i < this.polinomio.length; i++) {
            if (this.polinomio[i] == null) {
                // si hay un espacio null, busco la siguiente posición hasta encontrar algo que asignar
                for (int j = i + 1; j < this.polinomio.length; j++) {
                    if (this.polinomio[j] != null) {
                        this.polinomio[i] = this.polinomio[j];
                        this.polinomio[j] = null;
                        break;
                    }
                }
            }
        }
    }

    /**
     * Ordenamos el polinomio descendentemente basado en el método burbuja
     */
    public void ordernarPolinomio() {
        // Antes de ordenar, verificamos que no hayan espacios vacíos
        this.cleanNullEspacios();
        for (Monomio m : this.polinomio) {
            for (int j = 0; m != null && j < this.polinomio.length; j++) {
                if (this.polinomio[j] != null && this.polinomio[j + 1] != null
                        && this.polinomio[j + 1].getExponente() > this.polinomio[j].getExponente()) {
                    Monomio mTemp = this.polinomio[j + 1];
                    this.polinomio[j + 1] = this.polinomio[j];
                    this.polinomio[j] = mTemp;
                }
            }
        }
    }

    public Monomio[] getPolinomio() {
        return this.polinomio;
    }

    @Override
    public String toString() {
        String rta = "";
        for (Monomio p : this.polinomio) {
            if (p != null && p.getValor() != 0) {
                rta += p.toString();
            }
        }
        return rta;
    }
}
