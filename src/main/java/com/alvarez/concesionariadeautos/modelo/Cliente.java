/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alvarez.concesionariadeautos.modelo;

import java.util.ArrayList;


public class Cliente extends Usuario{
    private String cedula;
    private String ocupacion;
    private double ingresosM;
    private ArrayList<Vehiculo> listadeVehiculos= new ArrayList<>();
    public Cliente(){
        super();
        
    }

    public Cliente(String cedula, String ocupacion, double ingresosM,String nombres, String apellidos, String usuario, String password) {
        super(nombres, apellidos, usuario, password);
        this.cedula = cedula;
        this.ocupacion = ocupacion;
        this.ingresosM = ingresosM;

    }public Cliente(String cedula, String ocupacion, double ingresosM,String nombres, String apellidos, String usuario, String password,ArrayList<Vehiculo> lista) {
        super(nombres, apellidos, usuario, password);
        this.cedula = cedula;
        this.ocupacion = ocupacion;
        this.ingresosM = ingresosM;
        this.listadeVehiculos=lista;
        for(Vehiculo v: listadeVehiculos){
            v.setPropietario(this);
        }

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
        return listadeVehiculos;
    }

    public void setVehiculos(ArrayList<Vehiculo> vehiculos) {
        this.listadeVehiculos = vehiculos;
    }
    public Cotizacion cotizarVehiculo(Vehiculo vehiculo){
        return new Cotizacion( this, vehiculo);
        
    }
    public Compra comprarVehiculo(Vehiculo vehiculo,Vendedor vendedor){
        return new Compra(this,vehiculo,vendedor);
    }
    public Mantenimiento mantenerAuto(Vehiculo vehiculo,TipoMantenimiento tipoMantenimiento){
        return new Mantenimiento(this, vehiculo,tipoMantenimiento);
    }
    public void addVehiculo(Vehiculo vehiculo){
        this.listadeVehiculos.add(vehiculo);
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
        return super.mostrarInformacion()+", cedula=" + cedula + ", ocupacion=" + ocupacion + ", ingresosM=" + ingresosM + ", vehiculos=" + listadeVehiculos + '}';
    }
    
    

    


    


}