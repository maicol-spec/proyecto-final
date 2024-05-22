package co.edu.uniquindio.poo;

import java.util.Scanner;

public class GestionTarifas {
    private static final String USUARIO_VALIDO = "encargado";
    private static final String CONTRASENA_VALIDA = "052906";

    public static void cambiarTarifas(Parqueadero parqueadero, Scanner scanner) {
        System.out.print("Ingrese el usuario: ");
        String usuario = scanner.nextLine();
        System.out.print("Ingrese la contraseña: ");
        String contrasena = scanner.nextLine();

        if (usuario.equals(USUARIO_VALIDO) && contrasena.equals(CONTRASENA_VALIDA)) {
            System.out.print("Ingrese nueva tarifa para carro por hora: ");
            int nuevaTarifaCarro = scanner.nextInt();
            System.out.print("Ingrese nueva tarifa para moto clásica por hora: ");
            int nuevaTarifaMotoClasica = scanner.nextInt();
            System.out.print("Ingrese nueva tarifa para moto híbrida por hora: ");
            int nuevaTarifaMotoHibrida = scanner.nextInt();
            scanner.nextLine(); 

            if (nuevaTarifaCarro < 0 || nuevaTarifaMotoClasica < 0 || nuevaTarifaMotoHibrida < 0) {
                System.out.println("Error: Las tarifas no pueden ser negativas. No se han actualizado las tarifas.");
            } else {
                parqueadero.setTarifaCarroPorHora(nuevaTarifaCarro);
                parqueadero.setTarifaMotoClasicaPorHora(nuevaTarifaMotoClasica);
                parqueadero.setTarifaMotoHibridaPorHora(nuevaTarifaMotoHibrida);
                System.out.println("Las tarifas han sido actualizadas.");
            }
        } else {
            System.out.println("Usuario o contraseña incorrectos. No se pudo cambiar las tarifas.");
        }
    }
}

