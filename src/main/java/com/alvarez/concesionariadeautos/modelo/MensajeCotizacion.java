/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alvarez.concesionariadeautos.modelo;

public class MensajeCotizacion implements Mensaje{
    private Usuario receptor;
    private Usuario emisor;
    private String mensaje;
    private Solicitud solicitud;
    private Vehiculo vehiculo;

    public MensajeCotizacion(Vehiculo vehiculo, Usuario receptor, Usuario emisor, String mensaje, Solicitud solicitud) {
        this.receptor = receptor;
        this.emisor = emisor;
        this.mensaje = mensaje;
        this.solicitud = solicitud;
        this.vehiculo = vehiculo;
    }

    @Override
    public String getMensaje() {
        return "Mensaje de cotización: " + mensaje + "\nVehiculo: " + vehiculo.toString();
    }
    
}
