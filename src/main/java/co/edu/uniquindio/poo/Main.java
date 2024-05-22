package co.edu.uniquindio.poo;
import java.util.Scanner;

//Codigo hecho por Maicol Stiwen Ochoa Garcia-1095208550

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Parqueadero parqueadero = new Parqueadero();

        // Configuración de tarifas
        parqueadero.setTarifaCarroPorHora(2000);
        parqueadero.setTarifaMotoClasicaPorHora(1000);
        parqueadero.setTarifaMotoHibridaPorHora(1500);

        boolean continuar = true;
        while (continuar) {
            System.out.println("\n--- Bienvenido al parqueadero Fuchibol ---");
            System.out.println("1. Registrar Entrada");
            System.out.println("2. Registrar Salida");
            System.out.println("3. Mostrar Estado del Parqueadero");
            System.out.println("4. Mostrar Información de Vehículo");
            System.out.println("5. Generar Reporte Diario");
            System.out.println("6. Cambiar Tarifas");
            System.out.println("7. Salir del Programa");
            System.out.print("Seleccione una opción: ");
            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    RegistrarEntrada.registrarEntrada(parqueadero, scanner);
                    break;
                case 2:
                    RegistrarSalida.registrarSalida(parqueadero, scanner);
                    break;
                case 3:
                    MostrarEstadoParqueadero.mostrarEstado(parqueadero);
                    break;
                case 4:
                    MostrarInformacionVehiculo.mostrarInformacion(parqueadero, scanner);
                    break;
                case 5:
                    parqueadero.generarReporteDiario();
                    break;
                case 6:
                    GestionTarifas.cambiarTarifas(parqueadero, scanner);
                    break;
                case 7:
                    SalirDelPrograma.salir(scanner);
                    continuar = false;
                    break;
                default:
                    System.out.println("Opción no válida. Por favor, seleccione una opción válida.");
            }
        }
    }
}


