/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alvarez.concesionariadeautos.modelo;


public class Mantenimiento extends Solicitud{
    
    private TipoMantenimiento tipoMantenimiento;
    private EstadoMantenimiento estadoDeMantenimiento;

    public Mantenimiento(Usuario usuario, Vehiculo vehiculo,TipoMantenimiento tipoMantenimiento) {
        super(usuario, vehiculo);
        this.tipoMantenimiento=tipoMantenimiento;
        
    }

    public EstadoMantenimiento getEstadoDeMantenimiento() {
        return estadoDeMantenimiento;
    }

    public void setEstadoDeMantenimiento(EstadoMantenimiento estadoDeMantenimiento) {
        this.estadoDeMantenimiento = estadoDeMantenimiento;
    }
    public void setTipoMantenimiento(TipoMantenimiento tipoMantenimiento){
        this.tipoMantenimiento=tipoMantenimiento;
    }

    public TipoMantenimiento getTipoMantenimiento() {
        return tipoMantenimiento;
    }
    
    @Override
    public String mostrarInformacion(){
        return "Mantenimiento {El usuario "+ usuario.getUsuario()+" solicita el mantenimiento " +tipoMantenimiento+ " del vehiculo "+vehiculo.mostrarInformacionCliente()+"}";
    }
    
}
