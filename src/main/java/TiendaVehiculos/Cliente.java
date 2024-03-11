package TiendaVehiculos;

import java.util.ArrayList;
import java.util.List;

class Cliente {
    // Atributos
    private String nombre;
    private String direccion;
    private List<Vehiculo> carrito;

    // Constructor
    public Cliente(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.carrito = new ArrayList<>();
    }

    // Métodos getter/setter
    public String getNombre() {
        return this.nombre;
    }

    public String getDireccion() {
        return this.direccion;
    }

    public List<Vehiculo> getCarrito() {
        return this.carrito;
    }

    // Método para agregar un vehículo al carrito
    public void agregarAlCarrito(Vehiculo vehiculo) {
        this.carrito.add(vehiculo);
    }
}

