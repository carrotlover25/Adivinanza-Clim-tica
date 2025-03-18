/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adivinanzaclimatica;

/**
 *
 * @author mfrey
 */
public class Nodo {
 
    int dato;
    Nodo izquierdo;
    Nodo derecho;

    public Nodo(int dato) {
        this.dato = dato;
        this.izquierdo = null;
        this.derecho = null;
    }
}
