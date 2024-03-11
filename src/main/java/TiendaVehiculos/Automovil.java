package TiendaVehiculos;

class Automovil extends Vehiculo {
    private double potencia;  // Potencia en HP
    private int numeroPuertas;
    private double tamanoMotor;  // Tamaño del motor

    // Constructor
    public Automovil(String marca, String modelo, int anoFabricacion, double peso, double precio, int stock, double potencia, int numeroPuertas, double tamanoMotor) {
        super(marca, modelo, anoFabricacion, peso, precio, stock);
        this.potencia = potencia;
        this.numeroPuertas = numeroPuertas;
        this.tamanoMotor = tamanoMotor;
    }

    // Métodos getter
    public double getPotencia() {
        return this.potencia;
    }

    public int getNumeroPuertas() {
        return this.numeroPuertas;
    }

    public double getTamanoMotor() {
        return this.tamanoMotor;
    }

    @Override
    double calcularVelocidadMaxima() {
        return (potencia / getPeso()) * 10;
    }
}