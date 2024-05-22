package co.edu.uniquindio.poo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.util.Scanner;
import static org.junit.jupiter.api.Assertions.assertEquals;


public class GestionTarifasTest {

    private Parqueadero parqueadero;
    private Scanner scanner;

    @BeforeEach
    public void setUp() {
        parqueadero = new Parqueadero();
    }

    @Test
    public void testCambiarTarifasConCredencialesCorrectas() {
        String input = "encargado\n052906\n5000\n3000\n4000\n";
        scanner = new Scanner(input);

        GestionTarifas.cambiarTarifas(parqueadero, scanner);

        assertEquals(5000, parqueadero.getTarifaCarroPorHora());
        assertEquals(3000, parqueadero.getTarifaMotoClasicaPorHora());
        assertEquals(4000, parqueadero.getTarifaMotoHibridaPorHora());
    }

    @Test
    public void testCambiarTarifasConUsuarioIncorrecto() {
        String input = "usuarioIncorrecto\n052906\n5000\n3000\n4000\n";
        scanner = new Scanner(input);

        GestionTarifas.cambiarTarifas(parqueadero, scanner);

        assertEquals(0, parqueadero.getTarifaCarroPorHora());
        assertEquals(0, parqueadero.getTarifaMotoClasicaPorHora());
        assertEquals(0, parqueadero.getTarifaMotoHibridaPorHora());
    }

    @Test
    public void testCambiarTarifasConContrasenaIncorrecta() {
        String input = "encargado\ncontrasenaIncorrecta\n5000\n3000\n4000\n";
        scanner = new Scanner(input);

        GestionTarifas.cambiarTarifas(parqueadero, scanner);

        assertEquals(0, parqueadero.getTarifaCarroPorHora());
        assertEquals(0, parqueadero.getTarifaMotoClasicaPorHora());
        assertEquals(0, parqueadero.getTarifaMotoHibridaPorHora());
    }

    @Test
    public void testCambiarTarifasConTarifasInvalidas() {
        String input = "encargado\n052906\n-5000\n-3000\n-4000\n";
        scanner = new Scanner(input);

        // Validamos que las tarifas no se pueden cambiar a valores negativos,
        // suponiendo que el sistema tiene validaciones internas.
        GestionTarifas.cambiarTarifas(parqueadero, scanner);

        assertEquals(0, parqueadero.getTarifaCarroPorHora());
        assertEquals(0, parqueadero.getTarifaMotoClasicaPorHora());
        assertEquals(0, parqueadero.getTarifaMotoHibridaPorHora());
    }
}

