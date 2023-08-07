/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alvarez.concesionariadeautos.modelo;

/**
 *
 * @author leo
 */
public class CamionBuilder implements Builder{
    private Camion result;
    

    public CamionBuilder() {
        this.result=new Camion();
    }
    
    
    @Override
    public void setMarca(String marca) {
        result.marca = marca;
    }

    @Override
    public void setModelo(String modelo) {
        result.modelo = modelo;
    }

    @Override
    public void setAnioFabricacion(int anioFabricacion) {
        result.anioFabricacion = anioFabricacion;
    }

    @Override
    public void setTipoMotor(TipoMotor tipoMotor) {
        result.tipoMotor = tipoMotor;
    }

    @Override
    public void setNumLlantas(int numLlantas) {
        result.numLlantas = numLlantas;
    }

    @Override
    public void setPrecio(double precio) {
        result.precio = precio;
    }

    @Override
    public void setEstado(EstadoVehiculo estado) {
        result.estado = estado;
    }

    @Override
    public void setEstadoMantenimiento(EstadoMantenimiento estadoMantenimiento) {
        result.estadoMantenimiento = estadoMantenimiento;
    }

    @Override
    public void setKilometraje(double kilometraje) {
        result.kilometraje = kilometraje;
    }

    @Override
    public void setConcesionaria(String concesionaria) {
        result.concesionaria = concesionaria;
    }

    @Override
    public void setPropietario(Cliente propietario) {
        result.propietario = propietario;
    }

    public void setCapacidadCarga(double capacidadCarga) {
        result.setCapacidadCarga(capacidadCarga);
    }

    public void setNumEjes(int numEjes) {
        result.setNumEjes(numEjes);
    }
    
    
    

    

    

    public Camion getResult() {
        return result;
    }
    
    
    public void reset(){
        this.result= new Camion();
        
    }
    
    
    
}
