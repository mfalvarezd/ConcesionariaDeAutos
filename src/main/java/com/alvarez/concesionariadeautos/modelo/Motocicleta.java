/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.alvarez.concesionariadeautos.modelo;


public class Motocicleta extends Vehiculo{
    private MotoCategoria categoria;

    public Motocicleta(MotoCategoria categoria, String marca, String modelo, int anioFabricacion, TipoMotor tipoMotor,double precio, EstadoVehiculo estado, double kilometraje, String concesionaria) {
        super(marca, modelo, anioFabricacion, tipoMotor, 2, precio, estado, kilometraje, concesionaria);
        this.categoria = categoria;
    }



    @Override
    public String mostrarInformacion() {
        return super.mostrarInformacion()+", "+categoria; // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }

    @Override
    public String mostrarInformacionCliente() {
        return super.mostrarInformacionCliente(); // Generated from nbfs://nbhost/SystemFileSystem/Templates/Classes/Code/OverriddenMethodBody
    }
    @Override
    public void mostrarDatos(){
        super.mostrarDatos();
        System.out.println("Categoria de moto: "+categoria);
    }
    
    
    
    
    
}
