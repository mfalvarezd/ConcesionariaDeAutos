/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alvarez.concesionariadeautos.modelo;

public class MensajeConfirmacion extends Mensaje{

    public MensajeConfirmacion(Usuario receptor, Usuario emisor, String mensaje,Solicitud solicitud) {
        super(receptor, emisor, mensaje,solicitud);
    }
    public MensajeConfirmacion(Usuario receptor, Usuario emisor, String mensaje){
        super(receptor,emisor,mensaje);
    }
    
    
    
}
