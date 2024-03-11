package TiendaVehiculos;
import java.util.List;


import java.time.LocalDate;

class Compra {
    // Atributos
    private List<Vehiculo> vehiculos;
    private Cliente cliente;
    private LocalDate fecha;

    // Constructor
    public Compra(List<Vehiculo> vehiculos, Cliente cliente) {
        this.vehiculos = vehiculos;
        this.cliente = cliente;
        this.fecha = LocalDate.now();
    }

    // Métodos getter
    public List<Vehiculo> getVehiculos() {
        return this.vehiculos;
    }

    public Cliente getCliente() {
        return this.cliente;
    }

    public LocalDate getFecha() {
        return this.fecha;
    }
}
