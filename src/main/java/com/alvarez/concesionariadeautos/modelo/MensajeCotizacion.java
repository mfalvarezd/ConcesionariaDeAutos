/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alvarez.concesionariadeautos.modelo;

public class MensajeCotizacion extends Mensaje{
    private Vehiculo vehiculo;
    
    public MensajeCotizacion(Vehiculo vehiculo,Usuario receptor, Usuario emisor, String mensaje,Solicitud solicitud){
        super(receptor,emisor, mensaje,solicitud);
        this.vehiculo=vehiculo;
    }
    public MensajeCotizacion(Usuario receptor, Usuario emisor, String mensaje,Solicitud solicitud){
        super(receptor,emisor,mensaje,solicitud);
    }
    public Vehiculo getVehiculo(){
        return vehiculo;
    }
    
}
