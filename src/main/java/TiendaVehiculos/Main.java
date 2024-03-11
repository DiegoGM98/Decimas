package TiendaVehiculos;

import java.util.Scanner;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        TiendaVehiculos tienda = new TiendaVehiculos();
        Scanner scanner = new Scanner(System.in);
        Cliente clienteActual = null;

        // Agregar algunos vehículos a la tienda
        tienda.agregarVehiculo(new Automovil("Toyota", "Corolla", 2020, 1500, 20000, 10, 150, 4, 1.8));
        tienda.agregarVehiculo(new Motocicleta("Honda", "CBR600RR", 2021, 200, 12000, 5, 100, "Deportiva", "Doble"));
        tienda.agregarVehiculo(new Bicicleta("Giant", "TCR", 2022, 7, 3000, 3, "Carbono", 200, 22));

        while (true) {
            if (clienteActual == null) {
                System.out.println("Bienvenido a la tienda de vehículos. ¿Qué te gustaría hacer?");
                System.out.println("1. Registrarse");
                System.out.println("2. Salir");
                System.out.print("Ingresa una opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine();  // Consumir el salto de línea

                switch (opcion) {
                    case 1:
                        // Registrarse
                        System.out.print("Ingresa tu nombre: ");
                        String nombre = scanner.nextLine();
                        System.out.print("Ingresa tu dirección: ");
                        String direccion = scanner.nextLine();
                        clienteActual = new Cliente(nombre, direccion);
                        tienda.agregarCliente(clienteActual);
                        System.out.println("¡Registro exitoso!");
                        break;
                    case 2:
                        // Salir
                        System.out.println("¡Gracias por visitar nuestra tienda!");
                        return;
                    default:
                        System.out.println("Opción no válida. Por favor, intenta de nuevo.");
                }
            } else {
                System.out.println("Hola, " + clienteActual.getNombre() + ". ¿Qué te gustaría hacer?");
                System.out.println("1. Ver catálogo de vehículos");
                System.out.println("2. Ver mi carrito");
                System.out.println("3. Cerrar sesión");
                System.out.print("Ingresa una opción: ");
                int opcion = scanner.nextInt();
                scanner.nextLine();  // Consumir el salto de línea

                switch (opcion) {
                    case 1:
                        // Ver catálogo de vehículos
                        System.out.println("¿Qué tipo de vehículo te gustaría ver?");
                        System.out.println("1. Automóvil");
                        System.out.println("2. Motocicleta");
                        System.out.println("3. Bicicleta");
                        System.out.print("Ingresa una opción: ");
                        int tipoVehiculo = scanner.nextInt();
                        scanner.nextLine();  // Consumir el salto de línea
                        String tipo = "";
                        switch (tipoVehiculo) {
                            case 1:
                                tipo = "Automovil";
                                break;
                            case 2:
                                tipo = "Motocicleta";
                                break;
                            case 3:
                                tipo = "Bicicleta";
                                break;
                            default:
                                System.out.println("Opción no válida. Por favor, intenta de nuevo.");
                                continue;
                        }
                        List<Vehiculo> vehiculos = tienda.buscarPorTipo(tipo);
                        for (Vehiculo vehiculo : vehiculos) {
                            tienda.obtenerInformacionVehiculo(vehiculo);
                            System.out.println("--------------------");
                        }
                        System.out.println("¿Te gustaría comprar alguno de estos vehículos? (s/n)");
                        String comprar = scanner.nextLine();
                        if (comprar.equalsIgnoreCase("s")) {
                            System.out.print("Ingresa la marca del vehículo: ");
                            String marca = scanner.nextLine();
                            System.out.print("Ingresa el modelo del vehículo: ");
                            String modelo = scanner.nextLine();
                            Vehiculo vehiculo = null;
                            for (Vehiculo v : vehiculos) {
                                if (v.getMarca().equals(marca) && v.getModelo().equals(modelo)) {
                                    vehiculo = v;
                                    break;
                                }
                            }
                            if (vehiculo != null) {
                                clienteActual.agregarAlCarrito(vehiculo);
                                System.out.println("¡Vehículo agregado al carrito!");
                            } else {
                                System.out.println("Vehículo no encontrado.");
                            }
                        }
                        break;
                    case 2:
                        // Ver mi carrito
                        if (clienteActual.getCarrito().isEmpty()) {
                            System.out.println("Tu carrito está vacío.");
                        } else {
                            for (Vehiculo v : clienteActual.getCarrito()) {
                                System.out.println(v.getMarca() + " " + v.getModelo());
                            }
                            System.out.println("¿Te gustaría comprar los vehículos en tu carrito? (s/n)");
                            String compra = scanner.nextLine();
                            if (compra.equalsIgnoreCase("s")) {
                                tienda.finalizarCompra(clienteActual);
                            } else {
                                System.out.println("Compra declinada.");
                            }
                        }
                        break;
                    case 3:
                        // Cerrar sesión
                        clienteActual = null;
                        System.out.println("Has cerrado sesión.");
                        break;
                    default:
                        System.out.println("Opción no válida. Por favor, intenta de nuevo.");
                }
            }
        }
    }
}
