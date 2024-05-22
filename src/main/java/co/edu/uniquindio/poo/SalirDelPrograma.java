
package co.edu.uniquindio.poo;

import java.util.Scanner;

public class SalirDelPrograma {
    public static void salir(Scanner scanner) {
        System.out.println("Saliendo del programa...");
        scanner.close();
        System.exit(0);
    }
}
