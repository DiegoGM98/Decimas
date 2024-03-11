package TiendaVehiculos;

import java.util.List;
import java.util.ArrayList;

class TiendaVehiculos {
    // Atributos
    private List<Vehiculo> catalogo;
    private List<Cliente> clientes;
    private List<Compra> compras;

    // Constructor
    public TiendaVehiculos() {
        this.catalogo = new ArrayList<>();
        this.clientes = new ArrayList<>();
        this.compras = new ArrayList<>();
    }

    // Métodos getter/setter
    public List<Vehiculo> getCatalogo() {
        return this.catalogo;
    }

    public List<Cliente> getClientes() {
        return this.clientes;
    }

    public List<Compra> getCompras() {
        return this.compras;
    }

    // Método para agregar un cliente
    public void agregarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    // Método para agregar un vehículo al catálogo
    public void agregarVehiculo(Vehiculo vehiculo) {
        this.catalogo.add(vehiculo);
    }

    // Método para buscar vehículos por tipo
    public List<Vehiculo> buscarPorTipo(String tipo) {
        List<Vehiculo> resultado = new ArrayList<>();
        for (Vehiculo vehiculo : this.catalogo) {
            if (vehiculo instanceof Automovil && tipo.equalsIgnoreCase("Automovil")) {
                resultado.add(vehiculo);
            } else if (vehiculo instanceof Motocicleta && tipo.equalsIgnoreCase("Motocicleta")) {
                resultado.add(vehiculo);
            } else if (vehiculo instanceof Bicicleta && tipo.equalsIgnoreCase("Bicicleta")) {
                resultado.add(vehiculo);
            }
        }
        return resultado;
    }

    // Método para realizar una venta
    public void realizarVenta(Cliente cliente, Vehiculo vehiculo) {
        if (vehiculo.getStock() > 0) {
            cliente.agregarAlCarrito(vehiculo);
            vehiculo.setStock(vehiculo.getStock() - 1);
            System.out.println("¡Vehículo agregado al carrito!");
        } else {
            System.out.println("Lo sentimos, este vehículo no está disponible en stock.");
        }
    }

    // Método para finalizar una compra
    public void finalizarCompra(Cliente cliente) {
        if (!cliente.getCarrito().isEmpty()) {
            this.compras.add(new Compra(new ArrayList<>(cliente.getCarrito()), cliente));
            cliente.getCarrito().clear();
            System.out.println("¡Compra realizada con éxito!");
        } else {
            System.out.println("Tu carrito está vacío.");
        }
    }
    public void obtenerInformacionVehiculo(Vehiculo vehiculo) {
        System.out.println("Marca: " + vehiculo.getMarca());
        System.out.println("Modelo: " + vehiculo.getModelo());
        System.out.println("Año de fabricación: " + vehiculo.getAnoFabricacion());
        System.out.println("Peso: " + vehiculo.getPeso());
        System.out.println("Precio: " + vehiculo.getPrecio());
        System.out.println("Stock: " + vehiculo.getStock());
        System.out.println("Velocidad máxima permitida: " + vehiculo.calcularVelocidadMaxima());
        if (vehiculo instanceof Automovil) {
            Automovil auto = (Automovil) vehiculo;
            System.out.println("Potencia: " + auto.getPotencia());
            System.out.println("Número de puertas: " + auto.getNumeroPuertas());
            System.out.println("Tamaño del motor: " + auto.getTamanoMotor());
        } else if (vehiculo instanceof Motocicleta) {
            Motocicleta moto = (Motocicleta) vehiculo;
            System.out.println("Potencia: " + moto.getPotencia());
            System.out.println("Tipo de motor: " + moto.getTipoMotor());
            System.out.println("Suspensión: " + moto.getSuspension());
        } else if (vehiculo instanceof Bicicleta) {
            Bicicleta bici = (Bicicleta) vehiculo;
            System.out.println("Material de construcción: " + bici.getMaterialConstruccion());
            System.out.println("Fuerza de pedaleo: " + bici.getFuerzaPedaleo());
            System.out.println("Número de velocidades: " + bici.getNumeroVelocidades());
        }
    }
}

