/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alvarez.concesionariadeautos.modelo;

public class Vendedor extends Usuario {

    private String id;
    private int ventasAprobadas = 0;

    public Vendedor(String id, String nombres, String apellidos, String usuario, String password) {
        super(nombres, apellidos, usuario, password);
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void enviarCotizacion(Cliente usuario, Vehiculo vehiculo, Solicitud solicitud, String mensaje) {
        usuario.addMensaje(new MensajeCotizacion(vehiculo, usuario, this, mensaje, solicitud));
        actualizarEstadoSolicitud(usuario, solicitud, EstadoSolicitud.APROBADA);
    }

    public void rechazarCotizacion(Cliente usuario, String motivo, Solicitud solicitud, Vehiculo vehiculo) {
        usuario.addMensaje(new MensajeCotizacion(vehiculo, usuario, this, motivo, solicitud));
        actualizarEstadoSolicitud(usuario, solicitud, EstadoSolicitud.RECHAZADA);
    }

    private void actualizarEstadoSolicitud(Cliente usuario, Solicitud solicitud, EstadoSolicitud estado) {
        solicitud.setEstado(estado);
        int index = usuario.solicitudes.indexOf(solicitud);
        if (index != -1) {
            usuario.getSolicitudes().get(index).setEstado(estado);
        }
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

    public void enviarCotizacion(Cliente cliente, Vehiculo vehiculo, Solicitud solicitud) {
        throw new UnsupportedOperationException("Not supported yet."); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/GeneratedMethodBody
    }
}
