/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alvarez.concesionariadeautos.modelo;

/**
 *
 * @author leo
 */
public class MensajeVehiculoDecorator extends MensajeDecorator {
    private Vehiculo vehiculo;

    public MensajeVehiculoDecorator(Mensaje mensaje, Vehiculo vehiculo) {
        super(mensaje);
        this.vehiculo = vehiculo;
    }

    @Override
    public String getMensaje() {
        return mensaje.getMensaje() + "\nVehiculo: " + vehiculo.toString();
    }
}
