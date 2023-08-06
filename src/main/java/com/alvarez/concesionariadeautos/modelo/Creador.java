/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alvarez.concesionariadeautos.modelo;

/**
 *
 * @author leo
 */
public class Creador {
    private MotocicletaBuilder moto;
    private TractorBuilder tractor;
    private AutomovilBuilder auto;
    private CamionBuilder camion;

    public Creador(MotocicletaBuilder moto, TractorBuilder tractor, AutomovilBuilder auto, CamionBuilder camion) {
        this.moto = moto;
        this.tractor = tractor;
        this.auto = auto;
        this.camion = camion;
    }
    
    
    public Motocicleta crearMotocicleta(String marca, String modelo, int anioFabricacion, TipoMotor tipoMotor, int numLlantas, double precio, EstadoVehiculo estado, double kilometraje, String concesionaria,Cliente propietario, MotoCategoria categoria){
        this.moto.setMarca(marca);
        this.moto.setAnioFabricacion(anioFabricacion);
        this.moto.setCategoria(categoria);
        this.moto.setConcesionaria(concesionaria);
        this.moto.setEstado(estado);
        this.moto.setEstadoMantenimiento(EstadoMantenimiento.ADMITIDO);
        this.moto.setKilometraje(kilometraje);
        this.moto.setModelo(modelo);
        this.moto.setNumLlantas(2);
        this.moto.setPrecio(precio);
        this.moto.setPropietario(propietario);
        this.moto.setTipoMotor(tipoMotor);
        
        return this.moto.getResult();
    }
    
    public Tractor crearTractor(boolean esAgricola, TipoTransmision tipoTransmision,String marca, String modelo, int anioFabricacion, TipoMotor tipoMotor, int numLlantas, double precio, EstadoVehiculo estado, double kilometraje, String concesionaria, Cliente propietario){
        this.tractor.setMarca(marca);
        this.tractor.setAnioFabricacion(anioFabricacion);
        this.tractor.setConcesionaria(concesionaria);
        this.tractor.setEstado(estado);
        this.tractor.setEstadoMantenimiento(EstadoMantenimiento.ADMITIDO);
        this.tractor.setKilometraje(kilometraje);
        this.tractor.setModelo(modelo);
        this.tractor.setNumLlantas(4);
        this.tractor.setPrecio(precio);
        this.tractor.setPropietario(propietario);
        
        //todos los parametros
        return this.tractor.getResult();
    }
    
    public Automovil crearAutomovil(String marca, String modelo, int anioFabricacion, TipoMotor tipoMotor, int numLlantas, double precio, EstadoVehiculo estado, double kilometraje, String concesionaria, Cliente propietario){
        this.auto.setMarca(marca);
        this.auto.setMarca(marca);
        this.auto.setAnioFabricacion(anioFabricacion);
        this.auto.setConcesionaria(concesionaria);
        this.auto.setEstado(estado);
        this.auto.setEstadoMantenimiento(EstadoMantenimiento.ADMITIDO);
        this.auto.setKilometraje(kilometraje);
        this.auto.setModelo(modelo);
        this.auto.setNumLlantas(4);
        this.auto.setPrecio(precio);
        this.auto.setPropietario(propietario);
        //todos los parametros
        return this.auto.getResult();
    }
    
    public Camion crearCamion(String marca, String modelo, int anioFabricacion, TipoMotor tipoMotor, int numLlantas, double precio, EstadoVehiculo estado, double kilometraje, String concesionaria, Cliente propietario){
        this.camion.setMarca(marca);
        this.camion.setMarca(marca);
        this.camion.setAnioFabricacion(anioFabricacion);
        this.camion.setConcesionaria(concesionaria);
        this.camion.setEstado(estado);
        this.camion.setEstadoMantenimiento(EstadoMantenimiento.ADMITIDO);
        this.camion.setKilometraje(kilometraje);
        this.camion.setModelo(modelo);
        this.camion.setNumLlantas(numLlantas);
        this.camion.setPrecio(precio);
        this.camion.setPropietario(propietario);
        //todos los parametros
        return this.camion.getResult();
    }
}
