package co.edu.uniquindio.poo;

import java.time.LocalDateTime;

abstract class Vehicle {

    protected String placa;
    protected String modelo;
    protected String propietario;
    protected LocalDateTime horaIngreso;

    public Vehicle(String placa, String modelo, String propietario) {
        this.placa = placa;
        this.modelo = modelo;
        this.propietario = propietario;
        this.horaIngreso = LocalDateTime.now();
    }
    
    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPropietario() {
        return propietario;
    }

    public void setPropietario(String propietario) {
        this.propietario = propietario;
    }

    public LocalDateTime getHoraIngreso() {
    return this.horaIngreso;
    }
   
    public void setHoraIngreso(LocalDateTime horaIngreso) {
        this.horaIngreso = horaIngreso;
    }
}