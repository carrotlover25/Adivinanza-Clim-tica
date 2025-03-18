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
        
        // Generamos temperaturas aleatorias entre -10 y 49
        for (int i = 0; i < 31; i++) {
            int a = random.nextInt(-10, 50);
            temperatura.add(a);       
        }
        
        // Insertamos las temperaturas en el árbol
        for (int t : temperatura) {
            arbol.insertarNodo(t);
        }
        
        // Seleccionamos una temperatura secreta aleatoria
        int i = random.nextInt(temperatura.size());
        int temp_secreta = temperatura.get(i);
        
        System.out.println("Se ha generado un árbol de temperaturas. Intenta adivinar la temperatura secreta.");
        arbol.imprimirArbol(arbol.raiz);
        
        // Bucle principal del juego
        while (tries < 4 && !adivinado) {
            tries++;
            System.out.println("\nIntento " + tries + "/4");
            System.out.print("Ingrese una temperatura: ");
            
            // Validación de entrada
            int guess;
            try {
                guess = scanner.nextInt();
            } catch (Exception e) {
                System.out.println("Por favor ingrese un número válido.");
                scanner.nextLine(); // Limpia el buffer
                tries--; // No cuenta como intento si la entrada es inválida
                continue;
            }
            
            // Procesa la adivinanza y muestra la ruta
            adivinado = arbol.ruta(guess, temp_secreta);
            
            // Proporciona pistas adicionales
            if (!adivinado) {
                if (guess < temp_secreta) {
                    System.out.println("La temperatura secreta es mayor.");
                } else if (guess > temp_secreta) {
                    System.out.println("La temperatura secreta es menor.");
                }
            }
        }
        
        // Fin del juego
        if (!adivinado) {
            System.out.println("\n¡Has agotado tus intentos!");
            System.out.println("La temperatura secreta era: " + temp_secreta + "°C");
        }
        
        scanner.close();
    }
}