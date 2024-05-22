package co.edu.uniquindio.poo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.ChronoUnit;

public class Parqueadero {
    private double tarifaCarroPorHora;
    private double tarifaMotoClasicaPorHora;
    private double tarifaMotoHibridaPorHora;

    public static final int FILAS_CARROS = 7;
    public static final int COLUMNAS_CARROS = 7;
    public static final int FILAS_MOTOS = 9;
    public static final int COLUMNAS_MOTOS = 9;

    public Vehicle[][] carros;
    public Vehicle[][] motos;

    public double ingresosDiariosCarros;
    public double ingresosDiariosMotosClasicas;
    public double ingresosDiariosMotosHibridas;
    public LocalDate fechaActual;

    public Parqueadero() {
        carros = new Vehicle[FILAS_CARROS][COLUMNAS_CARROS];
        motos = new Vehicle[FILAS_MOTOS][COLUMNAS_MOTOS];
        fechaActual = LocalDate.now();
    }

    public double getTarifaCarroPorHora() {
        return tarifaCarroPorHora;
    }

    public void setTarifaCarroPorHora(double tarifaCarroPorHora) {
        this.tarifaCarroPorHora = tarifaCarroPorHora;
    }

    public double getTarifaMotoClasicaPorHora() {
        return tarifaMotoClasicaPorHora;
    }

    public void setTarifaMotoClasicaPorHora(double tarifaMotoClasicaPorHora) {
        this.tarifaMotoClasicaPorHora = tarifaMotoClasicaPorHora;
    }

    public double getTarifaMotoHibridaPorHora() {
        return tarifaMotoHibridaPorHora;
    }

    public void setTarifaMotoHibridaPorHora(double tarifaMotoHibridaPorHora) {
        this.tarifaMotoHibridaPorHora = tarifaMotoHibridaPorHora;
    }

    public void registrarIngreso(Vehicle vehicle, LocalDateTime horaIngreso) {
        vehicle.setHoraIngreso(horaIngreso);
        System.out.println("Ingreso registrado - Vehículo: " + vehicle.getPlaca() + ", Propietario: " + vehicle.getPropietario() + ", Hora de ingreso: " + horaIngreso);
    }

    public void registrarSalida(Vehicle vehicle, LocalDateTime horaSalida) {
        System.out.println("Salida registrada - Vehículo: " + vehicle.getPlaca() + ", Propietario: " + vehicle.getPropietario() + ", Hora de salida: " + horaSalida);

        LocalDateTime horaIngreso = vehicle.getHoraIngreso();
        if (horaIngreso == null) {
            System.out.println("Error: Hora de ingreso no registrada para el vehículo " + vehicle.getPlaca());
            return;
        }

        long tiempoDeUsoEnHoras = ChronoUnit.HOURS.between(horaIngreso, horaSalida);

        double costoTotal;
        if (vehicle instanceof Carro) {
            costoTotal = tarifaCarroPorHora * tiempoDeUsoEnHoras;
            ingresosDiariosCarros += costoTotal;
        } else if (vehicle instanceof MotoClasica) {
            costoTotal = tarifaMotoClasicaPorHora * tiempoDeUsoEnHoras;
            ingresosDiariosMotosClasicas += costoTotal;
        } else if (vehicle instanceof MotoHibrida) {
            costoTotal = tarifaMotoHibridaPorHora * tiempoDeUsoEnHoras;
            ingresosDiariosMotosHibridas += costoTotal;
        } else {
            System.out.println("Error: Tipo de vehículo desconocido");
            return;
        }

        System.out.println("Costo total de estacionamiento: $" + costoTotal);
    }

    public void mostrarMatriz(Vehicle[][] matriz) {
        int numeroPuesto = 1;
        for (int i = 0; i < matriz.length; i++) {
            for (int j = 0; j < matriz[i].length; j++) {
                System.out.printf("%2d ", numeroPuesto); // Mostrar número de puesto antes del cajón
                if (matriz[i][j] != null) {
                    System.out.print("[X] ");
                } else {
                    System.out.print("[ ] ");
                }
                numeroPuesto++;
            }
            System.out.println();
        }
    }

    public void generarReporteDiario() {
        LocalDate hoy = LocalDate.now();
        if (!hoy.equals(fechaActual)) {
            reiniciarIngresosDiarios();
            fechaActual = hoy;
        }

        System.out.println("Reporte Diario (" + fechaActual + "):");
        System.out.println("Carros: $" + ingresosDiariosCarros);
        System.out.println("Motos Clásicas: $" + ingresosDiariosMotosClasicas);
        System.out.println("Motos Híbridas: $" + ingresosDiariosMotosHibridas);
        System.out.println("Total: $" + (ingresosDiariosCarros + ingresosDiariosMotosClasicas + ingresosDiariosMotosHibridas));
    }

    private void reiniciarIngresosDiarios() {
        ingresosDiariosCarros = 0;
        ingresosDiariosMotosClasicas = 0;
        ingresosDiariosMotosHibridas = 0;
    }
}

