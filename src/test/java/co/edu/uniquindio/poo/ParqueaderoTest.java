
package co.edu.uniquindio.poo;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDateTime;

import static org.junit.jupiter.api.Assertions.*;

class ParqueaderoTest {
    private Parqueadero parqueadero;
    private Vehicle carro;
    private Vehicle motoClasica;
    private Vehicle motoHibrida;

    @BeforeEach
    void setUp() {
        parqueadero = new Parqueadero();
        parqueadero.setTarifaCarroPorHora(5.0);
        parqueadero.setTarifaMotoClasicaPorHora(3.0);
        parqueadero.setTarifaMotoHibridaPorHora(4.0);

        carro = new Carro("ABC123","Toyota","Maicol");
        motoClasica = new MotoClasica("DEF456","Toyota","Tatiana",100);
        motoHibrida = new MotoHibrida("GHI789","Toyota", "Ronal",170);
    }

    @Test
    void testRegistrarIngreso() {
        LocalDateTime ahora = LocalDateTime.now();
        parqueadero.registrarIngreso(carro, ahora);

        assertEquals(ahora, carro.getHoraIngreso());
    }

    @Test
    void testRegistrarSalidaCarro() {
        LocalDateTime horaIngreso = LocalDateTime.now().minusHours(2);
        LocalDateTime horaSalida = LocalDateTime.now();
        parqueadero.registrarIngreso(carro, horaIngreso);
        parqueadero.registrarSalida(carro, horaSalida);

        assertEquals(10.0, parqueadero.ingresosDiariosCarros);
    }

    @Test
    void testRegistrarSalidaMotoClasica() {
        LocalDateTime horaIngreso = LocalDateTime.now().minusHours(3);
        LocalDateTime horaSalida = LocalDateTime.now();
        parqueadero.registrarIngreso(motoClasica, horaIngreso);
        parqueadero.registrarSalida(motoClasica, horaSalida);

        assertEquals(9.0, parqueadero.ingresosDiariosMotosClasicas);
    }

    @Test
    void testRegistrarSalidaMotoHibrida() {
        LocalDateTime horaIngreso = LocalDateTime.now().minusHours(1);
        LocalDateTime horaSalida = LocalDateTime.now();
        parqueadero.registrarIngreso(motoHibrida, horaIngreso);
        parqueadero.registrarSalida(motoHibrida, horaSalida);

        assertEquals(4.0, parqueadero.ingresosDiariosMotosHibridas);
    }

    @Test
    void testGenerarReporteDiario() {
        LocalDateTime horaIngreso = LocalDateTime.now().minusHours(1);
        LocalDateTime horaSalida = LocalDateTime.now();
        parqueadero.registrarIngreso(carro, horaIngreso);
        parqueadero.registrarSalida(carro, horaSalida);

        parqueadero.generarReporteDiario();
        assertEquals(5.0, parqueadero.ingresosDiariosCarros);
    }
}
