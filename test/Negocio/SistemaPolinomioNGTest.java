/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Negocio;

import Modelo.Monomio;
import static org.testng.Assert.*;
import org.testng.annotations.Test;

/**
 * Test de Sistema de monomios, usa tres polinomios y hace su respectivo de llamado de las funciones sumar y restar
 * @author Jose Florez
 */
public class SistemaPolinomioNGTest {
    private Polinomio polinomio;
    private Polinomio polinomio1;
    private Polinomio polinomio2;
    SistemaPolinomio sistema;
    
    public SistemaPolinomioNGTest() {
    }

    public void escenario() {
        Monomio t = new Monomio(2, "X", 2);
        Monomio t1 = new Monomio(3, "X", 1);
        
        polinomio = new Polinomio(2);
        polinomio.addTermino(t);
        polinomio.addTermino(t1);
        // p = 2x^2 + 3x
        
        Monomio t2 = new Monomio(4, "X", 3);
        Monomio t3 = new Monomio(6, "X", 2);
        Monomio t4 = new Monomio(5, "X", 1);
        polinomio1 = new Polinomio(3);
        polinomio1.addTermino(t2);
        polinomio1.addTermino(t3);
        polinomio1.addTermino(t4);
        
        polinomio2 = new Polinomio(4);
        polinomio2.addTermino(t2);
        polinomio2.addTermino(t3);
        polinomio2.addTermino(t1);
        polinomio2.addTermino(t4);
        
        sistema = new SistemaPolinomio(3);
        sistema.addPolinomio(polinomio);
        sistema.addPolinomio(polinomio1);
        sistema.addPolinomio(polinomio2);
        
        System.out.println("sistema.toString(): " + sistema.toString());
        
    }

    /**
     * Test of getSumar method, of class SistemaPolinomio.
     */
    @Test
    public void testGetSumar() {
        System.out.println("getSumar");
        // 1. Crear el escenario
        this.escenario();
        // 2. Valor esperado;
        String valorEsperado = "+8.0X^3+14.0X^2+21.0X^1";
        // 3. Resultado
        String resultado = sistema.getSumar();
        //4. Ejecutar la prueba:
        System.out.println("Resultado Suma: " + resultado);
        assertEquals(resultado, valorEsperado);
    }

    /**
     * Test of getRestar method, of class SistemaPolinomio.
     */
    @Test
    public void testGetRestar() {
        System.out.println("getRestar");
        // 1. Crear el escenario
        this.escenario();
        // 2. Valor esperado;
        String valorEsperado = "-8.0X^3-10.0X^2-5.0X^1";
        // 3. Resultado
        String resultado = sistema.getRestar();
        //4. Ejecutar la prueba:
        System.out.println("Resultado Resta: " + resultado);
        assertEquals(resultado, valorEsperado);
    }
    
}
