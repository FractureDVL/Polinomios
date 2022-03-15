/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Modelo.Monomio;

public class SistemaPolinomio {

    // polinimios = [[4x^2, 4x^2, 4x^2], [4x^2, 4x^2, 4x^2], [...]]
    Polinomio[] polinomios;

    int contador = 0;
    int totalMonomios = 0;

    /**
     * Constructor vacío de la clase SistemaPolinomio
     */
    public SistemaPolinomio() {
    }

    public SistemaPolinomio(int n) {
        this.polinomios = new Polinomio[n];
    }

    /**
     * Agrega un polinomio al arrelo de polinomios
     *
     * @param polinomio Objeto que a us vez es un arregle de monomios
     */
    public void addPolinomio(Polinomio polinomio) {
        if (this.contador < this.polinomios.length) {
            this.polinomios[this.contador] = polinomio;
            this.contador++;
            this.totalMonomios += polinomio.getPolinomio().length;
        }
    }

    /**
     * Constructor que recibe vectores de objetos de polinomios
     *
     * @param polinomios: Arreglo de términos
     */
    public SistemaPolinomio(Polinomio[] polinomios) {
        this.polinomios = polinomios;
    }

    /**
     * Función para unir los polinomios y así realizar la suma o resta
     * facilmente
     *
     * @param isResta: booleano para determinar si es resta o suma
     * @return Arreglo de objetos de monomios o un polinomio
     */
    private Polinomio unirPolinomios(boolean isResta) {
        // Creo un polinomio nuevo con el len de monomios
        Polinomio polinomio = new Polinomio(this.totalMonomios);
        for (int i = 0; i < this.polinomios.length; i++) {
            // Itero sobre cada uno de los monomios del polinomio
            for (Monomio m : this.polinomios[i].getPolinomio()) {
                if(m!=null) {
                    float valor = m.getValor();
                    if (i != 0 && isResta) {
                        // solo si es resta, a partir del segundo polinomio lo convierto a negativo
                        valor = valor * -1;
                    }
                    // agrego cada uno de los nuevos monomios al polinomio
                    polinomio.addTermino(new Monomio(valor, m.getLiteral(), m.getExponente()));
                }
            }
        }
        return polinomio;
    }

    /**
     * Función que llama a sumar o restar y retorna el valor de dicha operación
     * en String
     *
     * @param tipo: Boolean para determinar que tipo de operación se desea, si
     * suma o resta
     * @return String con el polinomio formado a partir de la operación
     */
    private String operacionPolinomios(boolean tipo) {
        Polinomio polinomio = this.unirPolinomios(tipo);
        // Para mostrarlo, ordenamos el polinomio descendentemente
        polinomio.ordernarPolinomio();
        return polinomio.toString();
    }

    @Override
    public String toString() {
        String pString = "";
        for (Polinomio p : this.polinomios) {
            pString += p.toString() + "\n";
        }
        return "Polinomios: \n" + pString;
    }

    /**
     * Devuelve la suma algebraica de todos los polinomios almacenados
     *
     * @return String con el polinomio formado a partir de la operación
     */
    public String getSumar() {
        return this.operacionPolinomios(false);
    }

    /**
     * Devuelve la resta algebraica de todos los polinomios almacenados
     *
     * @return String con el polinomio formado a partir de la operación
     */
    public String getRestar() {
        return this.operacionPolinomios(true);
    }

}
