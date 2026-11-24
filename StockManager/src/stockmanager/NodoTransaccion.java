/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stockmanager;

/**
 *
 * @author Erick
 */
public class NodoTransaccion {
    private String idProducto; // ID del producto afectado
    private int cantidad; // Cantidad modificada (+ entrada, - venta)
    private String tipo; // Tipo de operacion: "VENTA" o "ENTRADA"
    private NodoTransaccion siguiente; // Puntero al nodo inferior en la pila
    
    /*
    NodoTransaccion
    
    PRE: idProducto != null, tipo != null.
    POST: Inicializa un nodo de transaccion con su referencia siguiente en null.
    */
    
    public NodoTransaccion(String idProducto, int cantidad, String tipo) {
        this.idProducto = idProducto;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.siguiente = null;
    }
    
    // --- MÉTODOS GETTERS Y SETTERS ---

    public String getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(String idProducto) {
        this.idProducto = idProducto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public NodoTransaccion getSiguiente() {
        return siguiente;
    }

    public void setSiguiente(NodoTransaccion siguiente) {
        this.siguiente = siguiente;
    }
    
    
}
