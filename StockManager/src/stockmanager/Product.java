package stockmanager;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author Erick
 */
public class Product {
    // Atributos encapsulados del producto
    private String id; //Código único o código de barras del producto
    private String name; // Nombre o descripción corta del producto
    private double costPrice; // Precio de costo al que se compró el lote/caja
    private double salePrice; // Precio de venta al público por unidad
    private int stock; // Cantidad disponible en existencia
    
    /*
    Product
    
    PRE: Ninguna.
    POST: Inicializa un objeto de producto con valores por defecto.
    */
    
    public Product() {
        this.id = "";
        this.name = "";
        this.costPrice = 0.0;
        this.salePrice = 0.0;
        this.stock = 0;
    }
    /*
    Product
    
    PRE: id != null, name != null, costPrice &gt;= 0, salePrice &gt;= 0, stock &gt;= 0.
    POST: Crea una instancia de producto con los atributos recibidos.
    */
    
    public Product(String id, String name, double costPrice, double salePrice, int stock) {
        this.id = id;
        this.name = name;
        this.costPrice = costPrice;
        this.salePrice = salePrice;
        this.stock = stock;
        
    }
    // --- MÉTODOS GETTERS Y SETTERS ---

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getCostPrice() {
        return costPrice;
    }

    public void setCostPrice(double costPrice) {
        this.costPrice = costPrice;
    }

    public double getSalePrice() {
        return salePrice;
    }

    public void setSalePrice(double salePrice) {
        this.salePrice = salePrice;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }
    
    @Override
    public String toString() {
        return "ID: " + id + " | Nombre: " + name + " | Costo: $" + costPrice + " | Venta: $" + salePrice + " | Stock: " + stock + " unidades";
    }
}
