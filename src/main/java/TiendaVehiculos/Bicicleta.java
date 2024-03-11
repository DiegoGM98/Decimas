package TiendaVehiculos;

class Bicicleta extends Vehiculo {
    private String materialConstruccion;
    private double fuerzaPedaleo;  // Fuerza de pedaleo en newtons
    private int numeroVelocidades;

    // Constructor
    public Bicicleta(String marca, String modelo, int anoFabricacion, double peso, double precio, int stock, String materialConstruccion, double fuerzaPedaleo, int numeroVelocidades) {
        super(marca, modelo, anoFabricacion, peso, precio, stock);
        this.materialConstruccion = materialConstruccion;
        this.fuerzaPedaleo = fuerzaPedaleo;
        this.numeroVelocidades = numeroVelocidades;
    }

    // Métodos getter
    public String getMaterialConstruccion() {
        return this.materialConstruccion;
    }

    public double getFuerzaPedaleo() {
        return this.fuerzaPedaleo;
    }

    public int getNumeroVelocidades() {
        return this.numeroVelocidades;
    }

    @Override
    double calcularVelocidadMaxima() {
        return ((fuerzaPedaleo / getPeso()) * 100) + 10;
    }
}
