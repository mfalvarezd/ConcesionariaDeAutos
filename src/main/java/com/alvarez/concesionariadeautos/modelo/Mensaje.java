/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alvarez.concesionariadeautos.modelo;

/**
 *
 * @author Moises Alvarez
 */
public class Mensaje {
    private Usuario receptor;
    private Usuario emisor;
    private String Mensaje;

    public Mensaje(Usuario receptor, Usuario emisor, String Mensaje) {
        this.receptor = receptor;
        this.emisor = emisor;
        this.Mensaje = Mensaje;
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
        return Mensaje;
    }

    public void setMensaje(String Mensaje) {
        this.Mensaje = Mensaje;
    }

    @Override
    public String toString() {
        return "Mensaje{" + "El usuario " + receptor.nombres+" "+ receptor.apellidos + "envia el Mensaje=" + Mensaje + '}';
    }
    
    
}
