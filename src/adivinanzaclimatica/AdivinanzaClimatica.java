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
        int sw = 0;
        ArrayList<Integer> temperatura = new ArrayList<>();
        System.out.println("¡Adivinanza Climatica!");
        System.out.println("¡Adivine la temperatura promedio global en 4 intentos!");
        
        for (int i = 0; i < 31; i++) {
            int a = random.nextInt(-10, 50);
             temperatura.add(a);       
        }
        
        for (int t : temperatura) {
            arbol.insertarNodo(t);
        }
        
        int i = random.nextInt(temperatura.size());
        int temp_secreta = temperatura.get(i);
        
        arbol.imprimirArbol(arbol.raiz);
        // arbol.imprimir(arbol.raiz, 0);
    }
    
}
