/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alvarez.concesionariadeautos.modelo;

public class Vendedor extends Usuario {

    private String id;
    private int ventasAprobadas=0;

    public Vendedor(String id, String nombres, String apellidos, String usuario, String password) {
        super(nombres, apellidos, usuario, password);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void enviarCotizacion(Cliente usuario, Vehiculo vehiculo, Solicitud solicitud) {
        usuario.addMensaje(new MensajeCotizacion(vehiculo, usuario, this, "Ha recibido la informacion completa del vehiculo que cotizo ", solicitud));

        solicitud.setEstado(EstadoSolicitud.APROBADA);
        usuario.getSolicitudes().get(usuario.solicitudes.indexOf(solicitud)).setEstado(EstadoSolicitud.APROBADA);//

    }

    public void rechazarCotizacion(Cliente usuario, String motivo, Solicitud solicitud,Vehiculo vehiculo) {
        usuario.addMensaje(new MensajeCotizacion(vehiculo,usuario, this, motivo, solicitud));

        solicitud.setEstado(EstadoSolicitud.RECHAZADA);
        usuario.getSolicitudes().get(usuario.solicitudes.indexOf(solicitud)).setEstado(EstadoSolicitud.RECHAZADA);
    }

    public void setVentasAprobadas(int ventasAprobadas) {
        this.ventasAprobadas = ventasAprobadas;
    }

    public int getVentasAprobadas() {
        return ventasAprobadas;
    }
    
    
    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion() + ", vendedor con id=" + id + '}';
    }

    public void eliminarSolicitud(Solicitud solicitud) {
        this.solicitudes.remove(solicitud);
    }
    //pROBAND

}
