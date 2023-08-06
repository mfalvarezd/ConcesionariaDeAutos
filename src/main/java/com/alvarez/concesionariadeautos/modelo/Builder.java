/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alvarez.concesionariadeautos.modelo;

/**
 *
 * @author leo
 */
public interface Builder {
    

    public void setPropietario(Cliente propietario);

    public void setKilometraje(double kilometraje);
    
    public void setEstadoMantenimiento(EstadoMantenimiento estadoMantenimiento);

    public void setMarca(String marca);
    
    public void setModelo(String modelo);
    
    public void setAnioFabricacion(int anioFabricacion);
   
    public void setTipoMotor(TipoMotor tipoMotor);
    
    public void setPrecio(double precio) ;
   
    public void setEstado(EstadoVehiculo estado);   

    public void setConcesionaria(String concesionaria);   

    public void setNumLlantas(int numLlantas) ;
    
    
}
