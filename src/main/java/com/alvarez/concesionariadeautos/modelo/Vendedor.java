/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alvarez.concesionariadeautos.modelo;

/**
 *
 * @author Moises Alvarez
 */
public class Vendedor extends Usuario{
    private String id;

    public Vendedor(String id, String nombres, String apellidos, String usuario, String password) {
        super(nombres, apellidos, usuario, password);
        this.id = id;
    }

    public String getId() {
        return id;
    } 
    
    public void enviarCotizacion(Cliente usuario, Vehiculo vehiculo){
        usuario.addMensaje(new Mensaje(usuario, this,"Ha recibido la informacion completa del vehiculo que cotizo "+ vehiculo.mostrarInformacion()));
        for(Solicitud solicitud: solicitudes){
            if( solicitud.getUsuario().equals(usuario.getUsuario())){
                solicitud.setEstado(EstadoSolicitud.PENDIENTE);
            }
        }
    }
    public void rechazarCotizacion(Cliente usuario, String motivo){
        usuario.addMensaje(new Mensaje(usuario, this, motivo));
        for(Solicitud solicitud: solicitudes){
            if(solicitud.getUsuario().equals(usuario.getUsuario())){
                solicitud.setEstado(EstadoSolicitud.RECHAZADA);
            }
        }
    }

    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion()+", vendedor con id=" + id + '}';
    }
    public void eliminarSolicitud(Solicitud solicitud){
        this.solicitudes.remove(solicitud);
    }
    
    


}