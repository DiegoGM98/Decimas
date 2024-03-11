package TiendaVehiculos;

// Clase abstracta Vehiculo
abstract class Vehiculo {
    // Atributos
    private String marca;
    private String modelo;
    private int anoFabricacion;
    private double peso;
    private double precio;
    private int stock;

    // Constructor
    public Vehiculo(String marca, String modelo, int anoFabricacion, double peso, double precio, int stock) {
        this.marca = marca;
        this.modelo = modelo;
        this.anoFabricacion = anoFabricacion;
        this.peso = peso;
        this.precio = precio;
        this.stock = stock;
    }

    // Métodos getter/setter
    public String getMarca() {
        return this.marca;
    }

    public String getModelo() {
        return this.modelo;
    }

    public int getAnoFabricacion() {
        return this.anoFabricacion;
    }

    public double getPeso() {
        return this.peso;
    }

    public double getPrecio() {
        return this.precio;
    }

    public int getStock() {
        return this.stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

    // Método abstracto para calcular la velocidad máxima
    abstract double calcularVelocidadMaxima();
}
