package co.edu.uniquindio.poo;

import java.time.LocalDateTime;
import java.util.Scanner;

public class RegistrarSalida {
    public static void registrarSalida(Parqueadero parqueadero, Scanner scanner) {
        System.out.print("Ingrese la placa del vehículo: ");
        String placaSalida = scanner.nextLine().trim().toUpperCase();
        System.out.print("Ingrese el tipo de vehículo (carro o moto): ");
        String tipoVehicleSalida = scanner.nextLine();


        int FILAS_CARROS = parqueadero.carros.length;
        int COLUMNAS_CARROS = parqueadero.carros[0].length;
        int FILAS_MOTOS = parqueadero.motos.length;
        int COLUMNAS_MOTOS = parqueadero.motos[0].length;

        boolean vehiculoEncontrado = false;

        if (!tipoVehicleSalida.equalsIgnoreCase("carro") && !tipoVehicleSalida.equalsIgnoreCase("moto")) {
            System.out.println("Tipo de vehículo no válido.");
        } else {
            if (tipoVehicleSalida.equalsIgnoreCase("carro")) {
                for (int i = 0; i < FILAS_CARROS; i++) {
                    for (int j = 0; j < COLUMNAS_CARROS; j++) {
                        Vehicle vehicleSalida = parqueadero.carros[i][j];
                        if (vehicleSalida != null && vehicleSalida.getPlaca().toUpperCase().equals(placaSalida)) {
                            parqueadero.carros[i][j] = null;
                            LocalDateTime horaSalida = LocalDateTime.now();
                            parqueadero.registrarSalida(vehicleSalida, horaSalida);
                            vehiculoEncontrado = true;
                            break;
                        }
                    }
                    if (vehiculoEncontrado) break;
                }
            } else {
                for (int i = 0; i < FILAS_MOTOS; i++) {
                    for (int j = 0; j < COLUMNAS_MOTOS; j++) {
                        Vehicle vehicleSalida = parqueadero.motos[i][j];
                        if (vehicleSalida != null && vehicleSalida.getPlaca().toUpperCase().equals(placaSalida)) {
                            parqueadero.motos[i][j] = null;
                            LocalDateTime horaSalida = LocalDateTime.now();
                            parqueadero.registrarSalida(vehicleSalida, horaSalida);
                            vehiculoEncontrado = true;
                            break;
                        }
                    }
                    if (vehiculoEncontrado) break;
                }
            }
        }

        if (!vehiculoEncontrado) {
            System.out.println("Vehículo no encontrado.");
        }
    }
}





