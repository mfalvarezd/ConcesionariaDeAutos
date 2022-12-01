/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alvarez.concesionariadeautos.modelo;


public class Cotizacion extends Solicitud{

    public Cotizacion(Usuario usuario, Vehiculo vehiculo) {
        super(usuario, vehiculo);
    }

    @Override
    public String mostrarInformacion() {
        return "Cotizacion {El usuario:"+ usuario.usuario+" solicita la cotizacion del vehiculo "+vehiculo.mostrarInformacionCliente()+" el estado de su solicitud es: "+estado+'}';
    }
    
    
    
}
