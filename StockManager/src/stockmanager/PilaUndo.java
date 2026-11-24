/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stockmanager;

/**
 *
 * @author Erick
 */
public class PilaUndo {
    private NodoTransaccion tope; // Puntero al nodo en la cima de la pila
    private int tamano; // Cantidad de acciones registradas en la pila
    
    /*
    PilaUndo
    
    PRE: Ninguna.
    POST: Inicializa una pila vacia con tope en null.
    */
    
    public PilaUndo() {
        this.tope = null;
        this.tamano = 0;
    }
    
    /*
    estaVacia
    
    PRE: Pila inicializada.
    POST: Devuelve true si no hay transacciones para deshacer, false en caso contrario.
    */
    
    public boolean estaVacia() {
        return tope == null;
    }
    
    /*
    push
    
    PRE: idProducto != null, tipo != null.
    POST: Inserta una nueva transaccion en el tope de la pila (O(1)).
    */
    
    public void push(String idProducto, int cantidad, String tipo) {
        NodoTransaccion nuevo = new NodoTransaccion(idProducto, cantidad, tipo);
        nuevo.setSiguiente(tope); // El nuevo nodo apunta al tope anterior
        tope = nuevo; // El tope se actualiza al nuevo nodo
        tamano++;
    }
    
    /*
    pop
    
    PRE: !estaVacia().
    POST: Remueve y devuelve la ultima transaccion realizada en el tope (O(1)).
    */
    
    public NodoTransaccion pop() {
        if (estaVacia()) {
            return null;
        }
        NodoTransaccion desapilado = tope;
        tope = tope.getSiguiente(); // El tope baja al siguiente nodo
        tamano--;
        return desapilado;
    }
    
    /*
    deshacerUltimaAccion
    
    PRE: inventario != null.
    POST: Desapila la ultima transaccion y revierte el cambio de stock en el inventario.
    */
    
    public boolean deshacerUltimaAccion(ListaProductos inventario) {
        if (estaVacia()) {
            System.out.println("[AVISO] No hay acciones recientes para deshacer.");
            return false;
        }
        
        // Desapilamos la ultima transaccion (LIFO)
        NodoTransaccion ultima = pop();
        
        // Para revertir: si fue entrada (+N), restamos (-N); si fue venta (-N), sumamos (+N)
        int cantidadInversa = -ultima.getCantidad();
        
        System.out.println("[UNDO] Deshaciendo operacion '" + ultima.getTipo() + "' del producto ID: " + ultima.getIdProducto());
        return inventario.modificarStock(ultima.getIdProducto(), cantidadInversa);
    }
    
    // --- GETTERS DE ESTRUCTURA ---

    public int getTamano() {
        return tamano;
    }
    
    
}
