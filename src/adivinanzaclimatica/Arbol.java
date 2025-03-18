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
                insertarRecursivo(nodo.izquierdo, nuevonodo, nivel++);
            }
        } else {
            if (nuevonodo.dato > nodo.dato){
                if (nodo.derecho == null){
                    nodo.derecho = nuevonodo;
                } else {
                    insertarRecursivo(nodo.derecho, nuevonodo, nivel++);
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
    
    public int altura (Nodo nodo){
          if (nodo == null){
              return 0;
          } return Math.max(altura(nodo.izquierdo), altura(nodo.derecho)) + 1;
      }
    
    public boolean ruta (int elemento, int secreto){
        Nodo current = raiz;
        int nivel = 1;
        System.out.print("Ruta: ");
        while (current != null){
            System.out.println(current.dato + " -> ");
            
            if (elemento == current.dato){
                System.out.println("Esta no es la temperatura correcta. Sigue Intentando");
                return false;
            } else if (elemento == secreto){
                System.out.println("¡Has acertado, felicitaciones!");
                return true;
            } else if (elemento < current.dato ){
                current = current.izquierdo;
            } else {
                current = current.derecho;
            }
            nivel++;
        }
        return false;
    }
}
