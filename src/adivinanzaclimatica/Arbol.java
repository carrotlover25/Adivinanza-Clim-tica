/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adivinanzaclimatica;

import java.util.ArrayList;

/**
 *
 * @author mfrey
 */
public class Arbol {
    Nodo raiz;
    
    public void insertarNodo(int valor){ // porque puede ser una raiz
        Nodo nuevonodo = new Nodo(valor);
        if (this.raiz == null){
            this.raiz = nuevonodo;
        } else {
          insertarRecursivo(this.raiz, nuevonodo, 1);  
        }
    }
    
    
    public void insertarRecursivo(Nodo nodo, Nodo nuevonodo, int nivel){
        if (nivel >= 5){
            return;
        }
        if (nuevonodo.dato < nodo.dato){
            if (nodo.izquierdo == null){
                nodo.izquierdo = nuevonodo;
            } else {
                insertarRecursivo(nodo.izquierdo, nuevonodo, nivel + 1);
            }
        } else {
            if (nuevonodo.dato > nodo.dato){
                if (nodo.derecho == null){
                    nodo.derecho = nuevonodo;
                } else {
                    insertarRecursivo(nodo.derecho, nuevonodo, nivel + 1);
                }
            }
        } 
    }

    public void insertarBalanceado(ArrayList<Integer> lista, int inicio, int fin, int nivel) {
        if (inicio > fin || nivel > 5) { 
            return; 
        }
        
        int medio = (inicio + fin) / 2; 
        insertarNodo(lista.get(medio)); 
    
        insertarBalanceado(lista, inicio, medio - 1, nivel + 1); 
        insertarBalanceado(lista, medio + 1, fin, nivel + 1); 
    }
    

    
    private void imprimirArbol(Nodo raiz, String estructuraDibujar, boolean esIzquierdo) {
        if (raiz == null) {
            return;
        }

        String nuevaEstructura = estructuraDibujar;
        String simbolo;

        if (esIzquierdo) {
            simbolo = "├── ";
            nuevaEstructura += "│   ";
        } else {
            simbolo = "└── ";
            nuevaEstructura += "    ";
        }

        System.out.println(estructuraDibujar + simbolo + raiz.dato);

        imprimirArbol(raiz.izquierdo, nuevaEstructura, true);
        imprimirArbol(raiz.derecho, nuevaEstructura, false);
    }
    
    public void imprimirArbol(Nodo raiz) {
        imprimirArbol(raiz, "", false);
    }
    
    public boolean ruta(int elemento, int secreto) {
        Nodo current = raiz;
        System.out.print("Ruta: ");
    
        while (current != null) {
            System.out.print(current.dato + " -> ");
    
            if (current.dato == secreto) {
                System.out.println("\n¡Has acertado, felicitaciones!");
                return true;
            }
    
            if (elemento == current.dato) {
                System.out.println("\nEsta no es la temperatura correcta. Sigue Intentando");
                return false;
            }
    
            // Moverse a la izquierda o derecha
            current = (elemento < current.dato) ? current.izquierdo : current.derecho;
        }
    
        System.out.println("\nEl número ingresado no se encuentra en el árbol.");
        return false;
    }
}    