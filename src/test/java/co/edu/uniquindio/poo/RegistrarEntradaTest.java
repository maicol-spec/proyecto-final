package co.edu.uniquindio.poo;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.InputStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class RegistrarEntradaTest {
    private Parqueadero parqueadero;
    private Scanner scanner;

    @BeforeEach
    public void setUp() {
        parqueadero = new Parqueadero();
    }

    private void setScannerInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        scanner = new Scanner(in);
    }

    @Test
    public void testRegistrarEntradaCarroValido() {
        String input = "1\nABC123\nToyota\nJuan Perez\n1\n";
        setScannerInput(input);

        RegistrarEntrada.registrarEntrada(parqueadero, scanner);

        assertNotNull(parqueadero.carros[0][0]);
        assertTrue(parqueadero.carros[0][0] instanceof Carro);
        assertEquals("ABC123", parqueadero.carros[0][0].placa);
    }

    @Test
    public void testRegistrarEntradaMotoClasicaValida() {
        String input = "2\n1\n100\nDEF456\nHonda\nMaria Lopez\n1\n";
        setScannerInput(input);

        RegistrarEntrada.registrarEntrada(parqueadero, scanner);

        assertNotNull(parqueadero.motos[0][0]);
        assertTrue(parqueadero.motos[0][0] instanceof MotoClasica);
        assertEquals("DEF456", parqueadero.motos[0][0].placa);
    }

    @Test
    public void testRegistrarEntradaTipoVehiculoInvalido() {
        String input = "3\n";
        setScannerInput(input);

        RegistrarEntrada.registrarEntrada(parqueadero, scanner);

        // No se debe registrar ningún vehículo
        for (int i = 0; i < Parqueadero.FILAS_CARROS; i++) {
            for (int j = 0; j < Parqueadero.COLUMNAS_CARROS; j++) {
                assertNull(parqueadero.carros[i][j]);
            }
        }

        for (int i = 0; i < Parqueadero.FILAS_MOTOS; i++) {
            for (int j = 0; j < Parqueadero.COLUMNAS_MOTOS; j++) {
                assertNull(parqueadero.motos[i][j]);
            }
        }
    }

    @Test
    public void testRegistrarEntradaPuestoOcupado() {
        // Datos de entrada para el primer vehículo (Carro)
        String input1 = "1\nABC123\nToyota\nJuan Perez\n1\n";
        setScannerInput(input1);
        RegistrarEntrada.registrarEntrada(parqueadero, scanner);

        // Datos de entrada para el segundo vehículo (Carro)
        String input2 = "1\nGHI789\nMazda\nLuis Gomez\n2\n"; // Cambiar el puesto para evitar colisión
        setScannerInput(input2);
        RegistrarEntrada.registrarEntrada(parqueadero, scanner);

        // El primer vehículo debe estar en el puesto 1
        assertNotNull(parqueadero.carros[0][0]);
        assertEquals("ABC123", parqueadero.carros[0][0].placa);

        // El segundo vehículo debe haberse registrado en un puesto diferente
        assertNotNull(parqueadero.carros[0][1]);
        assertEquals("GHI789", parqueadero.carros[0][1].placa);
    }
}

