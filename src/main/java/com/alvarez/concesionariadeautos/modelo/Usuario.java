/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alvarez.concesionariadeautos.modelo;

import java.util.ArrayList;

public abstract class Usuario {



    protected String nombres;
    protected String apellidos;
    protected String usuario;
    protected String password;
    protected ArrayList<Solicitud> solicitudes = new ArrayList<>();
    protected ArrayList<Mensaje> mensajes = new ArrayList<>();
    public Usuario(){
        
    }

    public Usuario(String nombres, String apellidos, String usuario, String password) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.usuario = usuario;
        this.password = password;
    }

    public String getNombres() {
        return nombres;
    }

    public void setNombres(String nombres) {
        this.nombres = nombres;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public ArrayList<Solicitud> getSolicitudes() {
        return solicitudes;
    }

    public void setSolicitudes(ArrayList<Solicitud> solicitudes) {
        this.solicitudes = solicitudes;
    }

    public ArrayList<Mensaje> getMensajes() {
        return mensajes;
    }

    public void setMensajes(ArrayList<Mensaje> mensajes) {
        this.mensajes = mensajes;
    }

    public void addSolicitud(Solicitud solicitud) {
        this.solicitudes.add(solicitud);
    }

    public boolean tieneMensaje() {
        return this.solicitudes.isEmpty();
    }

    public void leerMensajes() {
        System.out.println("Tiene " + mensajes.size() + " mensaje(s) nuevo(s):");

        for (Mensaje mensaje : mensajes) {
            System.out.println(mensaje);
        }
    }

    public String mostrarInformacion() {
        return "Usuario{" + "nombres=" + nombres + ", apellidos=" + apellidos + ", usuario=" + usuario + ", password=" + password + ", solicitudes=" + solicitudes;
    }

    public void addMensaje(Mensaje mensaje) {
        this.mensajes.add(mensaje);
    }
    



    

}
