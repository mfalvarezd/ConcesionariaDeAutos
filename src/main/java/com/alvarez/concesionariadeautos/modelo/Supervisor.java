/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alvarez.concesionariadeautos.modelo;

import java.util.ArrayList;


public class Supervisor extends Usuario {

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

    public void aprobarCompra(Cliente usuario, Vehiculo vehiculo, Solicitud solicitud) {
        solicitud.setEstado(EstadoSolicitud.APROBADA);
        

        usuario.addMensaje(new MensajeCompra(vehiculo, usuario, this, "Se ha aprobado su solicitud de compra para el vehiculo " + vehiculo.mostrarInformacion() + " le comunicaremos pronto cuando su vehiculo este listo para entrega", solicitud));
        vehiculo.setEstado(EstadoVehiculo.SOLICITADO);

    }

    public void rechazarCompra(Cliente usuario, String motivo, Vehiculo vehiculo,Solicitud solicitud) {
        solicitud.setEstado(EstadoSolicitud.RECHAZADA);
        usuario.addMensaje(new MensajeCompra(usuario, this, motivo,solicitud));
        usuario.getSolicitudes().remove(solicitud);
        

    }
    public void aggVentasAprobadas(Vendedor vendedor){
        vendedor.setVentasAprobadas(vendedor.getVentasAprobadas()+1);
    }

    /**
     *
     * @return
     */
    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion() + ", certificacionesAcademicas=" + certificacionesAcademicas + '}';
    }

}
