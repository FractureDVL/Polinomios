/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

public class Monomio {

    float valor;
    String literal;
    int exponente;

    /**
     * Constructor vacío de la clase Termino algebraico
     */
    public Monomio() {
    }

    /**
     * Constructor que recibe los valores necesarios para construir un término.
     *
     * @param valor: Float con la base del término.
     * @param literal: String con la variable identificadora
     * @param exponente: Entero indicativo de la potencia del término.
     */
    public Monomio(float valor, String literal, int exponente) {
        this.valor = valor;
        this.literal = literal;
        this.exponente = exponente;
    }

    /**
     * Suma y resta de polinomios o de dos monomios.
     *
     * @param obj o monomio
     */
    public void getRestarSumar(Monomio obj) {
        if (this.equals(obj)) {
            this.valor = this.valor + obj.getValor();
        }
    }

    @Override
    public String toString() {
        return this.valor == 0 ? "" : (this.valor > 0 ? "+" : "") + this.valor + "" + this.literal + "^" + this.exponente;
    }

    public boolean equals(Monomio obj) {
        return this.exponente == obj.exponente && this.literal == obj.literal;
    }

    public float getValor() {
        return valor;
    }

    public void setValor(float valor) {
        this.valor = valor;
    }

    public String getLiteral() {
        return literal;
    }

    public void setLiteral(String literal) {
        this.literal = literal;
    }

    public int getExponente() {
        return exponente;
    }

    public void setExponente(int exponente) {
        this.exponente = exponente;
    }
}
