/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alvarez.concesionariadeautos.modelo;

import java.util.ArrayList;

/**
 *
 * @author Moises Alvarez
 */
public class Supervisor extends Usuario{
    private ArrayList<String> certificacionesAcademicas;

    public Supervisor(ArrayList<String> certificacionesAcademicas, String nombres, String apellidos, String usuario, String password) {
        super(nombres, apellidos, usuario, password);
        this.certificacionesAcademicas = certificacionesAcademicas;
    }

    public ArrayList<String> getCertificacionesAcademicas() {
        return certificacionesAcademicas;
    }

    public void setCertificacionesAcademicas(ArrayList<String> certificacionesAcademicas) {
        this.certificacionesAcademicas = certificacionesAcademicas;
    }
    
    public void aprobarCompra(Cliente usuario, Vehiculo vehiculo){
        usuario.addMensaje(new Mensaje(usuario, this, "Se ha aprobado su solicitud de compra para el vehiculo "+vehiculo.mostrarInformacion()+" le comunicaremos pronto cuando su vehiculo este listo para entrega"));
        vehiculo.setEstado(EstadoVehiculo.SOLICITADO);
        for(Solicitud solicitud: solicitudes){
            if(solicitud.getUsuario().equals(usuario.getUsuario())){
                solicitud.setEstado(EstadoSolicitud.APROBADA);
            }
        }
        
        
    }
    public void rechazarCompra(Cliente usuario, String motivo,Vehiculo vehiculo){
        usuario.addMensaje(new Mensaje(this, usuario, motivo));
        for(Solicitud solicitud: solicitudes){
            if(solicitud.getUsuario().equals(usuario.getUsuario())){
                solicitud.setEstado(EstadoSolicitud.RECHAZADA);
            }
        }
        
    }

    /**
     *
     * @return
     */
    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion()+", certificacionesAcademicas=" + certificacionesAcademicas + '}';
    }

    
    
}
