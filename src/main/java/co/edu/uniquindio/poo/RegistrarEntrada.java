package co.edu.uniquindio.poo;

import java.time.LocalDateTime;
import java.util.Scanner;

public class RegistrarEntrada {
    public static void registrarEntrada(Parqueadero parqueadero, Scanner scanner) {
        System.out.println("Bienvenido al parqueadero Los Futbolines:");
        System.out.println("1. Carro");
        System.out.println("2. Moto");
        System.out.print("Ingrese el número correspondiente al tipo de vehículo: ");
        int tipoVehiculo = scanner.nextInt();
        scanner.nextLine(); 

        if (tipoVehiculo != 1 && tipoVehiculo != 2) {
            System.out.println("Tipo de vehículo no válido.");
            return;
        }

        int tipoMoto = 0;
        int velocidadMaxima = 0;
        String placa = "";

        if (tipoVehiculo == 2) {
            System.out.println("Seleccione el tipo de moto:");
            System.out.println("1. Moto clásica");
            System.out.println("2. Moto híbrida");
            System.out.print("Ingrese el número correspondiente al tipo de moto: ");
            tipoMoto = scanner.nextInt();
            scanner.nextLine(); 

            if (tipoMoto != 1 && tipoMoto != 2) {
                System.out.println("Tipo de moto no válido.");
                return;
            }

            while (true) {
                System.out.print("Ingrese la velocidad máxima de la moto (deben ser 3 números): ");
                velocidadMaxima = scanner.nextInt();
                scanner.nextLine(); 

                if (String.valueOf(velocidadMaxima).length() == 3) {
                    break;
                } else {
                    System.out.println("Debe ingresar exactamente tres números. Intente nuevamente.");
                }
            }
        }


        while (true) {
            System.out.print("Ingrese la placa del vehículo (deben ser 3 letras seguidas de 3 números): ");
            placa = scanner.nextLine().trim().toUpperCase();

            if (placa.matches("[A-Z]{3}[0-9]{3}")) {
                break;
            } else {
                System.out.println("Formato de placa incorrecto. Deben ser 3 letras seguidas de 3 números. Intente nuevamente.");
            }
        }

        System.out.print("Ingrese el modelo del vehículo: ");
        String modelo = scanner.nextLine();
        System.out.print("Ingrese el propietario del vehículo: ");
        String propietario = scanner.nextLine();

        Vehicle vehicle = null;

        if (tipoVehiculo == 1) {
            vehicle = new Carro(placa, modelo, propietario);
            verificarYAsignarPuesto(parqueadero, scanner, vehicle, Parqueadero.FILAS_CARROS, Parqueadero.COLUMNAS_CARROS, parqueadero.carros);
        } else {
            if (tipoMoto == 1) {
                vehicle = new MotoClasica(placa, modelo, propietario, velocidadMaxima);
            } else {
                vehicle = new MotoHibrida(placa, modelo, propietario, velocidadMaxima);
            }
            verificarYAsignarPuesto(parqueadero, scanner, vehicle, Parqueadero.FILAS_MOTOS, Parqueadero.COLUMNAS_MOTOS, parqueadero.motos);
        }

        LocalDateTime horaIngreso = LocalDateTime.now();
        parqueadero.registrarIngreso(vehicle, horaIngreso);
    }

    private static void verificarYAsignarPuesto(Parqueadero parqueadero, Scanner scanner, Vehicle vehicle, int filas, int columnas, Vehicle[][] puestos) {
        int totalPuestos = filas * columnas;

        while (true) {
            System.out.print("Ingrese el número del puesto: ");
            int puesto = scanner.nextInt() - 1; 
            scanner.nextLine();

            if (puesto < 0 || puesto >= totalPuestos) {
                System.out.println("Número de puesto fuera de rango. Intente nuevamente.");
                continue;
            }

            int fila = puesto / columnas;
            int columna = puesto % columnas;

            if (puestos[fila][columna] != null) {
                System.out.println("Puesto ocupado. Intente nuevamente.");
            } else {
                puestos[fila][columna] = vehicle;
                System.out.println("Puesto asignado correctamente.");
                break;
            }
        }
    }
}




