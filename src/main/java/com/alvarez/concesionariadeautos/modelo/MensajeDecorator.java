/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alvarez.concesionariadeautos.modelo;

/**
 *
 * @author leo
 */
public abstract class MensajeDecorator implements Mensaje {
     protected Mensaje mensaje;

    public MensajeDecorator(Mensaje mensaje) {
        this.mensaje = mensaje;
    }

    
}
