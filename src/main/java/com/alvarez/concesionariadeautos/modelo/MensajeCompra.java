/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alvarez.concesionariadeautos.modelo;

public class MensajeCompra extends Mensaje{
    private Vehiculo vehiculo;

    public MensajeCompra(Vehiculo vehiculo,Usuario receptor, Usuario emisor, String mensaje,Solicitud solicitud) {
        super(receptor, emisor, mensaje,solicitud);
        this.vehiculo=vehiculo;
    }
    public MensajeCompra(Usuario receptor, Usuario emisor, String mensaje,Solicitud solicitud) {
        super(receptor, emisor, mensaje,solicitud);
        
    }
    
    
    
}
