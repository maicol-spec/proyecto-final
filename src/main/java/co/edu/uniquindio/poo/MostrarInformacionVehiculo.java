package co.edu.uniquindio.poo;

import java.util.Scanner;

public class MostrarInformacionVehiculo {
    public static void mostrarInformacion(Parqueadero parqueadero, Scanner scanner) {
        try {
            System.out.print("Ingrese el número de puesto del vehículo: ");
            int puestoConsulta = scanner.nextInt();
            scanner.nextLine();

            System.out.print("El vehículo está en (1) Carros o (2) Motos? Ingrese 1 o 2: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            boolean vehiculoEncontrado = false;

            if (opcion == 1) { // Buscar en la matriz de carros
                int FILAS_CARROS = parqueadero.carros.length;
                int COLUMNAS_CARROS = parqueadero.carros[0].length;
                int puestoActual = 1; 

                for (int i = 0; i < FILAS_CARROS; i++) {
                    for (int j = 0; j < COLUMNAS_CARROS; j++) {
                        if (puestoActual == puestoConsulta) {
                            if (parqueadero.carros[i][j] != null) {
                                Vehicle vehiculoConsultado = parqueadero.carros[i][j];
                                System.out.println("Placa: " + vehiculoConsultado.getPlaca());
                                System.out.println("Propietario: " + vehiculoConsultado.getPropietario());
                                System.out.println("Modelo: " + vehiculoConsultado.getModelo());
                                System.out.println("Tipo: Carro");
                                System.out.println("Hora de ingreso: " + vehiculoConsultado.getHoraIngreso());
                                vehiculoEncontrado = true;
                            } else {
                                System.out.println("El puesto está vacío.");
                            }
                            break;
                        }
                        puestoActual++;
                    }
                    if (vehiculoEncontrado) break;
                }
            } else if (opcion == 2) { // Buscar en la matriz de motos
                int FILAS_MOTOS = parqueadero.motos.length;
                int COLUMNAS_MOTOS = parqueadero.motos[0].length;
                int puestoActual = 1;

                for (int i = 0; i < FILAS_MOTOS; i++) {
                    for (int j = 0; j < COLUMNAS_MOTOS; j++) {
                        if (puestoActual == puestoConsulta) {
                            if (parqueadero.motos[i][j] != null) {
                                Vehicle vehiculoConsultado = parqueadero.motos[i][j];
                                System.out.println("Placa: " + vehiculoConsultado.getPlaca());
                                System.out.println("Propietario: " + vehiculoConsultado.getPropietario());
                                System.out.println("Modelo: " + vehiculoConsultado.getModelo());
                                if (vehiculoConsultado instanceof MotoClasica) {
                                    MotoClasica motoClasica = (MotoClasica) vehiculoConsultado;
                                    System.out.println("Tipo: Moto Clasica");
                                    System.out.println("Velocidad Máxima: " + motoClasica.getVelocidadMaxima());
                                } else if (vehiculoConsultado instanceof MotoHibrida) {
                                    MotoHibrida motoHibrida = (MotoHibrida) vehiculoConsultado;
                                    System.out.println("Tipo: Moto Híbrida");
                                    System.out.println("Velocidad Máxima: " + motoHibrida.getVelocidadMaxima());
                                }
                                System.out.println("Hora de ingreso: " + vehiculoConsultado.getHoraIngreso());
                                vehiculoEncontrado = true;
                            } else {
                                System.out.println("El puesto está vacío.");
                            }
                            break;
                        }
                        puestoActual++;
                    }
                    if (vehiculoEncontrado) break;
                }
            } else {
                System.out.println("Opción no válida.");
            }

            if (!vehiculoEncontrado && (opcion == 1 || opcion == 2)) {
                System.out.println("Vehículo no encontrado.");
            }
        } catch (Exception e) {
            System.out.println("Ocurrió un error: " + e.getMessage());
            e.printStackTrace();
        }
    }
}




