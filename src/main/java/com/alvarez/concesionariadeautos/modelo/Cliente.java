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
public class Cliente extends Usuario{
    private String cedula;
    private String ocupacion;
    private double ingresosM;
    private ArrayList<Vehiculo> vehiculos= new ArrayList<>();

    public Cliente(String cedula, String ocupacion, double ingresosM,String nombres, String apellidos, String usuario, String password) {
        super(nombres, apellidos, usuario, password);
        this.cedula = cedula;
        this.ocupacion = ocupacion;
        this.ingresosM = ingresosM;

    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public String getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(String ocupacion) {
        this.ocupacion = ocupacion;
    }

    public double getIngresosM() {
        return ingresosM;
    }

    public void setIngresosM(double ingresosM) {
        this.ingresosM = ingresosM;
    }

    public ArrayList<Vehiculo> getVehiculos() {
        return vehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.vehiculos = vehiculos;
    }
    public Cotizacion cotizarVehiculo(Vehiculo vehiculo){
        return new Cotizacion( this, vehiculo);
        
    }
    public Compra comprarVehiculo(Vehiculo vehiculo){
        return new Compra(this,vehiculo);
    }
    public Mantenimiento mantenerAuto(Vehiculo vehiculo){
        return new Mantenimiento(this, vehiculo);
    }
    
    @Override
    public boolean tieneMensaje(){
        return this.solicitudes.isEmpty();
    }
    
    /**
     *
     */
    @Override
    public void leerMensajes(){
        
        for(Mensaje mensaje: mensajes){
            System.out.println(mensaje);
        }
    }
    public boolean verificarSolicitud(Vehiculo vehiculo){
        boolean validacion=false;
        for(Solicitud solicitud: solicitudes){
            if(solicitud.getVehiculo().equals(vehiculo)){
                validacion=true;
            }
        }
        return validacion;
    }
    
    /**
     *
     * @return
     */
    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion()+", cedula=" + cedula + ", ocupacion=" + ocupacion + ", ingresosM=" + ingresosM + ", vehiculos=" + vehiculos + '}';
    }
    
    

    


    


}