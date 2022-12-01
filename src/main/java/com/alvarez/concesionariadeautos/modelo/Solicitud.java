/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alvarez.concesionariadeautos.modelo;


public abstract class Solicitud {
    
    protected Usuario usuario;
    protected Vehiculo vehiculo;
    protected EstadoSolicitud estado;
    public Solicitud(){
        
    }

    public Solicitud(Usuario usuario, Vehiculo vehiculo) {
        this.usuario = usuario;
        this.vehiculo = vehiculo;
        this.estado=EstadoSolicitud.PENDIENTE;
    }
    

    public Usuario getUsuario() {
        return usuario;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public EstadoSolicitud getEstado() {
        return estado;
    }

    public void setEstado(EstadoSolicitud estado) {
        this.estado = estado;
    }


    public String mostrarInformacion() {
        return "Solicitud{" + "usuario=" + usuario + ", vehiculo=" + vehiculo + ", estado=" + estado + '}';
    }

    
    

    
    
    
}