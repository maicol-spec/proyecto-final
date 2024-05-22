package co.edu.uniquindio.poo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class RegistrarSalidaTest {
    private Parqueadero parqueadero;
    private Scanner scanner;

    @BeforeEach
    public void setUp() {
        parqueadero = new Parqueadero();
    }

    @Test
    public void testRegistrarSalidaCarroValido() {
        Carro carro = new Carro("ABC123", "Toyota", "Juan Perez");
        parqueadero.carros[0][0] = carro;

        String input = "ABC123\ncarro\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        scanner = new Scanner(in);

        RegistrarSalida.registrarSalida(parqueadero, scanner);

        assertNull(parqueadero.carros[0][0]);
    }

    @Test
    public void testRegistrarSalidaMotoValida() {
        MotoClasica moto = new MotoClasica("DEF456","Nissan", "Maria Lopez",190);
        parqueadero.motos[0][0] = moto;

        String input = "DEF456\nmoto\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        scanner = new Scanner(in);

        RegistrarSalida.registrarSalida(parqueadero, scanner);

        assertNull(parqueadero.motos[0][0]);
    }

    @Test
    public void testRegistrarSalidaTipoVehiculoInvalido() {
        Carro carro = new Carro("ABC123", "Acura", "Juan Perez");
        parqueadero.carros[0][0] = carro;

        String input = "ABC123\nbicicleta\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        scanner = new Scanner(in);

        RegistrarSalida.registrarSalida(parqueadero, scanner);

        assertNotNull(parqueadero.carros[0][0]);
    }

    @Test
    public void testRegistrarSalidaVehiculoNoEncontrado() {
        String input = "XYZ789\ncarro\n";
        InputStream in = new ByteArrayInputStream(input.getBytes());
        scanner = new Scanner(in);

        RegistrarSalida.registrarSalida(parqueadero, scanner);

        // No se debe haber removido ningún vehículo
        for (int i = 0; i < parqueadero.carros.length; i++) {
            for (int j = 0; j < parqueadero.carros[0].length; j++) {
                assertNull(parqueadero.carros[i][j]);
            }
        }

        for (int i = 0; i < parqueadero.motos.length; i++) {
            for (int j = 0; j < parqueadero.motos[0].length; j++) {
                assertNull(parqueadero.motos[i][j]);
            }
        }
    }
}

