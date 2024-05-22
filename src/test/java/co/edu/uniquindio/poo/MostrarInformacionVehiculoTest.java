package co.edu.uniquindio.poo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.PrintStream;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class MostrarInformacionVehiculoTest {
    private Parqueadero parqueadero;
    private final ByteArrayOutputStream outContent = new ByteArrayOutputStream();

    @BeforeEach
    public void setUp() {
        // Configurar el parqueadero con algunos vehículos de ejemplo
        parqueadero = new Parqueadero(); // Crear un parqueadero pequeño para pruebas
        parqueadero.carros[0][0] = new Carro("ABC123","Toyota", "Juan Perez");
        parqueadero.motos[0][0] = new MotoClasica("DEF456", "Honda", "Maria Lopez", 100);
        System.setOut(new PrintStream(outContent)); // Redirigir la salida estándar a outContent
    }

    private void setScannerInput(String input) {
        InputStream in = new ByteArrayInputStream(input.getBytes());
        System.setIn(in);
    }

    @Test
    public void testMostrarInformacionCarroValido() {
        String input = "1\n1\n"; // Consultar el primer puesto de carros
        setScannerInput(input);

        Scanner scanner = new Scanner(System.in);
        MostrarInformacionVehiculo.mostrarInformacion(parqueadero, scanner);

        String output = outContent.toString().trim();
        assertTrue(output.contains("Placa: ABC123"));
        assertTrue(output.contains("Propietario: Juan Perez"));
        assertTrue(output.contains("Modelo: Toyota"));
        assertTrue(output.contains("Tipo: Carro"));
    }

    @Test
    public void testMostrarInformacionMotoValida() {
        String input = "1\n2\n"; // Consultar el primer puesto de motos
        setScannerInput(input);

        Scanner scanner = new Scanner(System.in);
        MostrarInformacionVehiculo.mostrarInformacion(parqueadero, scanner);

        String output = outContent.toString().trim();
        assertTrue(output.contains("Placa: DEF456"));
        assertTrue(output.contains("Propietario: Maria Lopez"));
        assertTrue(output.contains("Modelo: Honda"));
        assertTrue(output.contains("Tipo: Moto Clasica"));
        assertTrue(output.contains("Velocidad Máxima: 100"));
    }

    @Test
    public void testPuestoVacio() {
        String input = "2\n1\n"; // Consultar un puesto vacío en la matriz de carros
        setScannerInput(input);

        Scanner scanner = new Scanner(System.in);
        MostrarInformacionVehiculo.mostrarInformacion(parqueadero, scanner);

        String output = outContent.toString().trim();
        assertTrue(output.contains("El puesto está vacío."));
    }

    @Test
    public void testTipoVehiculoInvalido() {
        String input = "1\n3\n"; // Consultar con un tipo de vehículo inválido
        setScannerInput(input);

        Scanner scanner = new Scanner(System.in);
        MostrarInformacionVehiculo.mostrarInformacion(parqueadero, scanner);

        String output = outContent.toString().trim();
        assertTrue(output.contains("Opción no válida."));
    }

    @Test
    public void testVehiculoNoEncontrado() {
        String input = "3\n1\n"; // Consultar un puesto que no existe
        setScannerInput(input);

        Scanner scanner = new Scanner(System.in);
        MostrarInformacionVehiculo.mostrarInformacion(parqueadero, scanner);

        String output = outContent.toString().trim();
        assertTrue(output.contains("Vehículo no encontrado."));
    }
}

