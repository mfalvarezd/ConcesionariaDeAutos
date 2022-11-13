/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alvarez.concesionariadeautos.modelo;

/**
 *
 * @author Moises Alvarez
 */
public abstract class Vehiculo {
    protected String marca;
    protected String modelo;
    protected int anioFabricacion;
    protected TipoMotor tipoMotor;
    protected int numLlantas;
    protected double precio;
    protected EstadoVehiculo estado;
    protected EstadoMantenimiento estadoMantenimiento;
    protected double kilometraje;
    protected String concesionaria;

    public Vehiculo(String marca, String modelo, int anioFabricacion, TipoMotor tipoMotor, int numLlantas, double precio, EstadoVehiculo estado,double kilometraje, String concesionaria) {
        this.marca = marca;
        this.modelo = modelo;
        this.anioFabricacion = anioFabricacion;
        this.tipoMotor = tipoMotor;
        this.numLlantas = numLlantas;
        this.precio = precio;
        this.estado = estado;
        this.kilometraje=kilometraje;
        this.concesionaria = concesionaria;
    }

    public double getKilometraje() {
        return kilometraje;
    }

    public void setKilometraje(double kilometraje) {
        this.kilometraje = kilometraje;
    }
    
    public void setEstadoMantenimiento(EstadoMantenimiento estadoMantenimiento) {
        this.estadoMantenimiento = estadoMantenimiento;
    }
    
    

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getAnioFabricacion() {
        return anioFabricacion;
    }

    public void setAnioFabricacion(int anioFabricacion) {
        this.anioFabricacion = anioFabricacion;
    }

    public TipoMotor getTipoMotor() {
        return tipoMotor;
    }

    public void setTipoMotor(TipoMotor tipoMotor) {
        this.tipoMotor = tipoMotor;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public EstadoVehiculo getEstado() {
        return estado;
    }

    public void setEstado(EstadoVehiculo estado) {
        this.estado = estado;
    }

    public String getConcesionaria() {
        return concesionaria;
    }

    public void setConcesionaria(String concesionaria) {
        this.concesionaria = concesionaria;
    }

    

    public int getNumLlantas() {
        return numLlantas;
    }

    public void setNumLlantas(int numLlantas) {
        this.numLlantas = numLlantas;
    }
    
    public String getInformacionParaCliente(){
        return this.marca+" "+this.modelo;
    }

 
    public String mostrarInformacion() {
        return "Vehiculo{" + "marca=" + marca + ", modelo=" + modelo + ", anioFabricacion=" + anioFabricacion + ", tipoMotor=" + tipoMotor + ", numLlantas=" + numLlantas + ", precio=" + precio + ", estado=" + estado + ", kilometraje=" + kilometraje + ", concesionaria=" + concesionaria;
    }
    public String mostrarInformacionCliente(){
        return "Vehiculo{ "+ "marca="+ marca +", modelo="+modelo;
    }

    


    public EstadoMantenimiento getEstadoMantenimiento() {
        return estadoMantenimiento;
    }


}
