/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package adivinanzaclimatica;

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
          insertarRecursivo(this.raiz, nuevonodo);  
        }
    }
    
    public void insertarRecursivo(Nodo nodo, Nodo nuevonodo){
        if (nuevonodo.dato < nodo.dato){
            if (nodo.izquierdo == null){
                nodo.izquierdo = nuevonodo;
            } else {
                insertarRecursivo(nodo.izquierdo, nuevonodo);
            }
        } else {
            if (nuevonodo.dato > nodo.dato){
                if (nodo.derecho == null){
                    nodo.derecho = nuevonodo;
                } else {
                    insertarRecursivo(nodo.derecho, nuevonodo);
                }
            }
        }
    }
    
    public boolean encontrado (int elemento, Nodo nodo){
          if (nodo == null){
              return false;
          }
          if (nodo.dato == elemento){
              return true;
          } else if (elemento < nodo.dato) {
                  return encontrado(elemento, nodo.izquierdo);
              } else if (elemento > nodo.dato){
                  return encontrado(elemento, nodo.derecho);
              } return true;
          }
    
    public void imprimir ( Nodo n1 ,int nivel ){
        if ( n1 != null ){
            imprimir ( n1.izquierdo, nivel+1 );
            for (int i = 0; i < nivel; i++){
                System.out.print ("      ");
            }
            System.out.println(n1.dato );
            imprimir (n1.derecho, nivel+1 );
           
        }
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
}
