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
        boolean adivinado = false;
        Scanner scanner = new Scanner(System.in);
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
        
        System.out.println("Se ha generado un árbol de temperaturas. Intenta adivinar la temperatura secreta.");
        arbol.imprimirArbol(arbol.raiz);
        
        while (tries < 4 && !adivinado) {
            tries++;
            int guess;
            System.out.println("\nIntento " + tries + "/4");
            System.out.print("Ingrese una temperatura: ");
            guess = scanner.nextInt();

            if (guess < -10 && guess > 50) {
                System.out.println("Por favor ingrese un número entre -10 y 50.");
                 tries--;
                continue;
            }
            
            adivinado = arbol.ruta(guess, temp_secreta);
    
            if (!adivinado) {
                if (guess < temp_secreta) {
                    System.out.println("La temperatura secreta es mayor.");
                } else if (guess > temp_secreta) {
                    System.out.println("La temperatura secreta es menor.");
                }
            }
        }
        
        if (!adivinado) {
            System.out.println("\n¡Has agotado tus intentos!");
            System.out.println("La temperatura secreta era: " + temp_secreta + "°C");
        }
        
        scanner.close();
    }
}