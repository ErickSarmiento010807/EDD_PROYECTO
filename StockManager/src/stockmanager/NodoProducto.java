package stockmanager;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Erick
 */
public class NodoProducto {
    private Product dato; // El objeto producto almacenado en el nodo
    private NodoProducto siguiente; // Puntero o referencia al siguiente nodo en la lista
    
    /*
    NodoProducto
    
    PRE: dato != null.
    POST: Crea un nodo que contiene el producto y establece la referencia siguiente en null.
    */
    
    public NodoProducto(Product dato) {
        this.dato = dato;
        this.siguiente = null;
    }
    
    /*
    NodoProducto
    
    PRE: dato != null.
    POST: Crea un nodo con el producto recibido y enlaza explícitamente al nodo siguiente.
    */
    
    public NodoProducto(Product dato, NodoProducto siguiente) {
        this.dato = dato;
        this.siguiente = siguiente;
    }
    
    // --- MÉTODOS GETTERS Y SETTERS ---

    public Product getDato() {
        return dato;
    }

    public void setDato(Product dato) {
        this.dato = dato;
    }

    public NodoProducto getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoProducto siguiente) {
        this.siguiente = siguiente;
    }
    
    
    
}
