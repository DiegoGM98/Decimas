package TiendaVehiculos;

class Motocicleta extends Vehiculo {
    private double potencia;  // Potencia en HP
    private String tipoMotor;
    private String suspension;

    // Constructor
    public Motocicleta(String marca, String modelo, int anoFabricacion, double peso, double precio, int stock, double potencia, String tipoMotor, String suspension) {
        super(marca, modelo, anoFabricacion, peso, precio, stock);
        this.potencia = potencia;
        this.tipoMotor = tipoMotor;
        this.suspension = suspension;
    }

    // Métodos getter
    public double getPotencia() {
        return this.potencia;
    }

    public String getTipoMotor() {
        return this.tipoMotor;
    }

    public String getSuspension() {
        return this.suspension;
    }

    @Override
    double calcularVelocidadMaxima() {
        return ((potencia * 2) / getPeso()) * 20;
    }
}
