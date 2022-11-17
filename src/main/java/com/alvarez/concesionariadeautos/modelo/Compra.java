/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alvarez.concesionariadeautos.modelo;

/**
 *
 * @author Moises Alvarez
 */
//Compra
public class Compra extends Solicitud {

    public Compra(Usuario usuario, Vehiculo vehiculo) {
        super(usuario, vehiculo);
    }
    
    @Override
    public String mostrarInformacion(){
        return "Compra {El usuario "+ usuario.getNombres()+" solicita la compra del vehiculo "+vehiculo.mostrarInformacionCliente();
    }
}
