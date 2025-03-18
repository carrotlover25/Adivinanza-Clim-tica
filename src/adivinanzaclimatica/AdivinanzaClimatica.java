/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package adivinanzaclimatica;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author mfrey
 */
public class AdivinanzaClimatica {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Random random = new Random();
        Arbol arbol = new Arbol();
        int tries = 0;
        System.out.println("¡Adivinanza Climatica!");
        System.out.println("¡Adivine la temperatura promedio global en 4 intentos!");
        for (int i = 0; i < 12; i++) {
            int a = random.nextInt(-10, 50);
            arbol.insertarNodo(a);
        }
        arbol.imprimirArbol(arbol.raiz);
        // arbol.imprimir(arbol.raiz, 0);
    }
    
}
