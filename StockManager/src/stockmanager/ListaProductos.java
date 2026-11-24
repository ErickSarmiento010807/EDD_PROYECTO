/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package stockmanager;

/**
 *
 * @author Erick
 */
public class ListaProductos {
    private NodoProducto inicio; // Puntero al primer nodo de la lista (Cabeza)
    private NodoProducto fin; // Puntero al último nodo de la lista (Cola)
    private int tamano; // Contador de elementos en el inventario
    
    /*
    ListaProductos
    
    PRE: Ninguna.
    POST: Inicializa una lista enlazada vacía con inicio y fin en null.
    */
    
    public ListaProductos() {
        this.inicio = null;
        this.fin = null;
        this.tamano = 0;
    }
    
    /*
    estaVacia
    
    PRE: Lista inicializada.
    POST: Devuelve true si no hay productos registrados, false en caso contrario.
    */
    
    public boolean estaVacia() {
        return inicio == null;
    }
    
    /*
    agregarProducto
    
    PRE: producto != null.
    POST: Inserta un nuevo producto al final de la lista enlazada (O(1)).
    */
    
    public void agregarProducto(Product producto) {
        NodoProducto nuevo = new NodoProducto(producto);
        
        if (estaVacia()) {
            inicio = nuevo;
            fin = nuevo;
        }else {
            fin.setSiguiente(nuevo); // El último nodo actual apunta al nuevo
            fin = nuevo; // El puntero fin se actualiza al nuevo nodo
        }
        tamano++;
        System.out.println("[OK] Producto registrado exitosamente en inventario.");
    }
    /*}
    mostrarInventario
    
    PRE: Lista inicializada.
    POST: Recorre e imprime en consola todos los productos del catálogo.
    */
    
    public void mostrarInventario() {
        if (estaVacia()) {
            System.out.println("[AVISO] El inventario se encuentra vacio.");
            return;
        }
        
        System.out.println("\\n========== CATALOGO DE INVENTARIO ==========");
        NodoProducto actual = inicio;
        int contador = 1;
        
        while (actual != null) {
            System.out.println(contador + ". " + actual.getDato().toString());
            actual = actual.getSiguiente(); // Avanza al siguiente nodo en la memoria Heap
            contador++;
        }
        System.out.println("============================================\\n");
    }
    
    /*
    buscarPorId
    
    PRE: id != null &amp;&amp; !id.isEmpty().
    POST: Devuelve el objeto Product si lo encuentra, o null si no existe.
    */
    
    public Product buscarPorId(String id) {
        NodoProducto actual = inicio;
        
        while (actual != null) {
            if (actual.getDato().getId().equalsIgnoreCase(id)) {
                return actual.getDato();
            }
            actual = actual.getSiguiente();
        }
        return null; // No se encontró el producto
    }
    
    /*
    modificarStock
    
    PRE: id != null, cantidad puede ser positiva (entrada) o negativa (venta).
    POST: Actualiza las existencias del producto correspondiente si existe.
    */
    
    public boolean modificarStock(String id, int cantidad) {
        Product p = buscarPorId(id);
        if (p != null) {
            int nuevoStock = p.getStock() + cantidad;
            if (nuevoStock < 0) {
                System.out.println("[ERROR] Stock insuficiente para realizar la venta.");
                return false;
            }
            p.setStock(nuevoStock);
            System.out.println("[OK] Stock actualizado. Nuevas existencias de '" + p.getName() + "': " + nuevoStock);
            return true;
        }
        System.out.println("[ERROR] Producto con ID '" + id + "' no encontrado.");
        return false;
    }
    
    // --- GETTERS DE ESTRUCTURA ---

    public int getTamano() {
        return tamano;
    }
    
}
