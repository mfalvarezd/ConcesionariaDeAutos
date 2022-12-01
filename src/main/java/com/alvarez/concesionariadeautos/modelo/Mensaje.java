/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alvarez.concesionariadeautos.modelo;


public abstract class Mensaje {
    private Usuario receptor;
    private Usuario emisor;
    private String mensaje;
    public Solicitud solicitud;

    public Mensaje(Usuario receptor, Usuario emisor, String mensaje,Solicitud solicitud) {
        this(receptor,emisor,mensaje);
        this.solicitud=solicitud;
    }
     public Mensaje(Usuario receptor, Usuario emisor, String mensaje) {
        this.receptor = receptor;
        this.emisor = emisor;
        this.mensaje = mensaje;
        
    }

    public Usuario getReceptor() {
        return receptor;
    }

    public void setReceptor(Usuario receptor) {
        this.receptor = receptor;
    }

    public Usuario getEmisor() {
        return emisor;
    }

    public void setEmisor(Usuario emisor) {
        this.emisor = emisor;
    }

    public String getMensaje() {
        return mensaje;
    }

    public void setMensaje(String Mensaje) {
        this.mensaje = Mensaje;
    }

    public Solicitud getSolicitud() {
        return solicitud;
    }

    public void setSolicitud(Solicitud solicitud) {
        this.solicitud = solicitud;
    }
    

    @Override
    public String toString() {
        return "Mensaje{" + "El usuario " + emisor.nombres+" "+ emisor.apellidos +  " envia el Mensaje: " + mensaje.toUpperCase() + '}';
    }
    
    
}
