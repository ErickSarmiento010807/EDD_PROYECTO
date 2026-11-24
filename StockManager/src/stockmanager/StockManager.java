/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package stockmanager;

import java.util.Scanner;

/**
 *
 * @author Erick
 */
public class StockManager {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ListaProductos inventario = new ListaProductos();
        PilaUndo pilaUndo = new PilaUndo();
        
        // Precargamos datos de prueba para agilizar las demostraciones cargarDatosPrueba(inventario);
        
        int opcion = 0;
        
        do {
            System.out.println("\\n============================================");
            System.out.println(" SISTEMA DE INVENTARIO STOCKMANAGER ");
            System.out.println("============================================");
            System.out.println("1. Registrar nuevo producto en catalogo");
            System.out.println("2. Consultar inventario completo");
            System.out.println("3. Buscar producto por ID");
            System.out.println("4. Registrar entrada de mercancia (Lote)");
            System.out.println("5. Registrar venta de producto");
            System.out.println("6. Deshacer ultima accion (Undo)");
            System.out.println("7. Salir del sistema");
            System.out.println("============================================");
            System.out.print("Seleccione una opcion (1-7): ");
            
            try {
                opcion = Integer.parseInt(scanner.nextLine().trim());
            }catch (NumberFormatException e) {
                opcion = 0;
            }
            switch (opcion) {
                case 1:
                    System.out.println("\\n--- REGISTRO DE NUEVO PRODUCTO ---");
                    System.out.print("Ingrese ID/Codigo del producto: ");
                    String id = scanner.nextLine().trim();
                    
                    if (inventario.buscarPorId(id) != null) {
                        System.out.println("[ERROR] Ya existe un producto registrado con ese ID.");
                        break;
                    }
                    
                    System.out.print("Ingrese nombre del producto: ");
                    String nombre = scanner.nextLine().trim();
                    
                    System.out.print("Ingrese precio de costo ($): ");
                    double costo = Double.parseDouble(scanner.nextLine().trim());
                    
                    System.out.print("Ingrese precio de venta ($): ");
                    double venta = Double.parseDouble(scanner.nextLine().trim());
                    
                    System.out.print("Ingrese stock inicial: ");
                    int stock = Integer.parseInt(scanner.nextLine().trim());
                    
                    Product nuevoProd = new Product(id, nombre, costo, venta, stock);
                    inventario.agregarProducto(nuevoProd);
                    break;
                
                case 2:
                    inventario.mostrarInventario();
                    break;
                
                case 3:
                    System.out.println("\\n--- BUSQUEDA DE PRODUCTO ---");
                    System.out.print("Ingrese el ID del producto a buscar: ");
                    String idBusqueda = scanner.nextLine().trim();
                    Product encontrado = inventario.buscarPorId(idBusqueda);
                    
                    if (encontrado != null) {
                        System.out.println("[OK] Producto encontrado:");
                        System.out.println(encontrado.toString());
                    }else {
                        System.out.println("[ERROR] No existe ningun producto con el ID '" + idBusqueda + "'.");
                    }
                    break;
                    
                case 4:
                    System.out.println("\\n--- ENTRADA DE MERCANCIA (LOTE) ---");
                    System.out.print("Ingrese el ID del producto: ");
                    String idEntrada = scanner.nextLine().trim();
                    
                    if (inventario.buscarPorId(idEntrada) == null) {
                        System.out.println("[ERROR] El ID ingresado no existe en el inventario.");
                        break;
                    }
                    System.out.print("Ingrese la cantidad de unidades que entraron: ");
                    int cantEntrada = Integer.parseInt(scanner.nextLine().trim());
                    
                    if (cantEntrada <= 0) {
                        System.out.println("[ERROR] La cantidad debe ser mayor a cero.");
                        break;
                    }
                    
                    if (inventario.modificarStock(idEntrada, cantEntrada)) {
                        pilaUndo.push(idEntrada, cantEntrada, "ENTRADA");
                        System.out.println("[OK] Entrada registrada en la pila de Undo.");
                    }
                    break;
                case 5:
                    System.out.println("\\n--- REGISTRO DE VENTA ---");
                    System.out.print("Ingrese el ID del producto a vender: ");
                    String idVenta = scanner.nextLine().trim();
                    
                    if (inventario.buscarPorId(idVenta) == null) {
                        System.out.println("[ERROR] El ID ingresado no existe en el inventario.");
                        break;
                    }
                    System.out.print("Ingrese la cantidad de unidades vendidas: ");
                    int cantVenta = Integer.parseInt(scanner.nextLine().trim());
                    
                    if (cantVenta <= 0) {
                        System.out.println("[ERROR] La cantidad debe ser mayor a cero.");
                        break;
                    }
                    
                    // Para la venta restamos del stock (-cantVenta)
                    if (inventario.modificarStock(idVenta, -cantVenta)) {
                        pilaUndo.push(idVenta, -cantVenta, "VENTA");
                        System.out.println("[OK] Venta registrada en la pila de Undo.");
                    }
                    break;
                    
                case 6:
                    System.out.println("\\n--- DESHACER ULTIMA ACCION (UNDO) ---");
                    pilaUndo.deshacerUltimaAccion(inventario);
                    break;
                
                case 7:
                    System.out.println("\\n[SISTEMA] Gracias por utilizar StockManager. Cierre de sesion exitoso.");
                    break;
                    
                default:    
                    System.out.println("\\n[ERROR] Opcion no valida. Ingrese un numero del 1 al 7.");
                    break;
            }       
        }while (opcion != 7);
        
        scanner.close();
    }
    
    // Metodo auxiliar para precargar productos al iniciar y facilitar la exposicion
    private static void cargarDatosPrueba(ListaProductos inventario) {
        inventario.agregarProducto(new Product("P001", "Sabritas Sal 160g", 18.50, 24.00, 10));
        inventario.agregarProducto(new Product("P002", "Coca Cola 600ml", 14.00, 18.00, 25));
        inventario.agregarProducto(new Product("P003", "Galletas Chokis", 15.00, 20.00, 15));
    }
    
}
