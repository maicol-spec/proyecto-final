
package co.edu.uniquindio.poo;

public class MostrarEstadoParqueadero {
    public static void mostrarEstado(Parqueadero parqueadero) {
        System.out.println("Matriz de carros:");
        parqueadero.mostrarMatriz(parqueadero.carros);
        System.out.println("Matriz de motos:");
        parqueadero.mostrarMatriz(parqueadero.motos);
    }
}

