/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Vista;

import Modelo.Monomio;
import Negocio.Polinomio;
import Negocio.SistemaPolinomio;

public class PruebaPolinomio {
    public static void main(String[] args) {
        Monomio t1 = new Monomio(4, "X", 9);
        Monomio t2 = new Monomio(2, "X", 7);
        Monomio t3 = new Monomio(-5, "X", 3);
        Monomio t4 = new Monomio(7, "X", 1);
        
        Polinomio p1 = new Polinomio(4);
        p1.addTermino(t1);
        p1.addTermino(t2);
        p1.addTermino(t3);
        p1.addTermino(t4);
        // p = 4X^9 + 2X^7 – 5X^3 + 7X^1     
        
        Monomio t5 = new Monomio(-2, "X", 7);
        Monomio t6 = new Monomio(3, "X", 6);
        Monomio t7 = new Monomio(-4, "X", 1);
        Polinomio p2 = new Polinomio(3);
        p2.addTermino(t5);
        p2.addTermino(t6);
        p2.addTermino(t7);
        // p = 2x^7 + 3x^6 - 4x^1
        
        SistemaPolinomio sistema = new SistemaPolinomio(2);
        
        sistema.addPolinomio(p1);
        sistema.addPolinomio(p2);
        
        System.out.println(sistema.toString());
        
        System.out.println("Suma: " + sistema.getSumar());
        System.out.println("Resta: " + sistema.getRestar());
    }
}
